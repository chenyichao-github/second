package reflection;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPoolFactory {
    private Map<String, Object> objectPool = new HashMap<>();

    public static void main(String[] args) {
        var pf = new ObjectPoolFactory();
        pf.initPool("src/main/java/reflection/obj.txt");
        System.out.println(pf.getObject("a"));
        System.out.println(pf.getObject("b"));
    }

    private Object createObject(String clazzName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.getConstructor().newInstance();
    }

    public void initPool(String fileName) {
        try (
                var fis = new FileInputStream(fileName)
        ) {
            var props = new Properties();
            props.load(fis);
            for (String name : props.stringPropertyNames()) {
                objectPool.put(name, createObject(props.getProperty(name)));
            }
        } catch (Exception ex) {
            System.out.println("读取" + fileName + "异常");
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }
}
