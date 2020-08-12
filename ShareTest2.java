package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class ShareTest2 {
	public static void main(String[] args) throws Exception {
		
		final Counter counter = new Counter();
		
		Flowable<Integer> src1 
		= Flowable.range(1, 10000)
				.subscribeOn(Schedulers.computation()) //Flowable이 다른 스레드에서 작업 처리
				.observeOn(Schedulers.computation()); //다른 스레드에서 작업 처
				
		
		Flowable<Integer> src2
		= Flowable.range(1, 10000)
				.subscribeOn(Schedulers.computation())
				.observeOn(Schedulers.computation());
		
		Flowable.merge(src1, src2)
				.subscribe(
						data->counter.increment(),
						error->System.out.println(error),
						()->System.out.println(counter.get())
					);
		Thread.sleep(1000L);
	}
	
	
	
}

