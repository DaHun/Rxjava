package RxjavaPractice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class TimerTest {
	public static void main(String[] args) throws Exception {
	
//		Callable<Flowable<LocalTime>> callable = new Callable<Flowable<LocalTime>>() {
//
//			@Override
//			public Flowable<LocalTime> call() throws Exception {
//				// TODO Auto-generated method stub
//				return Flowable.just(LocalTime.now());
//			}
//			
//		};
//		
//		Callable<Flowable<LocalTime>> callable = () -> Flowable.just(LocalTime.now());
//		
//		
//		Flowable<LocalTime> flowable = Flowable.defer(callable);		

		Flowable<LocalTime> flowable = Flowable.defer(() -> Flowable.just(LocalTime.now()));

		flowable.subscribe(new DebugSubscriber<>("No. 1"));
		Thread.sleep(1000L);
		flowable.subscribe(new DebugSubscriber<>("No. 2"));
		
	} 
	
}
