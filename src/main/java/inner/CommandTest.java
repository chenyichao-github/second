package inner;

import interfaces.Command;
import interfaces.ProcessArray;

public class CommandTest {
    public static void main(String[] args) {
        var pa = new ProcessArray();
        int[] target = {3, -4, 6, 4};
        pa.process(target, new Command() {
            @Override
            public void process(int element) {
                System.out.println("数组元素的平方是：" + element * element);
            }
        });
    }
}
