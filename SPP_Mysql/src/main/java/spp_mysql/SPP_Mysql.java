
package spp_mysql;

import Controllers.UserJpaController;
import Models.User;
import Views.JFAuth;
import Views.Login;


public class SPP_Mysql {

    public static void main(String[] args) {
        
        JFAuth auth= new JFAuth();
        auth.setVisible(true);
        auth.pack();
        auth.setLocationRelativeTo(null);

        //Login login = new Login();
        //login.setVisible(true);
        //login.pack();
        //login.setLocationRelativeTo(null);
    }
}
