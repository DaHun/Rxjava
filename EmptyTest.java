package RxjavaPractice;

import io.reactivex.Flowable;

public class EmptyTest {
	public static void main(String[] args) throws Exception {
	
		Flowable.empty().subscribe(new DebugSubscriber<>());
		
	} 
	
}
