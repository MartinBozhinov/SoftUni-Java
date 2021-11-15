package animals;

public class Frog extends Animal {
    private String name;
    private int age;
    private String gender;

    public Frog(String name, int age, String gender) {
        super(name, age,gender);
    }


    public String produceSound(){
        return  "Ribbit";
    }
}
