package collection;

import org.jetbrains.annotations.NotNull;

import java.util.TreeSet;

class M implements Comparable {
    int count;

    public M(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "M[count:" + count + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == M.class) {
            var m = (M) obj;
            return m.count == this.count;
        }
        return false;
    }

    @Override
    public int compareTo(@NotNull Object obj) {
        var m = (M) obj;
        return count > m.count ? 1 : count < m.count ? -1 : 0;
    }
}

public class TreeSetTest4 {
    public static void main(String[] args) {
        var ts = new TreeSet<>();
        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        ts.add(new M(-2));
        System.out.println(ts);
        var first = (M) ts.first();
        first.count = 20;
        var last = (M) ts.last();
        last.count = -2;
        System.out.println(ts);
        System.out.println(ts.remove(new M(-2)));
        System.out.println(ts);
        System.out.println(ts.remove(new M(5)));
        System.out.println(ts);
    }
}
