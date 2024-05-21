

import controller.PageCrud;
import controller.UserCrud;
import entity.User;
import entity.personalPage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PageCrud.addPage(new personalPage(1, "very cool", "The coolest"));
        UserCrud.addUser(new User(1, "coolDude", 1));
        List<User> userRes= UserCrud.getUserData("SELECT * FROM users");
        System.out.println(userRes);
    }
}