package RxjavaPractice;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class JustVSTimerTest {
	public static void main(String[] args) throws Exception {
	
	
		Flowable<LocalTime> flowable = Flowable.just(LocalTime.now());

		flowable.subscribe(new DebugSubscriber<>("No. 1"));
		Thread.sleep(1000L);
		flowable.subscribe(new DebugSubscriber<>("No. 2"));
		
	} 
	
}
