package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class FlatMapTest {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable = 
		Flowable.just("A","B","C")
				.flatMap(data -> {
					return Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS);
				});
		
		flowable.subscribe(data -> {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName +": "+data);
		});
		
		Thread.sleep(2000L);
		
		
	}
	
}
