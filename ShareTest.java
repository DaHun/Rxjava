package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class ShareTest {
	public static void main(String[] args) throws Exception {
		
		final Counter counter = new Counter();
		
		Flowable.range(1, 10000)
				.subscribeOn(Schedulers.computation()) //Flowable이 다른 스레드에서 작업 처리
				.observeOn(Schedulers.computation()) //다른 스레드에서 작업 처
				.subscribe(
						data->counter.increment(),
						error->System.out.println(error),
						() -> System.out.println("1: "+counter.get())
				);
		
		Flowable.range(1, 10000)
				.subscribeOn(Schedulers.computation())
				.observeOn(Schedulers.computation())
				.subscribe(
						data->counter.increment(),
						error->System.out.println(error),
						()->System.out.println("2: "+counter.get())
					);
		
		
		Thread.sleep(1000L);
	}
	
	
	
}

class Counter{
	private volatile int count;
	
	void increment() {
		count++;
	}
	
	int get() {
		return count;
	}
}