package simple;

public class ArrayTest {
    public static void main(String[] args) {
        int[] intArr;
        intArr = new int[]{5, 6, 8, 20};
        Object[] objArr;
        objArr = new String[]{"Java", "李刚"};
        Object[] objArr2;
        objArr2 = new Object[]{"Java", "李刚"};
        int[] a = {5, 6, 7, 9};
        int[] price = {1, 2, 3, 4};
        Object[] books = new String[4];
        var names = new String[]{"yeeku", "nono"};
        var weightArr = new double[4];
        System.out.println(objArr[1]);
        objArr2[0] = "Spring";
        System.out.println(objArr2[0]);
        //System.out.println(objArr2[2]);
        for (var i = 0; i < price.length; i++) {
            System.out.println(price[i]);
        }
        books[0] = "疯狂Java讲义";
        books[1] = "轻量级Java EE企业应用实战";
        for (var i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}
