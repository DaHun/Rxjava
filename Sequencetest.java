package RxjavaPractice;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;

public class Sequencetest {
	public static void main(String[] args) {
		Flowable.range(1, 3)
		.subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(Long.MAX_VALUE);
				// TODO Auto-generated method stub
				System.out.println("OnSubscribe : start");
				
				System.out.println("OnSubscribe : end");

				
			}

			@Override
			public void onNext(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("에러 "+t);

			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("완료");

			}
			
		});
		
	}
}
