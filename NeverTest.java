package RxjavaPractice;

import java.time.LocalTime;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;

public class NeverTest {
	public static void main(String[] args) throws Exception {
		
		Flowable.error(new Exception("���� �߻�")).subscribe(new DebugSubscriber<>());
		
		Callable<IllegalArgumentException> callable = () -> new IllegalArgumentException("�߻� �ð�: "+LocalTime.now());
		
		Flowable.error(callable).subscribe(new DebugSubscriber<>());
	}
	
}
