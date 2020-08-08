package RxjavaPractice;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.ResourceSubscriber;

public class MaybeTest {
	public static void main(String[] args) throws Exception {
		
		Maybe<DayOfWeek> maybe=Maybe.create(emitter -> {
			emitter.onSuccess(LocalDate.now().getDayOfWeek());
		});
		
		maybe.subscribe(new MaybeObserver<DayOfWeek>() {

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
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("¾øÀ½");
			}

		
			
		});
		
		Thread.sleep(1000);
	}
}
