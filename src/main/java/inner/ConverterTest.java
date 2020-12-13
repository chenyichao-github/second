package inner;

public class ConverterTest {
    public static void main(String[] args) {
        Converter converter1 = Integer::valueOf;
        Integer val = converter1.convert("99");
        System.out.println(val);
        //Converter converter2 = from -> "fkit.org".indexOf(from);
        Converter converter2 = "fkit.org"::indexOf;
        Integer value = converter2.convert("it");
        System.out.println(value);
    }
}
