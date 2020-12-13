package abstracts;

public abstract class Shape {
    private String color;

    {
        System.out.println("执行Shape的初始化块...");
    }

    public Shape() {
    }

    public Shape(String color) {
        System.out.println("执行Shape的构造器...");
        this.color = color;
    }

    public abstract double calPerimeter();

    public abstract String getType();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
