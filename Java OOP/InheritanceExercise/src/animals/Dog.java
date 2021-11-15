package animals;

import org.w3c.dom.ls.LSOutput;

public class Dog extends Animal {
    private String name;
    private int age;
    private String gender;

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }


    public String produceSound(){
        return  "Woof!";
    }



}
