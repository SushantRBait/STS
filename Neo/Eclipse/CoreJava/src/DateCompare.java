import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCompare {
public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate now = LocalDate.now();
		LocalDate then = now.minusDays(7);
		System.out.println("Now Date :"+dtf.format(now));
		System.out.println("7 Days before Date :"+dtf.format(then));
		
		
		 LocalDate date2 = LocalDate.parse("2018-11-01");
		 LocalDate then2 = date2.minusDays(7);
		 
		 System.out.println(dtf.format(then2));
		
		if (now.compareTo(date2) == 0) {
		    System.out.println("Date1 is equals  Date2");
		}
		
	}

}
