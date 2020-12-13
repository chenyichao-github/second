package type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
    static void fromArrayToCollection(Object[] a, Collection<Object> c) {
        for (var o : a) {
            c.add(o);
        }
    }

    public static void main(String[] args) {
        String[] strArr = {"a", "b"};
        List<String> strList = new ArrayList<>();
        //99fromArrayToCollection(strArr, strList);
    }
}
