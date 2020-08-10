package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class ThreadTest3 {
	public static void main(String[] args) throws Exception {
		
		
		
		//just, from ���� �Լ��� ���� �����忡�� ���ư�
		System.out.println("start");

		
		Flowable.just(1,2,3)
			.subscribe(new ResourceSubscriber<Integer>() {

				@Override
				public void onNext(Integer t) {
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
					System.out.println(threadName+": �Ϸ�");
				}
				
			});
		
		System.out.println("end");
	
	}
	
}
