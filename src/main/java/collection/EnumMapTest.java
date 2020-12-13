package collection;

import java.util.EnumMap;

public class EnumMapTest {
    public static void main(String[] args) {
        var enumMap = new EnumMap<Season, String>(Season.class);
        enumMap.put(Season.SUMMER, "夏日炎炎");
        enumMap.put(Season.SPRING, "春暖花开");
        System.out.println(enumMap);
    }
}
