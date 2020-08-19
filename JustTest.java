package RxjavaPractice;

import io.reactivex.Flowable;

public class JustTest {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable = Flowable.just("A","B","C","D","E");
		flowable.subscribe(new DebugSubscriber<>());
	}
	
}
