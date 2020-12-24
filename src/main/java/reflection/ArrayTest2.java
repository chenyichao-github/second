package reflection;

import java.lang.reflect.Array;

public class ArrayTest2 {
    public static void main(String[] args) {
        Object arr = Array.newInstance(String.class, 3, 4, 10);
        Object arrObj = Array.get(arr, 2);
        Array.set(arrObj, 2, new String[]{
                "���Java����",
                "������Java EE��ҵӦ��ʵս"
        });
        Object anArr = Array.get(arrObj, 3);
        Array.set(anArr, 8, "���Android����");
        var cast = (String[][][]) arr;
        System.out.println(cast[2][3][8]);
        System.out.println(cast[2][2][0]);
        System.out.println(cast[2][2][1]);
    }
}
