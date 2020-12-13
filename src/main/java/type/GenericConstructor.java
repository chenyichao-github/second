package type;

class Fooo {
    public <T> Fooo(T t) {
        System.out.println(t);
    }
}

public class GenericConstructor {
    public static void main(String[] args) {
        new Fooo("疯狂Java讲义");
        new Fooo(200);
        new <String>Fooo("疯狂Android讲义");
        //new <String> Fooo(12.3);
    }
}
