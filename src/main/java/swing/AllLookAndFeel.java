package swing;

import javax.swing.*;

public class AllLookAndFeel {
    public static void main(String[] args) {
        System.out.println("��ǰϵͳ���õ�����LAF:");
        for (var info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + "--->" + info);
        }
    }
}
