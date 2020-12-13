package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        var c = new ArrayList();
        c.add("孙悟空");
        c.add(6);
        System.out.println("c集合的元素个数为：" + c.size());
        c.remove(Integer.valueOf(6));
        System.out.println("c集合的元素个数为：" + c.size());
        System.out.println("c集合是否包含\"孙悟空\"字符串：" + c.contains("孙悟空"));
        c.add("轻量级Java EE企业应用实战");
        System.out.println("c集合的元素：" + c);
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        System.out.println("c集合是否完全包含books集合？" + c.containsAll(books));
        c.removeAll(books);
        System.out.println("c集合的元素：" + c);
        c.clear();
        System.out.println("c集合的元素：" + c);
        books.retainAll(c);
        System.out.println("books集合的元素：" + books);
        var strColl = List.of("Java", "Kotlin", "Swift", "Python");
        String[] sa = strColl.toArray(String[]::new);
        System.out.println(Arrays.toString(sa));
    }
}
