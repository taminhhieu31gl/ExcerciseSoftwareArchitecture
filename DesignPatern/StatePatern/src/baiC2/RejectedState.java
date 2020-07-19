package baiC2;

public class RejectedState implements State {
	 
    @Override
    public void handleRequest() {
        System.out.println("Rejected");
    }
}