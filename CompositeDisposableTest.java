package RxjavaPractice;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class CompositeDisposableTest {
	public static void main(String[] args) throws Exception {
		
		CompositeDisposable compositeDisposable=new CompositeDisposable();
		
		compositeDisposable.add(Flowable.range(1, 3)
				.doOnCancel(()-> System.out.println("No.1 canceled"))
				.observeOn(Schedulers.computation())
				.subscribe(data -> {
					Thread.sleep(100L);
					System.out.println("No.1 : "+data);
				}));
		
		
		compositeDisposable.add(Flowable.range(1, 3)
				.doOnCancel(()-> System.out.println("No.2 canceled"))
				.observeOn(Schedulers.computation())
				.subscribe(data -> {
					Thread.sleep(200L);
					System.out.println("No.2 : "+data);
				}));
		
		
		
		
		Thread.sleep(300);
		compositeDisposable.dispose();
	}
}
