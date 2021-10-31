package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

          String[] input = scanner.nextLine().split("\\s+");
          int n = Integer.parseInt(scanner.nextLine());


          TrafficLigth[] lights = new TrafficLigth[input.length];

        for (int i = 0; i <input.length ; i++) {
            lights[i] = TrafficLigth.valueOf(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        TrafficLigth[] lightsVAlues = {TrafficLigth.RED,TrafficLigth.GREEN,TrafficLigth.YELLOW};
        while (n-- > 0){
            for (int i = 0; i <lights.length ; i++) {
                if (lights[i].ordinal() == 2){
                  lights[i] = TrafficLigth.RED;
                }else{
                    lights[i] = lightsVAlues[lights[i].ordinal()+1];
                }
                sb.append(lights[i].toString()).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());

    }
}
