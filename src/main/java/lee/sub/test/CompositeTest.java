package lee.sub.test;

class Animal {
    private void beat() {
        System.out.println("心脏跳动...");
    }

    public void breathe() {
        beat();
        System.out.println("吸一口气，吐一口气，呼吸中...");
    }
}

class Bird {
    private Animal a;

    public Bird(Animal a) {
        this.a = a;
    }

    public void breathe() {
        a.breathe();
    }

    public void fly() {
        System.out.println("我在天空自在的飞翔...");
    }
}

class Wolf {
    private Animal a;

    public Wolf(Animal a) {
        this.a = a;
    }

    public void breathe() {
        a.breathe();
    }

    public void run() {
        System.out.println("我在陆地上的快速奔跑...");
    }
}

public class CompositeTest {
    public static void main(String[] args) {
        var a1 = new Animal();
        var b = new Bird(a1);
        b.breathe();
        b.fly();
        var a2 = new Animal();
        var w = new Wolf(a2);
        w.breathe();
        w.run();
    }
}
