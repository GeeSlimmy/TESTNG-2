package rough;
// Example of singleton design pattern
public class House {
	// Singleton - only one object of this class will be found
	public static House obj;
	String city;
	
	private House(){
		System.out.println("tt");
	}
	
	// return you house Object reference
	public static House getinstance(){
		if(obj==null){
			obj=new House();
			return obj;
		}else{
			return obj;
		}
		
	}

}
