package decorate;

public class Test {
	public static void main(String[] args) {
		MonChinh mc = new Cafe();
		mc = new Sua(mc);
		System.out.println(mc.getDonGia());
		System.out.println(mc.getMoTa());
	}
	
}
