package simple;

import java.util.Arrays;

public class PrimitiveArrayTest {
    public static void main(String[] args) {
        int[] iArr;
        iArr = new int[5];
        for (var i = 0; i < iArr.length; i++) {
            iArr[i] = i + 10;
        }
        System.out.println(Arrays.toString(iArr));
    }
}
