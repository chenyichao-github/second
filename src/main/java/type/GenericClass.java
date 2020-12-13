package type;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.println(l1.getClass() == l2.getClass());
    }
}
