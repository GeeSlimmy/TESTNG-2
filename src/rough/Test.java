package rough;

public class Test {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		Car c2 = new Car();
		
		String x="Hello";
		System.out.println(c1==c2);
		c1=c2;
		System.out.println(c1==c2);
	}

}
