package RxjavaPractice;

import io.reactivex.subscribers.DisposableSubscriber;

public class DebugSubscriber<T> extends DisposableSubscriber<T> {
	private String label;
	
	public DebugSubscriber() {
		super();
	}
	
	public DebugSubscriber(String label) {
		super();
		this.label=label;
	}

	@Override
	public void onNext(T t) {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		if(label==null) System.out.println(name+": "+t);
		else System.out.println(name+": "+label+": "+t);
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		if(label==null) System.out.println(name+": 에러 = "+t);
		else System.out.println(name+": "+label+"에러 = "+t);
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		if(label==null) System.out.println(name+": 완료");
		else System.out.println(name+": "+label+"완료");
	}
	
	
}
