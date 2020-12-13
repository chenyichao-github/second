import simple.Person;

public class PersonTest {
    public static void main(String[] args) {
        var p = new Person();
        p.say("Java语言很简单，学习很容易！");
        p.name = "李刚";
        System.out.println(p.name);
    }
}