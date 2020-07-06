package test;


public class Testing {
	public static void main(String[] args) {
//		EagerInitializedSingleton eg1 = EagerInitializedSingleton.getInstance();
//		EagerInitializedSingleton eg2 = EagerInitializedSingleton.getInstance();
		Thread thread1 = new Thread(){
		    public void run(){
		        System.out.println("Thread1  Running");
		    	for (int i = 10; i > 0; i--) {
		    		EagerInitializedSingleton eg1 = EagerInitializedSingleton.getInstance();
		    		EagerInitializedSingleton eg2 = EagerInitializedSingleton.getInstance();
			    	System.out.println("th1 "+ i + "  " +eg1.count);
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
		    		EagerInitializedSingleton eg1 = EagerInitializedSingleton.getInstance();
		    		EagerInitializedSingleton eg2 = EagerInitializedSingleton.getInstance();
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
