package type;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> ts1 = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object fst, Object snd) {
                return hashCode() > snd.hashCode() ? 1 : hashCode() > snd.hashCode() ? -1 : 0;
            }
        });
        ts1.add("hello");
        ts1.add("wavcsss");
        System.out.println(ts1);
        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(second.length(), first.length());
            }
        });
        ts2.add("hello");
        ts2.add("wa");
        System.out.println(ts2);
    }
}
