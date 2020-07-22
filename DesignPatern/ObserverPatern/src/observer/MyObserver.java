package observer;

public class MyObserver implements Observer {
	private ConcreateSubject subject;
	
	public MyObserver(ConcreateSubject subject) {
		super();
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Updated Softwate");
	}

}
