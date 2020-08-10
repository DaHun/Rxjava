package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class SchedulerTest {
	public static void main(String[] args) throws Exception {
		
		
		//Scheduler Á¾·ù
		
		Flowable.just(1,2,3,4,5)
			//.subscribeOn(Schedulers.computation())
			//.subscribeOn(Schedulers.io())
			.subscribeOn(Schedulers.single())
			.subscribe(data -> {
				String threadName=Thread.currentThread().getName();
				System.out.println(threadName+": "+data);
			});
		
		
		Thread.sleep(1000);
	}
	
}
