package awt;

import javax.imageio.ImageIO;

public class ImageIOTest {
    public static void main(String[] args) {
        String[] readFormat = ImageIO.getReaderFormatNames();
        System.out.println("-----Image�ܶ�������ͼ���ļ���ʽ-----");
        for (var tmp : readFormat) {
            System.out.println(tmp);
        }
        String[] writeFormat = ImageIO.getWriterFormatNames();
        System.out.println("-----Image��д������ͼ���ļ���ʽ-----");
        for (var tmp : writeFormat) {
            System.out.println(tmp);
        }
    }
}
