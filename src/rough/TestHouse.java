package rough;

public class TestHouse {
	// Singleton Design Pattern
	// All Ref pointing to original function
	// Object will only be made once
	public static void main(String[] args) {
		/*
		House h1 = new House();
		House h2 = new House();
		h1.city="A";
		h2.city="B";
		*/
		House h1 = House.getinstance();
		House h2 = House.getinstance();
		House h3 = House.getinstance();
		
		h1.city="a";
		System.out.println(h1.city);
		System.out.println(h2.city);
		System.out.println(h3.city);
	}

}
