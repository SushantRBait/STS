
public class Armstrong {
	static boolean isArmstrong(int n) {
		int temp, digits = 0, last = 0, sum = 0;
		temp = n;
		while (temp > 0) {
			temp = temp / 10;
			digits++;
		}
		temp = n;
		while (temp > 0) {
			last = temp % 10;
			sum += (Math.pow(last, digits));
			
	//		sum +=
			temp = temp / 10;
		}
		if (n == sum)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
    
		if(isArmstrong(153)==true) {
		System.out.println("Given number is Armstrong");
		}
	}
}
