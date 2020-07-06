package adapter;

public class TranslatorAdapter implements VietnameseTarget{
	private JapaneseAdaptee adaptee;
	 
    public TranslatorAdapter(JapaneseAdaptee adaptee) {
        this.adaptee = adaptee;
    }
 
    @Override
    public void send(String words) {
        System.out.println("Từ được nhập ...");
        System.out.println(words);
        String vietnameseWords = this.translate(words);
        System.out.println("Gửi đi ...");
        adaptee.receive(vietnameseWords);
    }
 
    private String translate(String vietnameseWords) {
        System.out.println("XONG!");
        return "こんにちは";
    }
}
