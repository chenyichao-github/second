package collection;

import java.util.TreeSet;

class Q {
    int age;

    public Q(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Q [age:" + age + "]";
    }
}

public class TreeSetTest5 {
    public static void main(String[] args) {
        var ts = new TreeSet<Q>((o1, o2) -> {
            var m1 = (Q) o1;
            var m2 = (Q) o2;
            return Integer.compare(m2.age, m1.age);
        });
        ts.add(new Q(5));
        ts.add(new Q(-3));
        ts.add(new Q(9));
        System.out.println(ts);
    }
}
