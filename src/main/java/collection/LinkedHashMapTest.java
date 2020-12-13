package collection;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        var ht = new LinkedHashMap<>();
        ht.put("语文", 80);
        ht.put("英文", 82);
        ht.put("数学", 76);
        ht.forEach((key, value) -> System.out.println(key + "-->" + value));
    }
}
