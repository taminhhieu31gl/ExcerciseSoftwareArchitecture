package adapter2;

public class TranslatorAdapter2 implements JappaneseInterface{

	VietnameseClient VietnameseClient;
	String message;
	
	public TranslatorAdapter2(adapter2.VietnameseClient vietnameseClient, String message) {
		VietnameseClient = vietnameseClient;
		this.message = receive(message);
	}

	@Override
	public String receive(String message) {
		// TODO Auto-generated method stub
		return "こんにちは";
	}

}
