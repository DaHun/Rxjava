package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class ThreadTest2 {
	public static void main(String[] args) throws Exception {
		
		
		//CASE 1) ������ > �Һ���
		//�̶��� ���ο��� �������ؼ� ���� �ȹ���
		Flowable.interval(1000L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> System.out.println("emit : "+System.currentTimeMillis()+"�и���: "+data))
				.subscribe(data -> Thread.sleep(900L));
		
		Thread.sleep(10000L);
		
	
	}
	
}
