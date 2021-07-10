import java.util.Scanner;

public class Puppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double quantityFoodKg = Double.parseDouble(scanner.nextLine())*1000;
        double quantityHayKg = Double.parseDouble(scanner.nextLine())*1000;
        double quantityCoverKg = Double.parseDouble(scanner.nextLine())*1000;
        double guineaWeightinKg = Double.parseDouble(scanner.nextLine())*1000;

        for (int i = 1; i <= 30; i++) {
            quantityFoodKg -= 300;
            if (quantityFoodKg <= 0){
                System.out.println("Merry must go to the pet store!");
                return;
            }
            if (i % 2 == 0){
                quantityHayKg -= quantityFoodKg * 5 / 100;
                if (quantityHayKg <= 0){
                    System.out.println("Merry must go to the pet store!");
                return;

                }
            }
            if (i % 3 == 0){
                quantityCoverKg -= guineaWeightinKg / 3;
               if (quantityCoverKg <= 0 ){
                   System.out.println("Merry must go to the pet store!");
                  return;
               }
            }


        }

        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", quantityFoodKg/1000, quantityHayKg/1000, quantityCoverKg/1000);



    }
}
