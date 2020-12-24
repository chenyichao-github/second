package reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

@Repeatable(Annos.class)
@interface Anno {
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos {
    Anno[] value();
}

@SuppressWarnings(value = "unchecked")
@Deprecated
@Anno
@Anno
public class ClassTest {
    private ClassTest() {
    }

    public ClassTest(String name) {
        System.out.println("ִ���в����Ĺ�����");
    }

    public static void main(String[] args) throws Exception {
        Class<ClassTest> clazz = ClassTest.class;
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest��ȫ�����������£�");
        for (var c : ctors) {
            System.out.println(c);
        }
        Constructor[] publicCtors = clazz.getConstructors();
        System.out.println("ClassTest��ȫ��public���������£�");
        for (var c : publicCtors) {
            System.out.println(c);
        }
        Method[] mtds = clazz.getMethods();
        System.out.println("ClassTest��ȫ��public�������£�");
        for (var md : mtds) {
            System.out.println(md);
        }
        System.out.println("ClassTest���һ���ַ���������info����Ϊ��" + clazz.getMethod("info", String.class));
        Annotation[] anns = clazz.getAnnotations();
        System.out.println("ClassTest��ȫ��Annotation���£�");
        for (var an : anns) {
            System.out.println(an);
        }
        System.out.println("��ClassԪ���ϵ�@SuppressWarningsע��Ϊ��" + Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));
        System.out.println("��ClassԪ����@Annoע��Ϊ��" + Arrays.toString(clazz.getAnnotationsByType(Anno.class)));
        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("ClassTest��ȫ���ڲ������£�");
        for (var c : inners) {
            System.out.println(c);
        }
        Class inClazz = Class.forName("reflection.ClassTest$Inner");
        System.out.println("inClazz��Ӧ����ⲿ��Ϊ��" + inClazz.getDeclaringClass());
        System.out.println("ClassTest�İ�Ϊ��" + clazz.getPackage());
        System.out.println("ClassTest�ĸ���Ϊ��" + clazz.getSuperclass());
    }

    public void info() {
        System.out.println("ִ���޲�����info����");
    }

    public void info(String str) {
        System.out.println("ִ���в�����info����" + "����str����ֵ��" + str);
    }

    class Inner {
    }
}
