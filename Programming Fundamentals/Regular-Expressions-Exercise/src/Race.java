import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String namesRegex = "(?<names>[A-Za-z])";
        String distanceRegex = "(?<distance>[\\d+])";
        Pattern namePattern = Pattern.compile(namesRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);
        Map<String, Integer> racersCountDistance = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            String realName = "";
         int sumOfDigits = 0;

        Matcher matcher = namePattern.matcher(input);
        while (matcher.find()){
            String name = matcher.group("names");
            realName += name;

        }
        if (participants.contains(realName)){
         if (!racersCountDistance.containsKey(realName)){
            racersCountDistance.put(realName, 0);
         }

         Matcher matcher1 = distancePattern.matcher(input);
         while  (matcher1.find()){
             int digit = Integer.parseInt(matcher1.group("distance"));
             sumOfDigits += digit;
         }
           if (racersCountDistance.containsKey(realName)){

           racersCountDistance.put(realName, racersCountDistance.get(realName)+sumOfDigits);
           }else{
               racersCountDistance.put(realName, sumOfDigits);
           }
        }

           input = scanner.nextLine();
        }

        List<String> firstThree = racersCountDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));
    }
}
