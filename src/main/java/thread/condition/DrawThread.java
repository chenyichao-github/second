package thread.condition;

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
        for (var i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }
}
