
public class ConstructorEx {

	 ConstructorEx() {
		this(10);
		System.out.println("No-Arg");
	}
	 ConstructorEx(int a) {
		 this("Ram");
		System.out.println("int-Arg"+a);
	}
	 ConstructorEx(String a) {
		System.out.println("String-Arg"+a);
	}
	public static void main(String[] args) {
		new ConstructorEx();
		System.out.println("main");
	}
}
