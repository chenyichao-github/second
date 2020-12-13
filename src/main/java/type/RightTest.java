package type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RightTest {
    static <T> void test(Collection<? extends T> from, Collection<T> to) {
        for (var ele : from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> ao = new ArrayList<>();
        List<String> as = new ArrayList<>();
        test(as, ao);
    }
}
