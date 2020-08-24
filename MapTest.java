package RxjavaPractice;

import java.math.BigDecimal;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class MapTest {
	public static void main(String[] args) throws Exception {
		
		Flowable<String> flowable = Flowable
				.just("A","B","C","D","E")
				.map(data -> data.toLowerCase());
		
		flowable.subscribe(new DebugSubscriber<>());
		
		System.out.println("Mapper Test");
		
		
		Function function = new Function<String, String>(){

			@Override
			public String apply(String t) throws Exception {
				// TODO Auto-generated method stub
				return "Function Test: "+t;
			}
			
		};
				
		flowable = Flowable
				.just("A","B","C","D","E")
				.map(function);
		
		flowable.subscribe(new DebugSubscriber<>());
	}
	
}
