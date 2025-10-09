package Views;

import Controllers.UserController;
import Models.UserModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class JFAuth extends javax.swing.JFrame {
    UserController userController;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFAuth.class.getName());

    public JFAuth() {
        initComponents();
        userController = new UserController();
        CardLayout cardLayoutAuth=(CardLayout) authPanel.getLayout();
        cardLayoutAuth.show(authPanel, "login");

        setupPlaceholders();
        fixFieldColors();
        fixLayoutIssues();
        setupEnterKeyListeners();
    }

    private void setupPlaceholders() {
        addPlaceholder(txtEmailLogin, "Ingrese su correo electrónico");
        addPlaceholder(txtEmailRegister, "Ingrese su correo electrónico");
        addPlaceholder(txtNickName, "Ingrese su nombre de usuario");
        addPasswordPlaceholder(txtPasswordLogin, "Ingrese su contraseña");
        addPasswordPlaceholder(txtPasswordRegister, "Ingrese su contraseña");
        hideObsoleteLabels();
    }

    private void addPlaceholder(javax.swing.JTextField textField, String placeholder) {
        Color placeholderColor = new Color(153, 153, 153);
        Color textColor = new Color(51, 51, 51);

        textField.setText(placeholder);
        textField.setForeground(placeholderColor);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(textColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(placeholderColor);
                }
            }
        });
    }

    private void addPasswordPlaceholder(JPasswordField passwordField, String placeholder) {
        Color placeholderColor = new Color(153, 153, 153);
        Color textColor = new Color(51, 51, 51);

        passwordField.setText(placeholder);
        passwordField.setForeground(placeholderColor);
        passwordField.setEchoChar((char) 0);

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(placeholder)) {
                    passwordField.setText("");
                    passwordField.setForeground(textColor);
                    passwordField.setEchoChar('•');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setText(placeholder);
                    passwordField.setForeground(placeholderColor);
                    passwordField.setEchoChar((char) 0);
                }
            }
        });
    }

    private void hideObsoleteLabels() {
        if (titleUser != null) titleUser.setVisible(false);
        if (titlePassword != null) titlePassword.setVisible(false);
        if (titlePasswordLogin != null) titlePasswordLogin.setVisible(false);
        if (titleNickname != null) titleNickname.setVisible(false);
        if (txtEmailLogin2 != null) txtEmailLogin2.setVisible(false);
    }

    private void fixFieldColors() {
        Color fieldColor = Color.WHITE;

        txtEmailLogin.setBackground(fieldColor);
        txtPasswordLogin.setBackground(fieldColor);
        txtEmailRegister.setBackground(fieldColor);
        txtPasswordRegister.setBackground(fieldColor);
        txtNickName.setBackground(fieldColor);
    }

    private void fixLayoutIssues() {
        try {
            if (txtPasswordRegister != null && txtEmailRegister != null) {
                txtPasswordRegister.setBounds(
                    txtPasswordRegister.getX(),
                    txtPasswordRegister.getY(),
                    txtEmailRegister.getWidth(),
                    txtPasswordRegister.getHeight()
                );
            }

            if (jSeparator6 != null && txtNickName != null) {
                jSeparator6.setBounds(
                    txtNickName.getX(),
                    txtNickName.getY() + txtNickName.getHeight() + 2,
                    txtNickName.getWidth(),
                    jSeparator6.getHeight()
                );
            }

            if (jSeparator1 != null && txtEmailLogin != null) {
                jSeparator1.setBounds(
                    txtEmailLogin.getX(),
                    txtEmailLogin.getY() + txtEmailLogin.getHeight() + 2,
                    txtEmailLogin.getWidth(),
                    jSeparator1.getHeight()
                );
            }

            if (jSeparator2 != null && txtPasswordLogin != null) {
                jSeparator2.setBounds(
                    txtPasswordLogin.getX(),
                    txtPasswordLogin.getY() + txtPasswordLogin.getHeight() + 2,
                    txtPasswordLogin.getWidth(),
                    jSeparator2.getHeight()
                );
            }

            if (jSeparator3 != null && txtEmailRegister != null) {
                jSeparator3.setBounds(
                    txtEmailRegister.getX(),
                    txtEmailRegister.getY() + txtEmailRegister.getHeight() + 2,
                    txtEmailRegister.getWidth(),
                    jSeparator3.getHeight()
                );
            }

            if (jSeparator4 != null && txtPasswordRegister != null) {
                jSeparator4.setBounds(
                    txtPasswordRegister.getX(),
                    txtPasswordRegister.getY() + txtPasswordRegister.getHeight() + 2,
                    txtPasswordRegister.getWidth(),
                    jSeparator4.getHeight()
                );
            }

        } catch (Exception e) {
            logger.warning("Error ajustando layout: " + e.getMessage());
        }
    }

    private void setupEnterKeyListeners() {
        txtEmailLogin.addActionListener(e -> btnLogin.doClick());
        txtPasswordLogin.addActionListener(e -> btnLogin.doClick());

        txtEmailRegister.addActionListener(e -> btnRegister.doClick());
        txtPasswordRegister.addActionListener(e -> btnRegister.doClick());
        txtNickName.addActionListener(e -> btnRegister.doClick());
    }


    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        authPanel = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        txtLogin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmailLogin = new javax.swing.JTextField();
        txtPasswordLogin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        registerLink = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        imgBlack = new javax.swing.JPanel();
        titlePasswordLogin = new javax.swing.JTextField();
        txtEmailLogin2 = new javax.swing.JTextField();
        register = new javax.swing.JPanel();
        txtRegister = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmailRegister = new javax.swing.JTextField();
        txtPasswordRegister = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        loginLink = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        imgBlack1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        titlePassword = new javax.swing.JTextField();
        titleUser = new javax.swing.JTextField();
        titleNickname = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        authPanel.setToolTipText("");
        authPanel.setLayout(new java.awt.CardLayout());

        login.setToolTipText("Ingrese su correo electronico");

        login.setMaximumSize(new java.awt.Dimension(400, 500));

        login.setMinimumSize(new java.awt.Dimension(400, 500));
        login.setRequestFocusEnabled(false);

        txtLogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(255, 102, 0));
        txtLogin.setText("Iniciar sesion");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 63, 98));
        jLabel2.setText("USUARIO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 63, 98));
        jLabel3.setText("CONTRASEÑA");

        txtEmailLogin.setBackground(new java.awt.Color(242, 242, 242));
        txtEmailLogin.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtEmailLogin.setForeground(new java.awt.Color(153, 153, 153));
        txtEmailLogin.setBorder(null);

        txtPasswordLogin.setBackground(new java.awt.Color(242, 242, 242));
        txtPasswordLogin.setBorder(null);
        txtPasswordLogin.setPreferredSize(new java.awt.Dimension(64, 28));

        btnLogin.setBackground(new java.awt.Color(255, 101, 0));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("ENTRAR");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        registerLink.setBackground(new java.awt.Color(242, 242, 242));
        registerLink.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        registerLink.setForeground(new java.awt.Color(255, 102, 0));
        registerLink.setText("¿Aun no tienes cuenta? Registrate aqui.");
        registerLink.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        registerLink.setBorderPainted(false);
        registerLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerLinkActionPerformed(evt);
            }
        });

        imgBlack.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout imgBlackLayout = new javax.swing.GroupLayout(imgBlack);
        imgBlack.setLayout(imgBlackLayout);
        imgBlackLayout.setHorizontalGroup(
            imgBlackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        imgBlackLayout.setVerticalGroup(
            imgBlackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        titlePasswordLogin.setEditable(false);
        titlePasswordLogin.setBackground(new java.awt.Color(242, 242, 242));
        titlePasswordLogin.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        titlePasswordLogin.setForeground(new java.awt.Color(153, 153, 153));
        titlePasswordLogin.setText("Ingrese su correo electronico");
        titlePasswordLogin.setBorder(null);
        titlePasswordLogin.setFocusable(false);

        txtEmailLogin2.setEditable(false);
        txtEmailLogin2.setBackground(new java.awt.Color(242, 242, 242));
        txtEmailLogin2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtEmailLogin2.setForeground(new java.awt.Color(153, 153, 153));
        txtEmailLogin2.setText("Ingrese su correo electronico");
        txtEmailLogin2.setBorder(null);
        txtEmailLogin2.setFocusable(false);
        txtEmailLogin2.setRequestFocusEnabled(false);
        txtEmailLogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailLogin2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerLink)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(titlePasswordLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtPasswordLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtEmailLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(imgBlack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtLogin)
                .addGap(73, 73, 73)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(titlePasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerLink)
                .addGap(68, 68, 68))
            .addComponent(imgBlack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        authPanel.add(login, "login");

        register.setToolTipText("Ingrese su correo electronico");
        register.setMaximumSize(new java.awt.Dimension(400, 500));
        register.setMinimumSize(new java.awt.Dimension(400, 500));

        txtRegister.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtRegister.setForeground(new java.awt.Color(255, 102, 0));
        txtRegister.setText("Registro");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 63, 98));
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 63, 98));
        jLabel5.setText("CONTRASEÑA");

        txtEmailRegister.setBackground(new java.awt.Color(242, 242, 242));
        txtEmailRegister.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtEmailRegister.setForeground(new java.awt.Color(51, 51, 51));
        txtEmailRegister.setBorder(null);

        txtPasswordRegister.setBackground(new java.awt.Color(242, 242, 242));
        txtPasswordRegister.setBorder(null);
        txtPasswordRegister.setMinimumSize(new java.awt.Dimension(64, 14));
        txtPasswordRegister.setPreferredSize(new java.awt.Dimension(64, 14));

        btnRegister.setBackground(new java.awt.Color(255, 101, 0));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("REGISTRAR");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        loginLink.setBackground(new java.awt.Color(242, 242, 242));
        loginLink.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        loginLink.setForeground(new java.awt.Color(255, 102, 0));
        loginLink.setText("¿Ya tienes tienes cuenta? Ingresa aqui.");
        loginLink.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        loginLink.setBorderPainted(false);
        loginLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginLinkActionPerformed(evt);
            }
        });

        imgBlack1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout imgBlack1Layout = new javax.swing.GroupLayout(imgBlack1);
        imgBlack1.setLayout(imgBlack1Layout);
        imgBlack1Layout.setHorizontalGroup(
            imgBlack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        imgBlack1Layout.setVerticalGroup(
            imgBlack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 63, 98));
        jLabel6.setText("NOMBRE DE USUARIO");

        txtNickName.setBackground(new java.awt.Color(242, 242, 242));
        txtNickName.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtNickName.setForeground(new java.awt.Color(51, 51, 51));
        txtNickName.setBorder(null);
        txtNickName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNickNameActionPerformed(evt);
            }
        });

        titlePassword.setEditable(false);
        titlePassword.setBackground(new java.awt.Color(242, 242, 242));
        titlePassword.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        titlePassword.setForeground(new java.awt.Color(153, 153, 153));
        titlePassword.setText("Ingrese su contraseña");
        titlePassword.setBorder(null);
        titlePassword.setFocusable(false);
        titlePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titlePasswordActionPerformed(evt);
            }
        });

        titleUser.setEditable(false);
        titleUser.setBackground(new java.awt.Color(242, 242, 242));
        titleUser.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        titleUser.setForeground(new java.awt.Color(153, 153, 153));
        titleUser.setText("Ingrese su correo electronico");
        titleUser.setBorder(null);
        titleUser.setFocusable(false);

        titleNickname.setEditable(false);
        titleNickname.setBackground(new java.awt.Color(242, 242, 242));
        titleNickname.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        titleNickname.setForeground(new java.awt.Color(153, 153, 153));
        titleNickname.setText("Ingrese su nombre de usuario");
        titleNickname.setBorder(null);
        titleNickname.setFocusable(false);

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(titleUser, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmailRegister, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(titlePassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addComponent(txtPasswordRegister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(titleNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNickName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginLink)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(184, 184, 184)))
                .addComponent(imgBlack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtRegister)
                .addGap(73, 73, 73)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtEmailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titlePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtPasswordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(titleNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginLink)
                .addGap(46, 46, 46))
            .addComponent(imgBlack1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        authPanel.add(register, "register");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(authPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(authPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String email = txtEmailLogin.getText();
        String pass = new String(txtPasswordLogin.getPassword());

        if (email.equals("Ingrese su correo electrónico") || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese su correo electrónico");
            return;
        }

        if (pass.trim().isEmpty() || pass.equals("Ingrese su contraseña")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese su contraseña");
            return;
        }

        String userValidate = userController.validateUser(email, pass);

        if (userValidate.equals("Login exitoso")) {
            UserModel user = userController.getUserByEmail(email);
            if (user != null) {
                this.dispose();
                JMainDashboard jMainDashboard = new JMainDashboard(user);
                jMainDashboard.setVisible(true);
                jMainDashboard.pack();
                jMainDashboard.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener datos del usuario");
            }
        } else {
            JOptionPane.showMessageDialog(this, userValidate);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void registerLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerLinkActionPerformed
        CardLayout cardLayoutAuth =(CardLayout) authPanel.getLayout();
        cardLayoutAuth.show(authPanel, "register");

        javax.swing.SwingUtilities.invokeLater(() -> fixLayoutIssues());
    }//GEN-LAST:event_registerLinkActionPerformed

    private void txtEmailLogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailLogin2ActionPerformed
    }//GEN-LAST:event_txtEmailLogin2ActionPerformed

    private void titlePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titlePasswordActionPerformed
    }//GEN-LAST:event_titlePasswordActionPerformed

    private void txtNickNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNickNameActionPerformed
    }//GEN-LAST:event_txtNickNameActionPerformed

    private void loginLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginLinkActionPerformed

        CardLayout cardLayoutAuth =(CardLayout) authPanel.getLayout();
        cardLayoutAuth.show(authPanel, "login");

        javax.swing.SwingUtilities.invokeLater(() -> fixLayoutIssues());
    }//GEN-LAST:event_loginLinkActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String email = txtEmailRegister.getText();
        String pass = new String(txtPasswordRegister.getPassword());
        String name = txtNickName.getText();

        if (email.equals("Ingrese su correo electrónico") || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese su correo electrónico");
            return;
        }

        if (pass.trim().isEmpty() || pass.equals("Ingrese su contraseña")) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese su contraseña");
            return;
        }

        if (name.equals("Ingrese su nombre de usuario") || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese su nombre de usuario");
            return;
        }

        String resultado = userController.createUser(email, pass, name);
        JOptionPane.showMessageDialog(this, resultado);
    }//GEN-LAST:event_btnRegisterActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new JFAuth().setVisible(true));
    }

    //GEN-BEGIN:variables
    private javax.swing.JPanel authPanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel imgBlack;
    private javax.swing.JPanel imgBlack1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel login;
    private javax.swing.JButton loginLink;
    private javax.swing.JPanel register;
    private javax.swing.JButton registerLink;
    private javax.swing.JTextField titleNickname;
    private javax.swing.JTextField titlePassword;
    private javax.swing.JTextField titlePasswordLogin;
    private javax.swing.JTextField titleUser;
    private javax.swing.JTextField txtEmailLogin;
    private javax.swing.JTextField txtEmailLogin2;
    private javax.swing.JTextField txtEmailRegister;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JPasswordField txtPasswordLogin;
    private javax.swing.JPasswordField txtPasswordRegister;
    private javax.swing.JLabel txtRegister;
    //GEN-END:variables
}
