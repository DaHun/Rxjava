package RxjavaPractice;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.ResourceSubscriber;

public class SingleTest {
	public static void main(String[] args) {
		
		Single<DayOfWeek> single=Single.create(emitter -> {
			emitter.onSuccess(LocalDate.now().getDayOfWeek());
		});
		
		single.subscribe(new SingleObserver<DayOfWeek>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(DayOfWeek t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println(e);
			}
			
		});
	}
}
