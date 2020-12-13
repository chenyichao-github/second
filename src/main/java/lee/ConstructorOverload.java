package lee;

public class ConstructorOverload {
    public String name;
    public int count;

    public ConstructorOverload() {
    }

    public ConstructorOverload(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public static void main(String[] args) {
        var oc1 = new ConstructorOverload();
        var oc2 = new ConstructorOverload("轻量级Java EE企业级应用实战", 300000);
        System.out.println(oc1.name + " " + oc1.count);
        System.out.println(oc2.name + " " + oc2.count);
    }
}
