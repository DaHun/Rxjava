package RxjavaPractice;

import io.reactivex.Flowable;

public class RangeTest {
	public static void main(String[] args) throws Exception {
		
		Flowable<Integer> flowable = Flowable.range(10, 3);
		flowable.subscribe(new DebugSubscriber<>());
	}
	
}
