package lee.sub.test;

public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        Integer inObj = 5;
        Object boolObj = true;
        int it = inObj;
        if (boolObj instanceof Boolean) {
            boolean b = (Boolean) boolObj;
            System.out.println(b);
        }
    }
}
