package simple;

class Base {
    public double size;
    public String name;

    public Base(double size, String name) {
        this.size = size;
        this.name = name;
    }
}

public class Sub extends Base {
    public String color;

    public Sub(double size, String name, String color) {
        super(size, name);
        this.color = color;
    }

    public static void main(String[] args) {
        var s = new Sub(5.6, "测试对象", "红色");
        System.out.println(s.size + "--" + s.name + "--" + s.color);
    }
}
