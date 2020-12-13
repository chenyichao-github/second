package inner;

interface Product {
    double getPrice();

    String getName();
}

class AnonymousProduct implements Product {

    @Override
    public double getPrice() {
        return 567.8;
    }

    @Override
    public String getName() {
        return "AGP显卡";
    }
}

public class AnonymousTest {
    public static void main(String[] args) {
        var ta = new AnonymousTest();
        ta.test(new AnonymousProduct());
    }

    public void test(Product p) {
        System.out.println("购买了一个" + p.getName() + "，花掉了" + p.getPrice());
    }
}
