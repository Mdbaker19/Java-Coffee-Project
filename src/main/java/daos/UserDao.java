package daos;

import model.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Users {

    private Connection connection;

    public UserDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e){
            throw new RuntimeException("Unable to connect to user Database", e);
        }
    }


    @Override
    public void insert(User user){
        String query = "Insert into users (username, password, email) VAlues (?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Error creating new user", e);
        }
    }
}
