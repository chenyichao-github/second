package collection;

import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

class V implements Comparable {
    int count;

    public V(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "V[count:" + count + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == V.class) {
            var v = (V) obj;
            return v.count == this.count;
        }
        return false;
    }

    @Override
    public int compareTo(@NotNull Object obj) {
        var v = (V) obj;
        return Integer.compare(this.count, v.count);
    }
}

public class TreeMapTest {
    public static void main(String[] args) {
        var tm = new TreeMap<>();
        tm.put(new V(3), "轻量级Java EE企业应用实战");
        tm.put(new V(-5), "疯狂Java讲义");
        tm.put(new V(9), "疯狂Android讲义");
        System.out.println(tm);
        System.out.println(tm.firstEntry());
        System.out.println(tm.lastKey());
        System.out.println(tm.higherKey(new V(2)));
        System.out.println(tm.lowerEntry(new V(2)));
        System.out.println(tm.subMap(new V(-1), new V(4)));

    }
}
