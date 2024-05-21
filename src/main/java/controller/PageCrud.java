package controller;

import crudBase.CrudUtil;
import entity.personalPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageCrud {
    private static final String INSERT_PAGE = "INSERT INTO personal_pages(id, role, bio) VALUES (?, ?, ?);";
    private static final String UPDATE_PAGE = "UPDATE personal_pages SET role=? AND bio=? WHERE id=?";
    private static final String DELETE_PAGE = "DELETE FROM personal_pages WHERE id=?";

    public static List<personalPage> getPageData(String query){
        List<personalPage> personalPages =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(query)){
            {
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String role= rs.getString("role");
                    String bio= rs.getString("bio");
                    personalPages.add(new personalPage(id, role, bio));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  personalPages;
    }

    public static List<personalPage> addPage(personalPage page){
        List<personalPage> personalPages =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_PAGE)){
            {
                preparedStatement.setInt(1 , page.getId());
                preparedStatement.setString(2 , page.getRole());
                preparedStatement.setString(3 , page.getBio());

                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement allUsers=connection.prepareStatement("SELECT * FROM personal_pages");
                ResultSet rs = allUsers.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String role= rs.getString("role");
                    String bio= rs.getString("bio");
                    personalPages.add(new personalPage(id, role, bio));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  personalPages;
    }

    public static List<personalPage> updatePage(personalPage page){
        List<personalPage> personalPages =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_PAGE)){
            {
                preparedStatement.setInt(3 , page.getId());
                preparedStatement.setString(1 , page.getRole());
                preparedStatement.setString(2 , page.getBio());

                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement allUsers=connection.prepareStatement("SELECT * FROM personal_pages");
                ResultSet rs = allUsers.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String role= rs.getString("role");
                    String bio= rs.getString("bio");
                    personalPages.add(new personalPage(id, role, bio));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  personalPages;
    }

    public static List<personalPage> updatePage(int pageId){
        List<personalPage> personalPages =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_PAGE)){
            {
                preparedStatement.setInt(1 , pageId);


                preparedStatement.executeUpdate();

                //next part is for testing
                PreparedStatement allUsers=connection.prepareStatement("SELECT * FROM personal_pages");
                ResultSet rs = allUsers.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String role= rs.getString("role");
                    String bio= rs.getString("bio");
                    personalPages.add(new personalPage(id, role, bio));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  personalPages;
    }
    
}
