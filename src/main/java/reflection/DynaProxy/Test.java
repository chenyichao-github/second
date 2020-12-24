package reflection.DynaProxy;

public class Test {
    public static void main(String[] args) throws Exception {
        Dog target = new GunDog();
        var dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
