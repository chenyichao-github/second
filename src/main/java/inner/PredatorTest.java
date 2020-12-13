package inner;

public class PredatorTest {
    public static void main(String[] args) {
        Predator predator = (@NotNull var animal) -> {
            System.out.println("老鹰正在猎捕" + animal);
        };
        predator.prey("兔子");
    }
}
