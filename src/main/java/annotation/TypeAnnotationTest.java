package annotation;

import javax.swing.*;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

@Target(ElementType.TYPE_USE)
@interface NotNull {
}

@NotNull
public class TypeAnnotationTest implements @NotNull /* implement时使用类型注解 */ Serializable {
    private static final long serialVersionUID = -4858451282661482235L;

    public static void main(@NotNull String[] args) {
        Object obj = "fkjava.org";
        String str = (@NotNull String) obj;
        Object win = new @NotNull JFrame("疯狂软件");
    }

    public void foo(List<@NotNull String> info) {
    }
}
