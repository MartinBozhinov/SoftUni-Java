import java.util.Arrays;
import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOfSTrings = scanner.nextLine().split("\\s+");

        String result = "";

        for (int i = 0; i < arrayOfSTrings.length; i++) {

            result += result(arrayOfSTrings[i], arrayOfSTrings[i].length());
        }

        System.out.println(result);

    }

    private static String result(String arrayOfSTring, int length) {

        String result = "";

        for (int i = 0; i < length; i++) {
            result += arrayOfSTring;
        }
        return result;
    }

}
