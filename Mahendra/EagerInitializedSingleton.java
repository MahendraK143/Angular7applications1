class EagerInitializedSingleton {
	private static EagerInitializedSingleton eager=new EagerInitializedSingleton();
	private EagerInitializedSingleton(){}
	public static EagerInitializedSingleton getInstance(){
		return eager;
	}
}

public EagerInitializedSingletonTest{
	public static void main(String arg[]){
		EagerInitializedSingleton e=EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton e2=EagerInitializedSingleton.getInstance();
		System.out.println(e);
		System.out.println(e2);
	}
}
	