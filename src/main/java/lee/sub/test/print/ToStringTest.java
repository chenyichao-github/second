package lee.sub.test.print;

class Apple {
    private String color;
    private double weight;

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple[color=" + color + ",weight=" + weight + "]";
    }
}

public class ToStringTest {
    public static void main(String[] args) {
        var a = new Apple("红色", 5.68);
        System.out.println(a);
    }
}
