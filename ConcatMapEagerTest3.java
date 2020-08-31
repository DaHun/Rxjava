package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class ConcatMapEagerTest3 {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable = Flowable.range(10, 3)
											.concatMapEagerDelayError(
													sourceData -> Flowable.interval(500L, TimeUnit.MILLISECONDS)
																			.take(3)
																			.doOnNext(data -> { if(sourceData == 11 && data == 1) throw new Exception("���� �߻�"); })
																			.map(data-> "["+sourceData+"] "+ data),
													true);
		
		flowable.subscribe(new DebugSubscriber<>());
		Thread.sleep(4000L);
		

	}
	
}
