package simple;

import java.util.Arrays;

public class ArraysTest2 {
    public static void main(String[] args) {
        var arr1 = new int[]{3, -4, 25, 16, 30, 18};
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));
        var arr2 = new int[]{3, -4, 25, 16, 30, 18};
        Arrays.parallelPrefix(arr2, (left, right) -> {
            return left * right;
        });
        System.out.println(Arrays.toString(arr2));
        var arr3 = new int[5];
        Arrays.parallelSetAll(arr3, operand -> {
            return operand * 5;
        });
        System.out.println(Arrays.toString(arr3));
    }
}
