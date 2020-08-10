package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class ThreadTest2 {
	public static void main(String[] args) throws Exception {
		
		
		//CASE 1) 생산자 > 소비자
		//이때는 내부에서 조정을해서 영향 안받음
		Flowable.interval(1000L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> System.out.println("emit : "+System.currentTimeMillis()+"밀리초: "+data))
				.subscribe(data -> Thread.sleep(900L));
		
		Thread.sleep(10000L);
		
	
	}
	
}
