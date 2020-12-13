package simple;

public class ComparableOperatorTest {
    public static void main(String[] args) {
        System.out.println("5是否大于4.0:" + (5 > 4.0));
        System.out.println("5和5.0是否相等:" + (5 == 5.0));
        System.out.println("97和'a'是否相等:" + (97 == 'a'));
        System.out.println("true和false是否相等:" + (true == false));
        var t1 = new ComparableOperatorTest();
        var t2 = new ComparableOperatorTest();
        System.out.println("t1是否等于t2:" + (t1 == t2));
        var t3 = t1;
        System.out.println("t1是否等于t3:" + (t1 == t3));
    }
}
