package simple;

class BaseClass {
    public int book = 6;

    public void base() {
        System.out.println("父类的普通方法");
    }

    public void test() {
        System.out.println("父类被覆盖的方法");
    }
}

public class SubClass extends BaseClass {
    public String book = "轻量级Java EE企业应用实战";

    public static void main(String[] args) {
        BaseClass bc = new BaseClass();
        //System.out.println(bc.book);
        //bc.base();
        //bc.test();
        SubClass sc = new SubClass();
        //System.out.println(sc.book);
        //sc.base();
        //sc.test();
        BaseClass ploymophicBc = new SubClass();
        System.out.println(ploymophicBc.book);
        ploymophicBc.base();
        ploymophicBc.test();
        //ploymophicBc.sub();
        var v1 = new SubClass();
        var v2 = ploymophicBc;
        //v2.sub();
    }

    @Override
    public void test() {
        System.out.println("子类的覆盖父类的方法");
    }

    public void sub() {
        System.out.println("子类的普通方法");
    }
}
