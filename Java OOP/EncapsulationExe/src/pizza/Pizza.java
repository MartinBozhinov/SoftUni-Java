package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dought;
    private List<Topping> toppings;


    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }


    private void setName(String name) {

        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public void setDough(Dough dought){
        this.dought = dought;
    }

    public double getOverallCalories(){
        return  dought.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }




    private void setToppings(int numberOfToppings) {
      if (numberOfToppings < 0 || numberOfToppings > 10){
           throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
      }
      this.toppings = new ArrayList<>();

    }




}
