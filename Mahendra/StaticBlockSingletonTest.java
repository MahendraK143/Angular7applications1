class StaticBlockSingleton {
	private static StaticBlockSingleton eager;
	//static block initialization for exception handling
	static{
		
		eager=new StaticBlockSingleton();
	}
	private StaticBlockSingleton(){}
	public static StaticBlockSingleton getInstance(){
		return eager;
	}
}

public class StaticBlockSingletonTest{
	public static void main(String arg[]){
		StaticBlockSingleton e=StaticBlockSingleton.getInstance();
		StaticBlockSingleton e2=StaticBlockSingleton.getInstance();
		System.out.println(e);
		System.out.println(e2);
		System.out.println(e.equals(e2));
	}
}