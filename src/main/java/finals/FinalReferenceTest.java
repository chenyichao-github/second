package finals;

import java.util.Arrays;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class FinalReferenceTest {
    public static void main(String[] args) {
        final int[] iArr = {5, 6, 12, 9};
        System.out.println(Arrays.toString(iArr));
        Arrays.sort(iArr);
        System.out.println(Arrays.toString(iArr));
        iArr[2] = -8;
        System.out.println(Arrays.toString(iArr));
        //iArr = null;
        final var p = new Person(45);
        p.setAge(23);
        System.out.println(p.getAge());
        //p = null;
    }
}
