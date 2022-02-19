import java.util.Scanner;

public class LargestDigit {

	public static void main(String[] args) {
		int r ,n , Id=0;
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a Number :");
		n=sc.nextInt();
		sc.close();
		while(n>0) {
			r=n%10;
			if(Id<r) {
				Id=r;
				
			}
			
			n=n/10;
		}
		System.out.println("The Largest Digit is: "+Id);
	}

}
