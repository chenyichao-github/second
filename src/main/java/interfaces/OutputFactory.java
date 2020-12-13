package interfaces;

public class OutputFactory {
    public static void main(String[] args) {
        var of = new OutputFactory();
        var c = new Computer(of.getOutput());
        c.keyIn("轻量级Java EE企业应用实战");
        c.keyIn("疯狂Java讲义");
        c.print();
    }

    public Output getOutput() {
        return new BetterPrinter();
    }
}
