package simple;

import java.util.Arrays;

public class Num2Rmb {
    private String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private String[] unitArr = {"十", "百", "千"};

    public static void main(String[] args) {
        var nr = new Num2Rmb();
        System.out.println(Arrays.toString(nr.divide(236711125.123)));
        System.out.println(nr.toHanStr("6109"));
    }

    private String[] divide(double num) {
        var zheng = (long) num;
        var xiao = Math.round((num - zheng) * 100);
        return new String[]{zheng + "", String.valueOf(xiao)};
    }

    private String toHanStr(String numStr) {
        var result = "";
        int numLen = numStr.length();
        for (var i = 0; i < numLen; i++) {
            var num = numStr.charAt(i) - 48;
            if (i != numLen - 1 && num != 0) {
                result += hanArr[num] + unitArr[numLen - 2 - i];
            } else {
                result += hanArr[num];
            }
        }
        return result;
    }
}
