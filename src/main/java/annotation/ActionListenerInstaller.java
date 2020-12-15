package annotation;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class ActionListenerInstaller {
    public static void processAnnotations(Object obj) {
        try {
            Class cl = obj.getClass();
            for (Field f : cl.getDeclaredFields()) {
                f.setAccessible(true);
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                Object fObj = f.get(obj);
                if (a != null && fObj != null && fObj instanceof AbstractButton) {
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    ActionListener al = listenerClazz.getDeclaredConstructor().newInstance();
                    var ab = (AbstractButton) fObj;
                    ab.addActionListener(al);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
