package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        var c = new ArrayList();
        c.add("�����");
        c.add(6);
        System.out.println("c���ϵ�Ԫ�ظ���Ϊ��" + c.size());
        c.remove(Integer.valueOf(6));
        System.out.println("c���ϵ�Ԫ�ظ���Ϊ��" + c.size());
        System.out.println("c�����Ƿ����\"�����\"�ַ�����" + c.contains("�����"));
        c.add("������Java EE��ҵӦ��ʵս");
        System.out.println("c���ϵ�Ԫ�أ�" + c);
        var books = new HashSet();
        books.add("������Java EE��ҵӦ��ʵս");
        books.add("���Java����");
        System.out.println("c�����Ƿ���ȫ����books���ϣ�" + c.containsAll(books));
        c.removeAll(books);
        System.out.println("c���ϵ�Ԫ�أ�" + c);
        c.clear();
        System.out.println("c���ϵ�Ԫ�أ�" + c);
        books.retainAll(c);
        System.out.println("books���ϵ�Ԫ�أ�" + books);
        var strColl = List.of("Java", "Kotlin", "Swift", "Python");
        String[] sa = strColl.toArray(String[]::new);
        System.out.println(Arrays.toString(sa));
    }
}
