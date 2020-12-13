package simple;

public class OverloadVarargs {
    public static void main(String[] args) {
        var olv = new OverloadVarargs();
        olv.test();
        olv.test("aa", "bb");
        olv.test("aa");
        olv.test(new String[]{"aa"});
    }

    public void test(String msg) {
        System.out.println("只有一个字符串参数的test方法");
    }

    public void test(String... books) {
        System.out.println("****形参个数可变的test方法****");
    }
}

