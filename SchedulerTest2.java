package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class SchedulerTest2 {
	public static void main(String[] args) throws Exception {
		
		
		Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
				.onBackpressureDrop();
		
		
		flowable
		.observeOn(Schedulers.computation(),false,2)
		.subscribe(new ResourceSubscriber<Long>() {

			@Override
			public void onNext(Long t) {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String threadName=Thread.currentThread().getName();
				System.out.println(threadName+": "+t);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Thread.sleep(3700);
	}
	
}
