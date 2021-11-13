package shoppingSpree;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
       private String name;
       private double money;
       private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;

    }

    public void buyProduct(Product product){
       if (this.money < product.getCost()){
        throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
       }
       products.add(product);
       this.money -= product.getCost();
    }
    @Override
    public String toString() {
        String postfix = this.products.size() > 0 ?
                products.stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "))
                : "Nothing bought";
        return this.name + " - " + postfix;
    }

}
