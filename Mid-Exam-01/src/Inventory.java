import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")){

            String[] splitedInput = input.split(" - ");
             String command = splitedInput[0];
            if (command.equals("Collect")){
                String item = splitedInput[1];
                if (!items.contains(item)){
                    items.add(item);
                }
            }else if (command.equals("Drop")){
                String item = splitedInput[1];
               if (items.contains(item)){
                   items.remove(item);
               }
            }else if (command.equals("Combine Items")){
                String[] oldAndNewItem = splitedInput[1].split(":");
                String oldItem = oldAndNewItem[0];
                String newItem = oldAndNewItem[1];
                if (items.contains(oldItem)){
                    items.add(items.indexOf(oldItem)+1, newItem);

                }

            }else if (command.equals("Renew")){
                String item = splitedInput[1];
                if (items.contains(item)){
                    items.remove(item);
                    items.add(item);
                }

            }


            input = scanner.nextLine();

        }
        System.out.println(String.join(", ", items));
    }
}
