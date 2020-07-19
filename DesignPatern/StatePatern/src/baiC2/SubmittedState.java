package baiC2;

public class SubmittedState implements State {

	@Override
	public void handleRequest() {
		System.out.println("Submitted");
	}
}