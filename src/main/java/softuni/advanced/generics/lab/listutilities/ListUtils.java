package softuni.advanced.generics.lab.listutilities;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        return get(list, Collections::max);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        return get(list, Collections::min);
    }

    private static <T extends Comparable<T>> T get(List<T> list, Function<List<T>, T> func) {
        listValidation(list);
        return func.apply(list);
    }

    private static <T> void listValidation(List<T> list) {
        if (list.isEmpty()) {
            String message = "Argument 'List<T> list' is empty!";
            throw new IllegalArgumentException(message);
        }
    }
}
