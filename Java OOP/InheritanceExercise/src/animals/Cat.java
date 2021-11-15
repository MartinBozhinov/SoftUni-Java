package animals;

public class Cat extends Animal {
    private String name;
    private int age;
    private String gender;

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }


    public String produceSound(){
        return  "Meow meow";
    }


}
