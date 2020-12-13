package collection;

import java.util.Collections;
import java.util.HashMap;

public class UnmodifiableTest {
    public static void main(String[] args) {
        var unmodifiableList = Collections.emptyList();
        var unmodifiableSet = Collections.singleton("疯狂Java讲义");
        var scores = new HashMap<>();
        scores.put("语文", 80);
        scores.put("Java", 82);
        var unmodifiableMap = Collections.unmodifiableMap(scores);
        unmodifiableList.add("测试元素");
        unmodifiableSet.add("测试元素");
        unmodifiableMap.put("语文", 90);
    }
}
