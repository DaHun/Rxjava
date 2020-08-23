package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
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
	}
	
}
