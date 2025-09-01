
package Services;

import Controllers.UserJpaController;
import Models.User;

public class UserService {
    UserJpaController uc = new UserJpaController();

    public String validateUser(String email, String pass) {
        
        User user = uc.findByEmail(email);
        
        if (user == null) {
            return "Usuario no encontrado";
        }
        
        if (!user.getPassword().equals(pass)) {
            return "Contraseña incorrecta";
        }

        return "Login exitoso";
        
    }

    public String createUser(String email, String pass, String name) {
        System.out.println("aca");
        System.out.println(email);
        System.out.println(pass);
        System.out.println(name);
        try {
            User user = new User(email, pass, name);
            System.out.println(user);
            uc.create(user);
            return "Usuario creado exitosamente";
        } catch (Exception e) {
            return("Error al crear usuario: " + e);
        }
        
    }
}
