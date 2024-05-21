package controller;

import crudBase.CrudUtil;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCrud {


    private static final String INSERT_USER = "INSERT INTO users(id, username, page_id) VALUES (?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE users SET username=? WHERE id=?";
    private static final String DELETE_USER = "DELETE FROM users WHERE id=?";

    public static List<User> getUserData(String query){
        List<User> users =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(query)){
            {
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){
                     int id = rs.getInt("id");
                     String userName= rs.getString("username");
                     int pageId = rs.getInt("page_id");

                     users.add(new User(id, userName, pageId));
                }
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  users;
    }

    public static List<User> addUser(User user) {
        List<User> users =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER)){
            {
                preparedStatement.setInt(1 , user.getId());
                preparedStatement.setString(2 , user.getUserName());
                preparedStatement.setInt(3, user.getPageId());
                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement allUsers=connection.prepareStatement("SELECT * FROM users");
                ResultSet rs = allUsers.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id");
                    String userName= rs.getString("username");
                    int pageId = rs.getInt("page_id");

                    users.add(new User(id, userName, pageId));
                }
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  users;
    }

    public static List<User> updateUser(User user) {
        List<User> upadatedUsers =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USER)){
            {
                preparedStatement.setString(1 , user.getUserName());
                preparedStatement.setInt(2, user.getId());
                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement allUsers=connection.prepareStatement("SELECT * FROM users");
                ResultSet rs = allUsers.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id");
                    String userName= rs.getString("username");
                    int pageId = rs.getInt("page_id");

                    upadatedUsers.add(new User(id, userName, pageId));
                }
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  upadatedUsers;
    }

    public static List<User> deleteUser(int userId) {
        List<User> users =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER)){
            {
                preparedStatement.setInt(1 , userId);
                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement allUsers=connection.prepareStatement("SELECT * FROM users");
                ResultSet rs = allUsers.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id");
                    String userName= rs.getString("username");
                    int pageId = rs.getInt("page_id");

                    users.add(new User(id, userName, pageId));
                }
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  users;
    }


}
