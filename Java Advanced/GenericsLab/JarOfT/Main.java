package JarOfT;

public class Main {

    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        jar.add(2);
        jar.add(4);
        jar.add(5);
        jar.add(6);
        jar.add(7);
        jar.add(8);



        System.out.println(jar.remove());


    }
}
