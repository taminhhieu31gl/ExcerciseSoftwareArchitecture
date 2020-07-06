package adapter2;

public class TestAdapter {
	public static void main(String[] args) {
		VietnameseClient vn = new VietnameseClient();
		
		TranslatorAdapter2 adapter2 = new TranslatorAdapter2(vn,vn.send("Xin Chào"));
		System.out.println("Đã chuyển: "+adapter2.message);
	}
}
