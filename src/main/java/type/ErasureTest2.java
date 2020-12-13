package type;

import java.util.ArrayList;
import java.util.List;

public class ErasureTest2 {
    public static void main(String[] args) {
        List li = new ArrayList();
        li.add(6);
        li.add(9);
        System.out.println((String) li.get(0));
        //List<String>[] lsa = new ArrayList<String>[10];
    }
}
