package RxjavaPractice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class DeferTest {
	public static void main(String[] args) throws Exception {
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss.SSS");
		System.out.println("시작 시간 "+LocalTime.now().format(formatter));

		Flowable<Long> flowable = Flowable.timer(3000L, TimeUnit.MILLISECONDS);
		flowable.subscribe(
				data -> {
					String threadName = Thread.currentThread().getName();
					String time = LocalTime.now().format(formatter);
					System.out.println(threadName+": "+time+": data="+data);
				},
				error -> System.out.println("에러="+error),
				() -> System.out.println("완료")
		);
		
		Thread.sleep(5000L);
		
	}
	
}
