package simple;

public class IntegerValTest {
    public static void main(String[] args) {
        int octalValue = 013;
        int hexValue1 = 0x13;
        int hexValue2 = 0XaF;
        int binVal1 = 0b11010100;
        int binVal2 = 0B01101001;
        int binVal3 = 0B10000000000000000000000000000011;
        System.out.println(binVal1);
        System.out.println(binVal2);
        System.out.println(binVal3);
        byte binVal4 = (byte) 0b11101001;
        long binVal5 = 0B10000000000000000000000000000011L;
        System.out.println(binVal4);
        System.out.println(binVal5);
    }
}
