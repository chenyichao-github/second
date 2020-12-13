package finals;

public class FinalVariableTest {
    final static double d;

    static {
        d = 5.6;
    }

    final int a = 6;
    final String str;
    final int c;

    //final char ch;
    {
        str = "Hello";
        //a = 9;
    }

    public FinalVariableTest() {
        //str = "java";
        c = 5;
    }

    public static void main(String[] args) {
        var ft = new FinalVariableTest();
        System.out.println(ft.a);
        System.out.println(ft.c);
        System.out.println(d);
    }

    public void changeFinal() {
        //d = 1.2;
        //ch = 'a';
    }
}
