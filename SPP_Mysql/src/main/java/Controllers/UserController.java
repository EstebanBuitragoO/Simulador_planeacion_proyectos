package Controllers;

import Models.UserModel;
import Services.UserService;

public class UserController {
    UserService userService;

    public UserController() {
        userService = new UserService();
    }
    
    public String validateUser(String email, String password){
        UserModel user = new UserModel(email, password);
        String userValidate = userService.validateUser(user);
        return userValidate;
    }
    
    public String createUser(String email, String pass, String name){
        UserModel user = new UserModel(email, pass, name);
        String createUser = userService.createUser(user);
        return createUser;
    }

    public UserModel getUserByEmail(String email){
        return userService.getUserByEmail(email);
    }
}
