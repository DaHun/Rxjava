package RxjavaPractice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class ConcatMapTest {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable 
		
		= Flowable.just("A","B","C")
				.concatMap(data -> {
					return Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS);
				});
		
		flowable.subscribe(data -> {
			String threadName = Thread.currentThread().getName();
			String time=LocalTime.now().format(DateTimeFormatter.ofPattern("ss.SSS"));
			System.out.println(threadName+": data="+data+", time="+time);
		});
		
		Thread.sleep(4000L);
		
	}
	
}
