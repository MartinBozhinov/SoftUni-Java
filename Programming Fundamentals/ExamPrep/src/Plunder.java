import java.util.Scanner;

public class Plunder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double daysOfPlunder = Double.parseDouble(scanner.nextLine());
        double dailyPlunder = Double.parseDouble(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double totalPlunder = 0;
        for (int i = 1; i <= daysOfPlunder; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder += dailyPlunder * 50 / 100;

            }
            if (i % 5 == 0) {
                totalPlunder -= totalPlunder * 30 / 100;

            }

        }

        double percentage = (totalPlunder / expectedPlunder) * 100;
        if (totalPlunder >= expectedPlunder) {

            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);


        }else {

        System.out.printf("Collected only %.2f%% of the plunder.", percentage);
        }

    }


}
