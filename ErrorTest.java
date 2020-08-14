package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.ResourceSubscriber;

public class ErrorTest {
	public static void main(String[] args) throws Exception {
		
		Flowable.just(1,3,5,0,2,4)
				.map(data -> 100/data)
				.onErrorReturnItem(0)
				.subscribe(new DisposableSubscriber<Integer>() {

					@Override
					public void onNext(Integer t) {
						// TODO Auto-generated method stub
						System.out.println("data="+t);
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						System.out.println("error="+t);
					}

					@Override
					public void onComplete() {
						// TODO Auto-generated method stub
						System.out.println("¿Ï·á");
					}
					
				});
	}
	
}
