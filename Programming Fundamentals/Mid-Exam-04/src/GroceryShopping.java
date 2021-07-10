import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GroceryShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")){
            String[] splitedInput = input.split( "\\s+");
            String command = splitedInput[0];
            if (command.equals("Urgent")){

                String item = splitedInput[1];
                 if (!shoppingList.contains(item)){
                      shoppingList.add(0, item);
                 }
            }else if (command.equals("Unnecessary")){

                String item = splitedInput[1];
                if (shoppingList.contains(item)){
                    shoppingList.remove(item);
                }
            }else if (command.equals("Correct")){
              String oldItem = splitedInput[1];
              String newItem = splitedInput[2];

              if (shoppingList.contains(oldItem)){

                  shoppingList.add(shoppingList.indexOf(oldItem), newItem);
                  shoppingList.remove(oldItem);

              }
            }else if (command.equals("Rearrange")){
                String item = splitedInput[1];

                if (shoppingList.contains(item)){
                    shoppingList.remove(item);
                    shoppingList.add(shoppingList.size() - 1, item);
                }
            }
            input = scanner.nextLine();
        }
        System.out.print(String.join(", ", shoppingList));
    }
}
