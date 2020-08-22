package RxjavaPractice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class DeferTest {
	public static void main(String[] args) throws Exception {
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss.SSS");
		System.out.println("���� �ð� "+LocalTime.now().format(formatter));

		Flowable<Long> flowable = Flowable.timer(3000L, TimeUnit.MILLISECONDS);
		flowable.subscribe(
				data -> {
					String threadName = Thread.currentThread().getName();
					String time = LocalTime.now().format(formatter);
					System.out.println(threadName+": "+time+": data="+data);
				},
				error -> System.out.println("����="+error),
				() -> System.out.println("�Ϸ�")
		);
		
		Thread.sleep(5000L);
		
	}
	
}
