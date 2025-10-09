
package spp_mysql;

import Views.JFAuth;


public class SPP_Mysql {

    public static void main(String[] args) {
        JFAuth auth = new JFAuth();
        auth.setVisible(true);
        auth.pack();
        auth.setLocationRelativeTo(null);
    }
}
