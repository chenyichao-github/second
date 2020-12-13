package thread;

class MyExHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println(thread + "线程出现了异常：" + throwable);
    }
}

public class ExHandler {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        var a = 5 / 0;
        System.out.println("程序正常结束!");
    }
}
