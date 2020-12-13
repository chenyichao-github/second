package collection;

import java.util.Date;
import java.util.TreeSet;

public class TreeSetErrorTest2 {
    public static void main(String[] args) {
        var ts = new TreeSet<>();
        ts.add("疯狂Java讲义");
        ts.add(new Date());
    }
}
