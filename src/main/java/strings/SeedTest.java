package strings;

import java.util.Random;

public class SeedTest {
    public static void main(String[] args) {
        var r1 = new Random(System.currentTimeMillis());
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r1.nextBoolean():\t" + r1.nextBoolean());
        System.out.println("r1.nextInt():\t" + r1.nextInt());
        System.out.println("r1.nextDouble():\t" + r1.nextDouble());
        System.out.println("r1.nextGaussian():\t" + r1.nextGaussian());
        System.out.println("----------------------");

    }
}
