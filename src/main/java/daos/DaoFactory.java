package daos;

import java.sql.SQLException;

public class DaoFactory {
    private static Coffees coffeesDao;
    private static Users userDao;
    private static Config config;

    public static Coffees getCoffeesDao() {
        if (coffeesDao == null) {
            coffeesDao = new ListCoffees(config);
        }
        return coffeesDao;
    }

    public static Users getUserDao() {
        if (userDao == null) {
            userDao = new UserDao(config);
        }
        return userDao;
    }
}
