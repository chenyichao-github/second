package reflection;

import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person [" + "name=" + name + ", age=" + age + ']';
    }
}

public class FieldTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        var p = new Person();
        Class<Person> personClazz = Person.class;
        Field nameField = personClazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p, "Yeeku.H.Lee");
        Field ageField = personClazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(p, 30);
        System.out.println(p);
    }
}
