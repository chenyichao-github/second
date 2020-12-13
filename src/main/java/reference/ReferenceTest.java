package reference;

import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {
        var str = "疯狂Java讲义";
        var wr = new WeakReference(str);
        str = null;
        System.out.println(wr.get());
        System.gc();
        System.runFinalization();
        System.out.println(wr.get());
    }
}
