import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstEmployeeEficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEficiency = Integer.parseInt(scanner.nextLine());

        int totalPeople  = Integer.parseInt(scanner.nextLine());


        int timeNeeded = 0;
        int allEmployees = firstEmployeeEficiency + secondEmployeeEficiency+thirdEmployeeEficiency;

        while (totalPeople > 0){

            totalPeople -= allEmployees;
            timeNeeded++;
            if (timeNeeded % 4 == 0){
                timeNeeded ++;
            }

        }
        System.out.printf("Time needed: %dh.", timeNeeded);
    }
}
