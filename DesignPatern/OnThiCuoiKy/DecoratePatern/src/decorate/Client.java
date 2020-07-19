package decorate;

public class Client {
	public static void main(String[] args) {
		MonChinh mon = new Cafe();
		mon = new Sua(mon);
		
		
		System.out.println(mon.getGia());

		System.out.println(mon.getMoTa());
	}
}
