import java.util.Scanner;
import java.util.regex.Pattern;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHealth = 100;
        int initialBitcoins = 0;
          int bestRoom = 0;
        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            String[] splitedRooms = rooms[i].split("\\s+");
            String command  = splitedRooms[0];
            bestRoom = i+1;
            if (command.equals("potion")){
                int heal = Integer.parseInt(splitedRooms[1]);
                  if(initialHealth + heal >= 100){
                      System.out.printf("You healed for %d hp.%n", 100 - initialHealth);
                      initialHealth = 100;
                      System.out.printf("Current health: %d hp.%n", initialHealth);
                }else  {
                      System.out.printf("You healed for %d hp.%n", heal);
                      initialHealth += heal;
                      System.out.printf("Current health: %d hp.%n", initialHealth);
                  }
            }else if (command.equals("chest")){
                int foundedBitcoins = Integer.parseInt(splitedRooms[1]);
                initialBitcoins += foundedBitcoins;
                System.out.printf("You found %d bitcoins.%n", foundedBitcoins);
            }else {
                int attackOfMonster = Integer.parseInt(splitedRooms[1]);
                initialHealth -= attackOfMonster;
                if (initialHealth <= 0){
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d%n", bestRoom);
                    return;
                }else{
                    System.out.printf("You slayed %s.%n", command);
                }

            }
        }

        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", initialBitcoins);
        System.out.printf("Health: %d%n", initialHealth);
    }
}
