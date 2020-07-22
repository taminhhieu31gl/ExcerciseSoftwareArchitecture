package observer;

public class Client {
	public static void main(String[] args) {
		ConcreateSubject con = new ConcreateSubject();
		new MyObserver(con);
		new VietNamObserver(con);
		con.notifi();
	}
}
