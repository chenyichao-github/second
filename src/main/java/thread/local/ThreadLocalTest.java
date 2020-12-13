package thread.local;

import org.jetbrains.annotations.NotNull;

class Account {
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String str) {
        this.name.set(str);
        System.out.println("---" + this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        this.name.set(str);
    }
}

class MyTest extends Thread {
    private Account account;

    public MyTest(@NotNull String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (var i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());
            }
            System.out.println(account.getName() + "账户的i值：" + i);
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        var at = new Account("初始名");
        new MyTest("线程甲", at).start();
        new MyTest("线程乙", at).start();
    }
}
