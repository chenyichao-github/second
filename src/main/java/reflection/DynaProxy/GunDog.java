package reflection.DynaProxy;

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("����һֻ�Թ�");
    }

    @Override
    public void run() {
        System.out.println("�ұ���Ѹ��");
    }
}
