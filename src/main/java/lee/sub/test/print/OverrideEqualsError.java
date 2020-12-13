package lee.sub.test.print;

class Person {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

class Dog {
}

public class OverrideEqualsError {
    public static void main(String[] args) {
        var p = new Person();
        System.out.println("Person对象是否equals Dog对象?" + p.equals(new Dog()));
        System.out.println("Person对象是否equals String对象?" + p.equals("Hello"));
    }
}
