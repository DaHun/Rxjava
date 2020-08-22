package RxjavaPractice;

import io.reactivex.Flowable;

public class ErrorTest2 {
	public static void main(String[] args) throws Exception {
		Flowable.never().subscribe(new DebugSubscriber<>());
	}
}
