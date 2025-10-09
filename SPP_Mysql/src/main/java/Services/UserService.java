
package Services;

import Models.UserModel;
import ORM.UserORM;

public class UserService {
    UserORM userORM = new UserORM();

    public String validateUser(UserModel user) {
        if (user.getEmail() == null || user.getPassword() == null || user.getEmail().isBlank() || user.getPassword().isBlank()) {
            return "Email y contraseña son requeridos";
        }

        String normalizedEmail = user.getEmail().trim().toLowerCase();
        UserModel resultUser = userORM.findByEmail(normalizedEmail);

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
            String normalizedEmail = user.getEmail().trim().toLowerCase();
            user.setEmail(normalizedEmail);
            userORM.create(user);
            return "Usuario creado exitosamente";
        } catch (Exception e) {
            return("Error al crear usuario: " + e);
        }

    }

    public UserModel getUserByEmail(String email) {
        String normalizedEmail = email.trim().toLowerCase();
        return userORM.findByEmail(normalizedEmail);
    }

    public java.util.List<UserModel> getAllUsers() {
        return userORM.findAll();
    }
}
