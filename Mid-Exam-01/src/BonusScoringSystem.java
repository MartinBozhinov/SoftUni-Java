import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       double students = Double.parseDouble(scanner.nextLine());
       double lectures = Double.parseDouble(scanner.nextLine());
       double bonus = Double.parseDouble(scanner.nextLine());
       double maxBonus = 0;
       double bestStudent = 0;
        for (int i = 0; i < students; i++) {

        double attendance = Double.parseDouble(scanner.nextLine());

        double totalBonus  = (attendance  / lectures) * (5 + bonus);
        if (maxBonus < totalBonus){
            maxBonus = totalBonus;
            bestStudent = attendance;
        }
        }
        int maxBonuss = (int)Math.round(maxBonus);
        int bestStudentss = (int)Math.round(bestStudent);

        System.out.printf("Max Bonus: %d.%n", maxBonuss);
        System.out.printf("The student has attended %d lectures.",bestStudentss );
    }
}
