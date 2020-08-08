package RxjavaPractice;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.ResourceSubscriber;

public class SubscribeWithTest {
	public static void main(String[] args) {
		
		Flowable<Integer> flowable=Flowable.create(new FlowableOnSubscribe<Integer>() {

			@Override
			public void subscribe(FlowableEmitter<Integer> e) throws Exception {
				// TODO Auto-generated method stub
				
				for(int i=0;i<1000000;i++) {
					if(e.isCancelled()) {
						return;
					}
					
					e.onNext(i);
				}
			}
			
		}, BackpressureStrategy.BUFFER);
		
		Disposable disposable=flowable.subscribeWith(new ResourceSubscriber() {

			@Override
			public void onNext(Object t) {
				// TODO Auto-generated method stub
				System.out.println(t.toString());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
