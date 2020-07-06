package billPughSingleton;


public class Testing extends Thread{
	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(){
		    public void run(){
		        System.out.println("Thread1  Running");
		    	for (int i = 10; i > 0; i--) {
		            BillPughSingleton eg1 = BillPughSingleton.getInstance();
			    	BillPughSingleton eg2 = BillPughSingleton.getInstance();
			    	System.out.println("th1 "+ i + "  " + BillPughSingleton.getInstance());
		            try {	
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
		        System.out.println("Thread Stop");
		    }
		};
		thread1.start();
		
		Thread thread2 = new Thread(){
		    public void run(){
		        System.out.println("Thread2  Running");
		    	for (int i = 10; i > 0; i--) {
		            BillPughSingleton eg1 = BillPughSingleton.getInstance();
			    	BillPughSingleton eg2 = BillPughSingleton.getInstance();
			    	System.out.println("th2 "+ i + "  " +eg1.count);
		            try {	
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
		        System.out.println("Thread2 Stop");
		    }
		};
		thread2.start();
	}
	
	
	
}

