package softuni.advanced.generics.lab.arraycreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    public static <T> T[] create(int length, T item){
        return create(item.getClass(), length, item);
    }

    public static <T> T[] create(Class<?> cl, int length, T item){
        T[] arr = (T[]) Array.newInstance(cl, length);
        Arrays.fill(arr, item);
        return arr;
    }
}