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
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.subscribers.ResourceSubscriber;

public class DifferenceOfThisTest {
	public static void main(String[] args) throws Exception {
		
		
		DifferenceOfThisTest test=new DifferenceOfThisTest();
		test.execute();
	}
	
	public void execute() throws Exception{
		Action anonymous=new Action() {

			@Override
			public void run() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("익명 클래스의 This : "+this);
			}
			
		};
		
		Action lamda = () -> System.out.println("lamda의 this : "+this);
		
		anonymous.run();
		lamda.run();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
}
