package RxjavaPractice;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.subscribers.ResourceSubscriber;

public class RamdaTest {
	public static void main(String[] args) throws Exception {
		
		
		/////////
		BiFunction<Integer, Integer, BigDecimal> function=new BiFunction<Integer, Integer, BigDecimal>(){

			@Override
			public BigDecimal apply(Integer t1, Integer t2) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		
		
		///////////////
		BiFunction<Integer, Integer, BigDecimal> function2
			= (Integer value1, Integer value2) -> { 
				return new BigDecimal(value1+value2); 
			};
		
			
		///////////////
		BiFunction<Integer, Integer, BigDecimal> function3
			= (value1, value2) ->  new BigDecimal(value1+value2); 

			
	
	}
}
