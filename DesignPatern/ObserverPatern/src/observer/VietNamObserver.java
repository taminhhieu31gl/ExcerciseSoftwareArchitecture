package observer;

public class VietNamObserver implements Observer {
	private ConcreateSubject concreateSubject;
	
	public VietNamObserver(ConcreateSubject c) {
		super();
		// TODO Auto-generated constructor stub
		this.concreateSubject = c;
		this.concreateSubject.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Đã Cập Nhật Phần Mềm");
	}

}
