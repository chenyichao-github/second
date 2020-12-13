package type;

import java.util.List;

public interface Collection<E> {
    //public static <T> void copy(List<T> dest, List<? extends T> src) {}
    static <T, S extends T> void copy(List<T> dest, List<S> src) {
    }

    //boolean containsAll(Collection<?> c);
    //boolean addAll(Collection<? extends E> c);
    <T> boolean containsAll(Collection<T> c);

    <T extends E> boolean addAll(Collection<T> c);
}
