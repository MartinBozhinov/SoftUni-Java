import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());

        TreeMap<Double,Integer> counts = new TreeMap<>();

        for (Double number : numbers) {
            if (counts.containsKey(number)){
                counts.put(number, counts.get(number)+1);

            }else{
                counts.put(number, 1);
            }

        }
           DecimalFormat dc = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%s -> %s%n", dc.format(entry.getKey()), entry.getValue());
        }


    }




}
