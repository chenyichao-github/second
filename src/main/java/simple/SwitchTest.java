package simple;

public class SwitchTest {
    public static void main(String[] args) {
        var score = 'C';
        switch (score) {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("中");
            case 'D':
                System.out.println("及格");
            case 'F':
                System.out.println("不及格");
            default:
                System.out.println("成绩输入错误");

        }
    }
}
