package simple;

public class ConversionTest {
    public static void main(String[] args) {
        var d = 13.4;
        var l = (long) d;
        System.out.println(l);
        var in = 5;
        //var b = (boolean) in;
        Object obj = "Hello";
        var objStr = (String) obj;
        System.out.println(objStr);
        Object objPri = Integer.valueOf(5);
        if (objPri instanceof String) {
            var str = (String) objPri;
        }
    }
}
