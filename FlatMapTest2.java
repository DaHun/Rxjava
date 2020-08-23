package RxjavaPractice;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class FlatMapTest2 {
	public static void main(String[] args) throws Exception {
		
		
		Flowable<String> flowable = Flowable
				.just("A","","C","","E")
				.flatMap(data -> {
					if(data.equals("")) return Flowable.empty();
					else return Flowable.just(data.toLowerCase());
				});
		
		flowable.subscribe(new DebugSubscriber<>());
	}
	
}
