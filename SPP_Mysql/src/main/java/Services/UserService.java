
package Services;

import Models.UserModel;
import ORM.UserORM;

public class UserService {
    UserORM userORM = new UserORM();

    public String validateUser(UserModel user) {
        if (user.getEmail() == null || user.getPassword() == null || user.getEmail().isBlank() || user.getPassword().isBlank()) {
            return "Email y contraseña son requeridos";
        }
        
        UserModel resultUser = userORM.findByEmail(user.getEmail());
        
        if (resultUser == null) {
            return "Usuario no encontrado";
        }
        
        if (!resultUser.getPassword().equals(user.getPassword())) {
            return "Contraseña incorrecta";
        }

        return "Login exitoso";
        
    }

    public String createUser(UserModel user) {
        try {
            userORM.create(user);
            return "Usuario creado exitosamente";
        } catch (Exception e) {
            return("Error al crear usuario: " + e);
        }

    }

    public UserModel getUserByEmail(String email) {
        return userORM.findByEmail(email);
    }
}
