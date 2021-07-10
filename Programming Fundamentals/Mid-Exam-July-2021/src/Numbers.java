import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());


        String input = scanner.nextLine();
        while (!input.equals("Finish")){
            String[] splitedInput = input.split("\\s+");

            String command = splitedInput[0];

            if (command.equals("Add")){
                int number = Integer.parseInt(splitedInput[1]);

                numbers.add(number);

            }else if (command.equals("Remove")){

                int number = Integer.parseInt(splitedInput[1]);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.contains(number)){
                        numbers.remove(Integer.valueOf(number));
                        break;
                    }
                }

            }else if (command.equals("Replace")){
              int number = Integer.parseInt(splitedInput[1]);
              int numberToSet = Integer.parseInt(splitedInput[2]);

                for (int i = 0; i < numbers.size(); i++) {
                    if (number==numbers.get(i)){
                      numbers.set(i, numberToSet);
                      break;
                    }
                }
            }else if (command.equals("Collapse")){
                int number = Integer.parseInt(splitedInput[1]);

                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) < number) {
                        numbers.remove(numbers.get(i));
                    }
                }
            }

            input = scanner.nextLine();

        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
