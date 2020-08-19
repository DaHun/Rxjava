package RxjavaPractice;

import io.reactivex.Flowable;

public class FromArrayTest {
	public static void main(String[] args) throws Exception {
		
		String[] arr= {"AFDS","FDSFA","FDSFDAS"};
		Flowable<String> flowable = Flowable.fromArray(arr);
		flowable.subscribe(new DebugSubscriber<>());
		
	}
	
}
