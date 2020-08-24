package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class FlatMapTest4 {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable = Flowable.range(1, 3)
			//mapper와 combiner를 인자로 받는 flatMap
								.flatMap(
										data -> { return Flowable.interval(100L, TimeUnit.MILLISECONDS).take(3); },
										(sourceData, newData) -> "["+sourceData+"] "+newData
								);
		flowable.subscribe(new DebugSubscriber<>());
		
		
		Thread.sleep(1000L);
		
		System.out.println("FlatMap Test");
		
		BiFunction biFunction = new BiFunction<Integer, Long, String>(){

			@Override
			public String apply(Integer t1, Long t2) throws Exception {
				// TODO Auto-generated method stub
				return "["+t1+"] "+t2;
			}
			
		};
		
		Flowable<String> flowable2 = Flowable.range(1, 3)
										.flatMap(
												data -> { return Flowable.interval(100L, TimeUnit.MILLISECONDS).take(3); },
												biFunction
												);
	
		flowable2.subscribe(new DebugSubscriber<>());

		
		Thread.sleep(1000L);
	}
	
}
