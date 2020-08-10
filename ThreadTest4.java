package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class ThreadTest4 {
	public static void main(String[] args) throws Exception {
		
		
		
		//interval 함수는 별도의 스레드에서 돌아감
		System.out.println("start");
		
		Flowable.interval(300L, TimeUnit.MILLISECONDS)
			.subscribe(new ResourceSubscriber<Long>() {

				@Override
				public void onNext(Long t) {
					// TODO Auto-generated method stub
					String threadName=Thread.currentThread().getName();
					System.out.println(threadName+": "+t);
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					String threadName=Thread.currentThread().getName();
					System.out.println(threadName+": 완료");
				}
				
			});
		
		System.out.println("end");
	
		Thread.sleep(1000L);
	}
	
}
