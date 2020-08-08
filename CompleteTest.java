package RxjavaPractice;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class CompleteTest {
	public static void main(String[] args) throws Exception {
		
		Completable completable=Completable.create(emitter -> {
			//중략(업무 로직 처리)
			
			//완료 통지
			emitter.onComplete();
		});
		
		
		completable
		.subscribeOn(Schedulers.computation())
		.subscribe(new CompletableObserver() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("완료");
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("에러"+e);
			}
			
		});
		
		Thread.sleep(1000);
	}
	
}
