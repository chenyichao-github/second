package thread;

import org.jetbrains.annotations.NotNull;

public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThread(@NotNull String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }
}
