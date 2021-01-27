package daos;

import model.Coffee;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListCoffees implements Coffees{
    private Connection connection;


    public ListCoffees (Config config){

        try{
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(Coffee coffee){
        String query = String.format("INSERT INTO coffees (price, name, type) VALUES (%f, %s, %s)", coffee.getPrice(), coffee.getName(), coffee.getType());

    }



    public List<Coffee> all() {
        List<Coffee> out = new ArrayList<>();
        String query = "SELECT * FROM coffees";
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()){
                out.add(new Coffee(
                   rs.getString("name"),
                   rs.getString("type"),
                   rs.getDouble("price")
                ));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }


        return out;
    }

}
