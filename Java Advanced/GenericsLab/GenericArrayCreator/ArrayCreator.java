package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {


    public static <T> T[] create(Class<T> tClass , int length, T element){

        T[] o = (T[]) Array.newInstance(tClass,length);

        for (int i = 0; i < o.length; i++) {
            o[i] = element;
        }
        return o;
    }
}
