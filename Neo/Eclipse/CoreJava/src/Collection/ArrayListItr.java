package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListItr {

	public static void main(String[] args) {

		ArrayList<String> list=new ArrayList<String>();
		
		for(int i=1;i<=10;i++) {
			list.add("Ram"+i);
		}
		
		System.out.println("Iterate using for loop");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("Iterate using for each loop");
		for(String element:list) {
			System.out.println(element);
		}
		
		
		System.out.println("Iterate using Iterator ");
		
		Iterator<String> itr=list.iterator();
		while(itr.hasNext()) {
			String s=(String)itr.next();
			
			System.out.println(s);
		}
		
		System.out.println("Iterate using ListIterator");
		
		ListIterator<String> listItr= list.listIterator();
		while(listItr.hasNext()) {     //here we can use hasPrevious()
			String s=(String)listItr.next();    //previous()
			System.out.println(s);
		}
		
			
	}

}
