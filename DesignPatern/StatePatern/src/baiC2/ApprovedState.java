package baiC2;

public class ApprovedState implements State {
	 
    @Override
    public void handleRequest() {
        System.out.println("Approved");
    }
}