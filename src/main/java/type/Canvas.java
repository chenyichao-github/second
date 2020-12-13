package type;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle());
        var c = new Canvas();
        c.drawAll(circleList);
    }

    public void drawAll(List<? extends Shape> shapes) {
        for (var s : shapes) {
            s.draw(this);
        }
    }

    public void addRectangle(List<? extends Shape> shapes) {
        //shapes.add(0, new Rectangle());
    }
}
