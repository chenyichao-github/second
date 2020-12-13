package lee.sub.test;

public class Person {
    {
        var a = 6;
        if (a > 4) {
            System.out.println("Person实例初始化块：局部变量a的值大于4");
        }
        System.out.println("Person的实例初始化块");
    }

    {
        System.out.println("Person的第二个实例初始化块");
    }

    public Person() {
        System.out.println("Person类的无参数构造器");
    }

    public static void main(String[] args) {
        new Person();
    }
}
