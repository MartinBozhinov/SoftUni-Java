package ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T> {

    private List<T> list;

    public ListUtils() {
        this.list = new ArrayList<>();
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            T min = list.get(0);
            for (int i = 1; i <list.size() ; i++) {

                if (min.compareTo(list.get(i)) > 0){
                     min = list.get(i);
                }
            }
            return min;
        }
    }

       public static <T extends Comparable<T>> T getMax(List<T> list){
           if (list.size() == 0) {
               throw new IllegalArgumentException();
           } else {
               T max = list.get(0);
               for (int i = 1; i <list.size() ; i++) {
                   if (max.compareTo(list.get(i)) < 0){
                       max = list.get(i);
                   }
               }
               return max;
           }
       }






}
