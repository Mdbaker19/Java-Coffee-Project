package daos;

import model.Coffee;

import java.util.List;

public interface Coffees {
    List<Coffee> all();
    void insert(Coffee coffee);
}
