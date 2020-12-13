package thread.synchronize;

import org.jetbrains.annotations.NotNull;

public class DepositThread extends Thread {
    private Account account;
    private double depositAmount;

    public DepositThread(@NotNull String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (var i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
