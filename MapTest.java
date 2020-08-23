package RxjavaPractice;

import io.reactivex.Flowable;

public class MapTest {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable = Flowable
				.just("A","B","C","D","E")
				.map(data -> data.toLowerCase());
		
		flowable.subscribe(new DebugSubscriber<>());
	}
	
}
