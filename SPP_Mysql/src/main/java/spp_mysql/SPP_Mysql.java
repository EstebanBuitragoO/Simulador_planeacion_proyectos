
package spp_mysql;

import Controllers.UserJpaController;
import Models.User;
import Views.Login;


public class SPP_Mysql {

    public static void main(String[] args) {

        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
    }
}
