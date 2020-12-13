package format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewFormatterParse {
    public static void main(String[] args) {
        var str1 = "2014==04==12 01时06分09秒";
        var formatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        var dt1 = LocalDateTime.parse(str1, formatter1);
        System.out.println(dt1);
        var str2 = "2014$$$4月$$$13 20小时";
        var formatter2 = DateTimeFormatter.ofPattern("yyy$$$MMM$$$dd HH小时");
        var dt2 = LocalDateTime.parse(str2, formatter2);
        System.out.println(dt2);
    }
}
