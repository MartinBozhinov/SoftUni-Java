import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double finalPrice = 0.0;
        List<String> furniture = new ArrayList<>();

          String regex = ">>([A-Za-z]+)<<([0-9]+\\.?[0-9]+)!([0-9]+)";

          Pattern pattern = Pattern.compile(regex);
           double totalPrice = 0.0;
          String input = scanner.nextLine();
          while (!input.equals("Purchase")){
              Matcher matcher = pattern.matcher(input);
              while (matcher.find()){
                  String name = matcher.group(1);
                  double price = Double.parseDouble(matcher.group(2));
                  int  quantity = Integer.parseInt(matcher.group(3));

                  furniture.add(name);
                totalPrice += price * quantity;

              }
              input = scanner.nextLine();

          }

        System.out.println("Bought furniture:");
        for (String object : furniture) {
            System.out.println(object);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);


    }
}
