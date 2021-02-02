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
        String query = "INSERT INTO coffees (user_id, price, name, type) VALUES (?, ?, ?, ?)";
        try{

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, coffee.getUserId());
            statement.setDouble(2, coffee.getPrice());
            statement.setString(3, coffee.getName());
            statement.setString(4, coffee.getType());
            statement.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Error adding coffee", e);
        }
    }

    public List<Coffee> all() {
        String query = "SELECT * FROM coffees";
        try{
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            return listSet(rs);
        } catch (SQLException e){
            throw new RuntimeException("Error accessing coffee list", e);
        }
    }

    public List<Coffee> listSet(ResultSet rs) throws SQLException {
        List<Coffee> out = new ArrayList<>();
        while(rs.next()){
            out.add(new Coffee(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getDouble("price")
            ));
        }
        return out;
    }
}
