package reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExtendedObjectPoolFactory {
    private Map<String, Object> objectPool = new HashMap<>();
    private Properties config = new Properties();

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        var epf = new ExtendedObjectPoolFactory();
        epf.init("src/main/java/reflection/extObj.txt");
        epf.initPool();
        epf.initProperty();
        System.out.println(epf.getObject("a"));
    }

    public void init(String fileName) {
        try (
                var fis = new FileInputStream(fileName)
        ) {
            config.load(fis);
        } catch (IOException ex) {
            System.out.println("∂¡»°" + fileName + "“Ï≥£");
        }
    }

    private Object createObject(String clazzName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.getConstructor().newInstance();
    }

    public void initPool() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (var name : config.stringPropertyNames()) {
            if (!name.contains("%")) {
                objectPool.put(name, createObject(config.getProperty(name)));
            }
        }
    }

    public void initProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (var name : config.stringPropertyNames()) {
            if (name.contains("%")) {
                String[] objAndProp = name.split("%");
                Object target = getObject(objAndProp[0]);
                String mtdName = "set" + objAndProp[1].substring(0, 1).toUpperCase() + objAndProp[1].substring(1);
                Class<?> targetClass = target.getClass();
                Method mtd = targetClass.getMethod(mtdName, String.class);
                mtd.invoke(target, config.getProperty(name));
            }
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }
}
