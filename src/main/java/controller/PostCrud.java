package controller;

import crudBase.CrudUtil;
import entity.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostCrud {
    private static final String INSERT_POST = "INSERT INTO posts(id, title, body, user_id, status) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_POST = "UPDATE posts SET body=? WHERE id=?";
    private static final String DELETE_POST = "DELETE FROM posts WHERE id=?";

    public static List<Post> getPostData(String query){
        List<Post> posts =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(query)){
            {
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){

                     int id = rs.getInt("id");
                     int userId = rs.getInt("user_id");
                     String body= rs.getString("body");
                     String title= rs.getString("title");
                     String status= rs.getString("status");
                    posts.add(new Post(id, userId, body, title , status));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  posts;
    }

    public static List<Post> addPost(Post post){
        List<Post> posts =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_POST)){
            {
                preparedStatement.setInt(1 , post.getId());
                preparedStatement.setString(2 , post.getTitle());
                preparedStatement.setString(3 , post.getBody());
                preparedStatement.setInt(4, post.getUserId());
                preparedStatement.setString(5 , post.getStatus());
                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement all=connection.prepareStatement("SELECT * FROM posts");
                ResultSet rs = all.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String body= rs.getString("body");
                    String title= rs.getString("title");
                    String status= rs.getString("status");

                    posts.add(new Post(id, userId, body, title , status));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  posts;
    }
    public static List<Post> updatePost(Post post){
        List<Post> posts =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_POST)){
            {
                preparedStatement.setInt(2 , post.getId());
                preparedStatement.setString(1 , post.getBody());

                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement all=connection.prepareStatement("SELECT * FROM posts");
                ResultSet rs = all.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String body= rs.getString("body");
                    String title= rs.getString("title");
                    String status= rs.getString("status");

                    posts.add(new Post(id, userId, body, title , status));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  posts;
    }

    public static List<Post> deletePost(int postId){
        List<Post> posts =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_POST)){
            {
                preparedStatement.setInt(1 , postId);
                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement all=connection.prepareStatement("SELECT * FROM posts");
                ResultSet rs = all.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String body= rs.getString("body");
                    String title= rs.getString("title");
                    String status= rs.getString("status");

                    posts.add(new Post(id, userId, body, title , status));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  posts;
    }
}
