package collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9Collection {
    public static void main(String[] args) {
        var set = Set.of("Java", "Kotlin", "Go", "Swift");
        System.out.println(set);
        //set.add("Ruby");
        var list = List.of(34, -25, 67, 231);
        System.out.println(list);
        //list.remove(1);
        var map = Map.of("语文", 89, "数学", 82, "英语", 92);
        System.out.println(map);
        //map.remove("语文");
        var map2 = Map.ofEntries(Map.entry("语文", 89), Map.entry("数学", 82), Map.entry("英语", 92));
        System.out.println(map2);
    }
}
