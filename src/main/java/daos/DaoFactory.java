package daos;

public class DaoFactory {
    private static Coffees coffeesDao;
    private static Config config;

    public static Coffees getCoffeesDao(){
        if(coffeesDao == null){
            coffeesDao = new ListCoffees(config);
        }
        return coffeesDao;
    }
}
