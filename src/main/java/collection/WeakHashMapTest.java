package collection;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        var whm = new WeakHashMap<>();
        whm.put("语文", "良好");
        whm.put("数学", "及格");
        whm.put("英文", "中等");
        whm.put("java", "中等");
        System.out.println(whm);
        System.gc();
        System.runFinalization();
        System.out.println(whm);
    }
}
