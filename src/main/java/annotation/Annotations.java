package annotation;

import java.lang.annotation.Annotation;

public class Annotations {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] aArray = Class.forName("annotation.MyTagTest").getMethod("info").getAnnotations();
        for (var an : aArray) {
            System.out.println(an);
        }
    }
}
