package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user = new User("Naruto","uzumaki", (byte) 18);
        User user1 = new User("Donald","trump", (byte) 21);
        User user2 = new User("Tony","Stark", (byte) 24);
        User user3 = new User("Sub","Zero", (byte) 17);

        UserService userService = new UserServiceImpl();
       // userService.createUsersTable();
        // userService.saveUser(user.getName(),user.getLastName(),user.getAge());
       // userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());
        //userService.removeUserById(3L);
       // userService.saveUser(user2.getName(),user2.getLastName(),user2.getAge());
        //userService.saveUser(user3.getName(),user3.getLastName(),user3.getAge());
       // System.out.println(userService.getAllUsers());
        //userService.cleanUsersTable();
       // userService.dropUsersTable();


    }
}
