package inner;

import javax.swing.*;

public class YourTestTest {
    public static void main(String[] args) {
        //YourTest yt = a -> new JFrame(a);
        YourTest yt = JFrame::new;
        JFrame jf = yt.win("我的窗口");
        jf.setVisible(true);
        System.out.println(jf);
    }
}
