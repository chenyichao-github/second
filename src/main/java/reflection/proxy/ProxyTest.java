package reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Person {
    void walk();

    void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----正在执行的方法:" + method);
        if (args != null) {
            System.out.println("下面是执行该方法时传入的实参为：");
            for (var val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("调用该方法没有实参");
        }
        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        var p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        p.walk();
        p.sayHello("孙悟空");
    }
}
