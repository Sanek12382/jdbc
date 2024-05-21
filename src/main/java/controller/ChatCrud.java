package controller;

import crudBase.CrudUtil;
import entity.groupChat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatCrud {

    private static final String INSERT_CHAT = "INSERT INTO group_chats(id, chatname, messages) VALUES (?, ?, ?);";
    private static final String UPDATE_CHAT = "UPDATE group_chats SET chatname=? WHERE id=?";
    private static final String DELETE_CHAT = "DELETE FROM group_chats WHERE id=?";

    public static List<groupChat> getChatData(String query){
        List<groupChat> groupChats =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(query)){
            {
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String chatname= rs.getString("chatname");
                    String messages= rs.getString("messages");
                    groupChats.add(new groupChat(chatname, messages, id));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  groupChats;
    }

    public static List<groupChat> addChat(groupChat chat){
        List<groupChat> groupChats =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_CHAT)){
            {
                preparedStatement.setInt(1 , chat.getId());
                preparedStatement.setString(2 , chat.getChatname());
                preparedStatement.setString(3 , chat.getMessages());
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String chatname= rs.getString("chatname");
                    String messages= rs.getString("messages");
                    groupChats.add(new groupChat(chatname, messages, id));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  groupChats;
    }

    public static List<groupChat> upddateChat(groupChat chat){
        List<groupChat> groupChats =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_CHAT)){
            {
                preparedStatement.setInt(1 , chat.getId());
                preparedStatement.setString(2 , chat.getChatname());
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String chatname= rs.getString("chatname");
                    String messages= rs.getString("messages");
                    groupChats.add(new groupChat(chatname, messages, id));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  groupChats;
    }

    public static List<groupChat> upddateChat(int chatId){
        List<groupChat> groupChats =new ArrayList<>();

        try (Connection connection= CrudUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_CHAT)){
            {
                preparedStatement.setInt(1 , chatId);
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){

                    int id = rs.getInt("id");
                    String chatname= rs.getString("chatname");
                    String messages= rs.getString("messages");
                    groupChats.add(new groupChat(chatname, messages, id));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  groupChats;
    }
}
