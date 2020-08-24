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
		
		System.out.println("FlatMap Test");
		
		Function function=new Function<Integer, Flowable<? extends Integer>>(){

			@Override
			public Flowable<? extends Integer> apply(Integer t) throws Exception {
				// TODO Auto-generated method stub
				return Flowable.just(t,t);
			}
			
		};
		
		flowable = Flowable
					.just(10,20,30)
					.flatMap(function);
		
		flowable.subscribe(new DebugSubscriber<>());
		
	}
	
}
