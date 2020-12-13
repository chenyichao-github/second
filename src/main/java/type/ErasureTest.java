package type;

class Pear<T extends Number> {
    T size;

    public Pear() {
    }

    public Pear(T size) {
        this.size = size;
    }

    public T getSize() {
        return this.size;
    }

    public void setSize(T size) {
        this.size = size;
    }
}

public class ErasureTest {
    public static void main(String[] args) {
        Pear<Integer> p = new Pear<>(6);
        Integer ps = p.getSize();
        Pear b = p;
        Number size1 = b.getSize();
        //Integer size2 = b.getSize();
    }
}
