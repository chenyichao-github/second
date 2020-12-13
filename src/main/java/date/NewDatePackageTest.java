package date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

public class NewDatePackageTest {
    public static void main(String[] args) {
        var clock = Clock.systemUTC();
        System.out.println("当前时刻为：" + clock.instant());
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
        var d = Duration.ofSeconds(6000);
        System.out.println("6000秒相当于" + d.toMinutes() + "分");
        System.out.println("6000秒相当于" + d.toHours() + "小时");
        System.out.println("6000秒相当于" + d.toDays() + "天");
        var clock2 = Clock.offset(clock, d);
        System.out.println("当前时刻加6000秒为：" + clock2.instant());
        var instant = Instant.now();
        System.out.println(instant);
        var instant2 = instant.plusSeconds(6000);
        System.out.println(instant2);
        var instant3 = Instant.parse("2014-02-23T10:12:35.342Z");
        System.out.println(instant3);
        var instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant4);
        var instant5 = instant4.minus(Duration.ofDays(5));
        System.out.println(instant5);
        var localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = LocalDate.ofYearDay(2014, 146);
        System.out.println(localDate);
        localDate = LocalDate.of(2014, Month.MAY, 21);
        System.out.println(localDate);
        var localTime = LocalTime.now();
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);
        localTime = LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime);
        var localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        var future = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println("当前日期、时间的25小时3分之后：" + future);
        var year = Year.now();
        System.out.println("当前年份：" + year);
        year = year.plusYears(5);
        System.out.println("当前年份再过5年：" + year);
        var ym = year.atMonth(10);
        System.out.println("year年10月：" + ym);
        ym = ym.plusYears(5).minusMonths(3);
        System.out.println("year年10月再加5年、减3个月：" + ym);
        var md = MonthDay.now();
        System.out.println("当前月日：" + md);
        var md2 = md.with(Month.MAY).withDayOfMonth(23);
        System.out.println("5月23日为：" + md2);
    }
}
