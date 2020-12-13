package thread.synchronize;

public class Account {
    private String accountNo;
    private double balance;
    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            if (!flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + " 取钱：" + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为：" + balance);
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + " 存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == thread.Account.class) {
            var target = (thread.Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
