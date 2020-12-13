package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public static void main(String[] args) {
        var str = "疯狂Java讲义";
        var rq = new ReferenceQueue();
        var pr = new PhantomReference(str, rq);
        str = null;
        System.out.println(pr.get());
        System.gc();
        System.runFinalization();
        System.out.println(rq.poll() == pr);
    }
}
