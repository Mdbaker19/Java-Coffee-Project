package daos;

import model.Coffee;

import java.util.List;

public class ListCoffees implements Coffees{
    private List<Coffee> allCoffees;


    public ListCoffees (){
        insert(new Coffee("Light City", "Light", 4.99));
        insert(new Coffee("Half City", "Light", 3.49));
        insert(new Coffee("City", "Medium", 4.59));
        insert(new Coffee("Breakfast", "Medium", 6.99));
        insert(new Coffee("Viennese", "Dark", 18.99));
    }

    public void insert(Coffee coffee){
        this.allCoffees.add(coffee);
    }
    public List<Coffee> all() {
        return this.allCoffees;
    }

}
