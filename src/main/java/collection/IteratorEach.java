package collection;

import java.util.HashSet;

public class IteratorEach {
    public static void main(String[] args) {
        var books = new HashSet<>();
        books.add("疯狂Java讲义");
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Android讲义");
        var it = books.iterator();
        it.forEachRemaining(obj -> System.out.println("迭代集合元素：" + obj));
    }
}
