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
        System.out.println("----����ִ�еķ���:" + method);
        if (args != null) {
            System.out.println("������ִ�и÷���ʱ�����ʵ��Ϊ��");
            for (var val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("���ø÷���û��ʵ��");
        }
        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        var p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        p.walk();
        p.sayHello("�����");
    }
}
