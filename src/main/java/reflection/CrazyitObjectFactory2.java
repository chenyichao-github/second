package reflection;

import javax.swing.*;
import java.util.Date;

public class CrazyitObjectFactory2 {
    public static <T> T getInstance(Class<T> cls) {
        try {
            return cls.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Date d = CrazyitObjectFactory2.getInstance(Date.class);
        JFrame f = CrazyitObjectFactory2.getInstance(JFrame.class);
        System.out.println(d);
        System.out.println(f);
    }
}
