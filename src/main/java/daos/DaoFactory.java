package daos;

public class DaoFactory {
    private static Coffees coffeesDao;

    public static Coffees getCoffeesDao(){
        if(coffeesDao == null){
            coffeesDao = new ListCoffees();
        }
        return coffeesDao;
    }
}
