class LazyInitializedSingleton extends Thread {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}

	public static LazyInitializedSingleton getInstance(){
		if(instance == null){
			instance = new LazyInitializedSingleton();
			}
		return instance;
	}
}

class ThreadLazyInitializedSingleton extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			if(i==5)
			try {
			Thread.sleep(1000);	
			}catch(Exception e){
				System.out.println("AAA");
			}
			LazyInitializedSingleton e=LazyInitializedSingleton.getInstance();
			LazyInitializedSingleton e2=LazyInitializedSingleton.getInstance();
			System.out.println(e);
			System.out.println(e2);
			System.out.println(e.equals(e2));
			
		}
	}		
}
public class LazyInitializedSingletonTest{
	public static void main(String arg[]){
		ThreadLazyInitializedSingleton t=new ThreadLazyInitializedSingleton();
		t.start();
		ThreadLazyInitializedSingleton t1=new ThreadLazyInitializedSingleton();
		t1.start();
	}
}