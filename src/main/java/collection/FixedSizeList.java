package collection;

import java.util.Arrays;

public class FixedSizeList {
    public static void main(String[] args) {
        var fixedList = Arrays.asList("疯狂Java讲义", "轻量级Java EE企业级应用实战");
        System.out.println(fixedList.getClass());
        fixedList.forEach(System.out::println);
        fixedList.add("疯狂Android讲义");
        fixedList.remove("疯狂Java讲义");
    }
}
