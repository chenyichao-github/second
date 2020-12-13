package collection;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class EnumSetTest2 {
    public static void main(String[] args) {
        var c = new HashSet();
        c.clear();
        c.add(Season.FALL);
        c.add(Season.SPRING);
        var enumSet = EnumSet.copyOf(c);
        System.out.println(enumSet);
        c.add("疯狂Java讲义");
        c.add("轻量级Java EE企业应用实战");
        //enumSet = EnumSet.copyOf(c);
        SortedSet<String> s = Collections.synchronizedSortedSet(new TreeSet<>());
        s.add("疯狂Java讲义");
        s.add("轻量级Java EE企业应用实战");
        System.out.println(s);
    }
}
