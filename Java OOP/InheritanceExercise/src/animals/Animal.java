package animals;

import java.awt.dnd.InvalidDnDOperationException;

public abstract class Animal {
    private String name;
    private String gender;
    private int age;

    public Animal(String name,int age , String gender) {
        this.name = name;

        this.gender = gender;
        this.setAge(age);
    }

    private void setAge(int age) {
        if (age < 0){
            throw new InvalidDnDOperationException("Invalid input!");
        }
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    public abstract  String produceSound();

    @Override
    public String toString() {
          return String.format("%s%n%s %d %s%n%s",
                  this.getClass().getSimpleName()
          ,        this.getName()
          ,        this.getAge()
          ,        this.getGender());
    }
}
