package simple;

public class ForEachTest {
    public static void main(String[] args) {
        String[] books = {"轻量级Java EE企业应用实战", "疯狂Java讲义", "疯狂Android讲义"};
        for (var book : books) {
            System.out.println(book);
        }
    }
}
