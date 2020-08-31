package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class ConcatMapTest2 {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable = Flowable.range(10,3)
										.concatMap(
												sourceData -> Flowable.interval(500L, TimeUnit.MILLISECONDS)
																.take(2)
																.map(data -> {
																	long time = System.currentTimeMillis();
																	return time + "ms: ["+sourceData+"] "+data;
																	})
													);
												
		flowable.subscribe(new DebugSubscriber<>());
		
		
		
		Function function = new Function<Integer, Publisher<? extends String>>(){

			@Override
			public Publisher<? extends String> apply(Integer sourceData) throws Exception {
				// TODO Auto-generated method stub
				return Flowable.interval(400L, TimeUnit.MILLISECONDS)
								.map(data -> "["+sourceData+"] "+data);
			}
			
		};
		
	
		flowable = Flowable.range(10,3)
				.concatMap(function);
		
		
		flowable.subscribe(new DebugSubscriber<>());
		
		Thread.sleep(7000L);
		
	}
	
}
