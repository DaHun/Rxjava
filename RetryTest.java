package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class RetryTest {
	public static void main(String[] args) throws Exception {
		
		
		Flowable<Integer> flowable = Flowable.<Integer> create(emitter -> {
			System.out.println("Flowable 처리 시작");
			for(int i=1;i<=3;i++) {
				if(i==2) throw new Exception("예외 발생");
				emitter.onNext(i);
			}
			
			emitter.onComplete();
			System.out.println("Flowable 처리 완료");
		}, BackpressureStrategy.BUFFER)
				.doOnSubscribe(   // 조심) 얘는 Flowable 시작할 때 한 번 호출되는 함수
						subscription -> System.out.println("flowable : doOnSubscribe"))
				.retry(2);
		
		flowable.subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {   //얘는 Subscriber 시작할 때 한 번 호출되는 함수
				// TODO Auto-generated method stub
				System.out.println("subscriber: OnSubscribe");
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("data="+t);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("에러="+t);
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("종료");
			}
			
		});
	}
	
}
