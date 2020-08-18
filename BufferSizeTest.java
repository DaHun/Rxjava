package RxjavaPractice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class BufferSizeTest {
	public static void main(String[] args) throws Exception {
		
		Flowable<Long> flowable = Flowable.interval(10L, TimeUnit.MILLISECONDS)
				//톻지시 데이터를 출력한다
				.doOnNext(value -> System.out.println("emit: "+value));
		
		flowable
			//각 스레드에서 데이터를 받는다
			.observeOn(Schedulers.computation())
			.subscribe(new Subscriber<Long>() {

				@Override
				public void onSubscribe(Subscription s) {
					// TODO Auto-generated method stub
					//무제한으로 데이터를 통지한다
					s.request(Long.MAX_VALUE);
				}

				@Override
				public void onNext(Long value) {
					// TODO Auto-generated method stub
					try {
						System.out.println("waiting....");
						Thread.sleep(1000L);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("Received: "+value);
					
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
		
		Thread.sleep(5000L);
	}
	
}
