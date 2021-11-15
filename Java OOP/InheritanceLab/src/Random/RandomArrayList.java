package Random;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public Object getRandomElement(){
       int index = RANDOM.nextInt();
       Object o = super.get(index);
       super.remove(index);
       return o;
    }
}
