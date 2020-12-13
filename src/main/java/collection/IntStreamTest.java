package collection;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        var is = IntStream.builder().add(20).add(13).add(-2).add(18).build();
        //System.out.println("is所有元素的最大值：" + is.max().getAsInt());
        //System.out.println("is所有元素的最小值：" + is.min().getAsInt());
        //System.out.println("is所有元素的总和：" + is.sum());
        //System.out.println("is所有元素的总数：" + is.count());
        //System.out.println("is所有元素的平均数：" + is.average().getAsDouble());
        //System.out.println("is所有元素的平方是否都大于20：" + is.allMatch(ele -> ele * ele > 20));
        //System.out.println("is是否包含任何元素的平方大于20：" + is.anyMatch(ele -> ele * ele > 20));
        var newIs = is.map(ele -> ele * 2 + 1);
        newIs.forEach(System.out::println);
    }
}
