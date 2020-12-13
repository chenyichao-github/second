package inner;

abstract class Device {
    private String name;

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class AnonymousInner {
    public static void main(String[] args) {
        var ai = new AnonymousInner();
        ai.test(new Device("电子示波器") {
            @Override
            public double getPrice() {
                return 67.8;
            }
        });
        var d = new Device() {
            {
                System.out.println("匿名内部类的初始化块...");
            }

            @Override
            public double getPrice() {
                return 56.2;
            }

            @Override
            public String getName() {
                return "键盘";
            }
        };
        ai.test(d);
    }

    public void test(Device d) {
        System.out.println("购买了一个" + d.getName() + "，花掉了" + d.getPrice());
    }
}
