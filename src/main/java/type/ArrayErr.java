package type;

import java.util.ArrayList;
import java.util.List;

public class ArrayErr {
    public static void main(String[] args) {
        Integer[] ia = new Integer[5];
        Number[] na = ia;
        //na[0] = 0.5;
        List<Integer> iList = new ArrayList<>();
        //List<Number> nList = iList;
        List<String> strList = List.of("Java", "Python", "Ruby");
        new ArrayErr().test(strList);
        List<?> c = new ArrayList<String>();
        //c.add(new Object());
    }

    public void test(List<?> c) {
        for (var i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }
}
