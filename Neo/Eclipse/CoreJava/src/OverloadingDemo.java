
public class OverloadingDemo {

	public static void main(String[] args) {
		OverloadingDemo o=new OverloadingDemo();
		o.show(null);
	}
	
	public void show(Object o) {
		System.out.println("In Object Method");
	}
	
	public void show(String o) {
		System.out.println("In String Method");
	}
//	public void show(StringBuffer o) {
//		System.out.println("In StringBuffer Method");
//	}
	
}
