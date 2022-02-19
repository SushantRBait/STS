import java.util.Arrays;

public class Anagram {
	public static boolean isAnagram(String a,String b) {
		   char[] a1=a.toCharArray();
		   char[] a2=b.toCharArray();
		   
		   Arrays.sort(a1);
		   Arrays.sort(a2);
           
		   String s1=a1.toString();
		   String s2=a1.toString();
		   
		 return s1.equals(s2);
	}
	
	
	
	public static void main(String[] args) {
    
		System.out.println(isAnagram("KeEp", "Peek"));
	}
}
