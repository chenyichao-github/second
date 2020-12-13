package type;

import java.io.Serializable;

public class Apple1<T extends Number & Serializable> {
    T col;

    public static void main(String[] args) {
        Apple1<Integer> ai = new Apple1<>();
        Apple1<Double> ad = new Apple1<>();
        //Apple1<String> as = new Apple1<String>();
    }
}
