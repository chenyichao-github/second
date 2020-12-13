package locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {
    public static void main(String[] args) {
        var myLocale = Locale.getDefault(Locale.Category.FORMAT);
        var bundle = ResourceBundle.getBundle("mess", myLocale);
        System.out.println(bundle.getString("hello"));
    }
}
