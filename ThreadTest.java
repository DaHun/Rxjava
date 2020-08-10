package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class ThreadTest {
	public static void main(String[] args) throws Exception {
		
		//CASE 1) ������ < �Һ���
		//�����ڿ� �Һ����� ������� ���� ������� ���� ��� ������ ���� �� �ۿ� ����.
		Flowable.interval(500L, TimeUnit.MILLISECONDS)
				.doOnNext(data -> System.out.println("emit : "+System.currentTimeMillis()+"�и���: "+data))
				.subscribe(data -> Thread.sleep(3000L));
		
		Thread.sleep(10000L);
		
	
	}
	
}
