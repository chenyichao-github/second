package type;

import java.util.ArrayList;
import java.util.List;

public class Son {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        //new Son().test(strList);
    }

    public void test(List<Object> c) {
        for (var i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }
}
