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
			System.out.println("Flowable ó�� ����");
			for(int i=1;i<=3;i++) {
				if(i==2) throw new Exception("���� �߻�");
				emitter.onNext(i);
			}
			
			emitter.onComplete();
			System.out.println("Flowable ó�� �Ϸ�");
		}, BackpressureStrategy.BUFFER)
				.doOnSubscribe(   // ����) ��� Flowable ������ �� �� �� ȣ��Ǵ� �Լ�
						subscription -> System.out.println("flowable : doOnSubscribe"))
				.retry(2);
		
		flowable.subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {   //��� Subscriber ������ �� �� �� ȣ��Ǵ� �Լ�
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
				System.out.println("����="+t);
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("����");
			}
			
		});
	}
	
}
