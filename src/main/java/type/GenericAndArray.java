package type;

import java.util.ArrayList;
import java.util.List;

public class GenericAndArray {
    /*<T> T[] makeArray(Collection<T> coll) {
        return new T[coll.size()];
    }*/
    public static void main(String[] args) {
        List<?>[] lsa = new ArrayList<?>[10];
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<>();
        li.add(3);
        oa[1] = li;
        Object target = lsa[1].get(0);
        if (target instanceof String) {
            var s = (String) target;
            System.out.println(s);
        }
    }
}
