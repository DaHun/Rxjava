package RxjavaPractice;

import java.util.concurrent.Callable;

import io.reactivex.Flowable;

public class CallableTest {
	public static void main(String[] args) throws Exception {
		
		Callable<Long> callable = () -> { return System.currentTimeMillis(); };
		
		Flowable<Long> flowable = Flowable.fromCallable(callable);
		flowable.subscribe(new DebugSubscriber<Long>());
	}
	
}
