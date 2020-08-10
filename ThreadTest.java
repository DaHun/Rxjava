package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class ThreadTest {
	public static void main(String[] args) throws Exception {
		
		//CASE 1) 생산자 < 소비자
		//생산자와 소비자의 스레드는 같은 스레드로 돌릴 경우 영향을 받을 수 밖에 없음.
		Flowable.interval(500L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> System.out.println("emit : "+System.currentTimeMillis()+"밀리초: "+data))
				.subscribe(data -> Thread.sleep(3000L));
		
		Thread.sleep(10000L);
		
	
	}
	
}
