package reflection;

public class CrazyitObjectFactory {
    public static Object getInstance(String clsName) {
        try {
            Class cls = Class.forName(clsName);
            return cls.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
