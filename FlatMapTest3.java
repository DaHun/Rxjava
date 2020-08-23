package RxjavaPractice;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class FlatMapTest3 {
	public static void main(String[] args) throws Exception {
		
		Flowable<Integer> original = Flowable.just(1,2,0,4,5)
				.map(data -> 10/data);
		
		Flowable<Integer> flowable = original
				.flatMap(
						data -> Flowable.just(data), //onNextMapper
						error -> Flowable.just(-1), //onErrorMapper
						() -> Flowable.just(100) //onCompleteSupplier
				);
		flowable.subscribe(new DebugSubscriber<>());
		
	}
	
}
