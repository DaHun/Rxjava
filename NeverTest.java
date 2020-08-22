package RxjavaPractice;

import java.time.LocalTime;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;

public class NeverTest {
	public static void main(String[] args) throws Exception {
		
		Flowable.error(new Exception("예외 발생")).subscribe(new DebugSubscriber<>());
		
		Callable<IllegalArgumentException> callable = () -> new IllegalArgumentException("발생 시각: "+LocalTime.now());
		
		Flowable.error(callable).subscribe(new DebugSubscriber<>());
	}
	
}
