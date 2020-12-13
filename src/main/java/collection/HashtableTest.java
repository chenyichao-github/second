package collection;

import java.util.Hashtable;

class K {
    int count;

    public K(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj != null && obj.getClass() == K.class) {
            var k = (K) obj;
            return this.count == k.count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.count;
    }
}

class L {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class HashtableTest {
    public static void main(String[] args) {
        var ht = new Hashtable<>();
        ht.put(new K(60000), "疯狂Java讲义");
        ht.put(new K(87563), "轻量级Java EE企业应用实战");
        ht.put(new K(1232), new L());
        System.out.println(ht);
        System.out.println(ht.containsValue("测试字符串"));
        System.out.println(ht.containsKey(new K(87563)));
        ht.remove(new K(1232));
        System.out.println(ht);
    }
}
