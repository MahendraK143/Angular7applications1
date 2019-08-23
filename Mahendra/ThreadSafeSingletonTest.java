class ThreadSafeSingleton extends Thread {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}

	public static ThreadSafeSingleton getInstance(){
		if(instance == null){
			instance = new ThreadSafeSingleton();
			}
		return instance;
	}
	/*
	
	public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
    if(instance == null){
        synchronized (ThreadSafeSingleton.class) {
            if(instance == null){
                instance = new ThreadSafeSingleton();
            }
        }
    }
    return instance;
}
	*/
}

class ThreadSafeSingletonTestTT extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			if(i==5)
			try {
			Thread.sleep(1000);	
			}catch(Exception e){
				System.out.println("AAA");
			}
			ThreadSafeSingleton e=ThreadSafeSingleton.getInstance();
			ThreadSafeSingleton e2=ThreadSafeSingleton.getInstance();
			System.out.println("aaaaaaaaaaaaaaaaaaaa:"+e);
			System.out.println(e2);
			System.out.println(e.equals(e2));
			
		}
	}		
}
public class ThreadSafeSingletonTest{
	public static void main(String arg[]){
		ThreadSafeSingletonTestTT t=new ThreadSafeSingletonTestTT();
		t.start();
		ThreadSafeSingletonTestTT t1=new ThreadSafeSingletonTestTT();
		t1.start();
	}
}