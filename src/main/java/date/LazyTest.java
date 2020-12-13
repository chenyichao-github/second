package date;

import java.util.Calendar;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;

public class LazyTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2003, 7, 31);
        cal.set(MONTH, 8);
        //System.out.println(cal.getTime());
        cal.set(DATE, 5);
        System.out.println(cal.getTime());
    }
}
