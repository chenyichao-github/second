package simple;

public class AutoPromote {
    public static void main(String[] args) {
        short sValue = 5;
        //sValue = sValue - 2;//提升成int
        byte b = 40;
        var c = 'a';
        var i = 23;
        var d = .314;
        double result = b + c + i * d;
        System.out.println(result);
        var val = 3;
        int intResult = 23 / val;
        System.out.println(intResult);
        System.out.println("Hello!" + 'a' + 7);
        System.out.println('a' + 7 + "Hello!");
        var a = 5;
        //var c = 'a';
        //var b = true;
        //var f = 5.12f;
        //var d = 4.12;
        var author = "李刚";
        var book = "疯狂Android讲义";
        var s0 = "hello";
        var s1 = "hello";
        var s2 = "he" + "llo";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        var a1 = 5.2;
        var b1 = 3.1;
        var sum = a1 + b1;
        System.out.println(sum);
        var m1 = 5.2;
        var n1 = 3.1;
        var sub = a - b;
        System.out.println(sub);
        var q = 5.2;
        var h = 3.1;
        var multiply = q * h;
        System.out.println(multiply);

    }
}

