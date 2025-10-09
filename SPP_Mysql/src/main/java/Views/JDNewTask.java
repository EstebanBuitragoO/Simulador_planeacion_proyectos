package Views;

import Models.ProjectModel;
import Models.TaskModel;
import Models.UserModel;
import Controllers.UserController;
import Controllers.TaskController;
import java.util.List;

public class JDNewTask extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JDNewTask.class.getName());
    private boolean confirmed = false;
    private ProjectModel project;
    private TaskModel taskToEdit = null;
    private boolean isEditMode = false;
    private UserController userController;
    private TaskController taskController;

    public JDNewTask(java.awt.Frame parent, boolean modal, ProjectModel project) {
        super(parent, modal);
        this.project = project;
        this.userController = new UserController();
        this.taskController = new TaskController();
        initComponents();
        setLocationRelativeTo(parent);
        loadUsers();
        setupDefaults();
    }

    public JDNewTask(java.awt.Frame parent, boolean modal, ProjectModel project, TaskModel task) {
        super(parent, modal);
        this.project = project;
        this.taskToEdit = task;
        this.isEditMode = true;
        this.userController = new UserController();
        this.taskController = new TaskController();
        initComponents();
        setLocationRelativeTo(parent);
        loadUsers();
        loadTaskData();
    }

    private void loadUsers() {
        List<UserModel> users = userController.getAllUsers();
        cmbUser.removeAllItems();
        cmbUser.addItem("Sin asignar");

        for (UserModel user : users) {
            cmbUser.addItem(user.getName());
        }
    }

    private void setupDefaults() {
        txtTaskName.setText("");
        cmbUser.setSelectedIndex(0);
        spnDuration.setValue(1);
        spnStartDate.setValue(new java.util.Date());
        spnPlannedEndDate.setValue(new java.util.Date());
    }

    private void loadTaskData() {
        if (taskToEdit != null) {
            setTitle("Editar Tarea");
            btnCreate.setText("Guardar");

            txtTaskName.setText(taskToEdit.getName());
            spnDuration.setValue(taskToEdit.getDurationDays() != null ? taskToEdit.getDurationDays() : 1);

            if (taskToEdit.getStartDate() != null) {
                spnStartDate.setValue(taskToEdit.getStartDate());
            }

            if (taskToEdit.getPlannedEndDate() != null) {
                spnPlannedEndDate.setValue(taskToEdit.getPlannedEndDate());
            }

            if (taskToEdit.getAssignedUser() != null) {
                cmbUser.setSelectedItem(taskToEdit.getAssignedUser().getName());
            } else {
                cmbUser.setSelectedIndex(0);
            }
        }
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public TaskModel getTask() {
        return taskToEdit;
    }

    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTaskName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbUser = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        spnDuration = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spnStartDate = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spnPlannedEndDate = new javax.swing.JSpinner();
        btnCreate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Tarea");
        setBackground(new java.awt.Color(255, 255, 255));
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(450, 500));

        jLabel1.setBackground(new java.awt.Color(30, 63, 98));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setForeground(new java.awt.Color(30, 63, 98));
        jLabel1.setText("Nombre de la Tarea");

        txtTaskName.setText("jTextField1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setForeground(new java.awt.Color(30, 63, 98));
        jLabel2.setText("Asignar a Usuario");

        cmbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setForeground(new java.awt.Color(30, 63, 98));
        jLabel3.setText("Duracion (dias)");

        spnDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, 365, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setForeground(new java.awt.Color(30, 63, 98));
        jLabel4.setText("Fecha Inicio");

        spnStartDate.setModel(new javax.swing.SpinnerDateModel());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setForeground(new java.awt.Color(30, 63, 98));
        jLabel5.setText("Fecha Fin");

        spnPlannedEndDate.setModel(new javax.swing.SpinnerDateModel());

        btnCreate.setBackground(new java.awt.Color(255, 101, 0));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Crear");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(30, 63, 98));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaskName)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spnStartDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addComponent(spnDuration, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnPlannedEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPlannedEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnCancel))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String taskName = txtTaskName.getText().trim();

        if (taskName.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Por favor ingrese un nombre para la tarea",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Integer duration = (Integer) spnDuration.getValue();
            java.util.Date startDate = (java.util.Date) spnStartDate.getValue();
            java.util.Date plannedEndDate = (java.util.Date) spnPlannedEndDate.getValue();

            UserModel selectedUser = null;
            String selectedUserName = (String) cmbUser.getSelectedItem();
            if (selectedUserName != null && !selectedUserName.equals("Sin asignar")) {
                List<UserModel> users = userController.getAllUsers();
                for (UserModel user : users) {
                    if (user.getName().equals(selectedUserName)) {
                        selectedUser = user;
                        break;
                    }
                }
            }

            if (isEditMode && taskToEdit != null) {
                taskToEdit.setName(taskName);
                taskToEdit.setDurationDays(duration);
                taskToEdit.setStartDate(startDate);
                taskToEdit.setPlannedEndDate(plannedEndDate);
                taskToEdit.setAssignedUser(selectedUser);

                String result = taskController.updateTask(taskToEdit);
                javax.swing.JOptionPane.showMessageDialog(this, result, "Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                String result = taskController.createTask(project.getId(), selectedUser, taskName, duration, startDate, null, plannedEndDate);
                javax.swing.JOptionPane.showMessageDialog(this, result, "Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }

            confirmed = true;
            dispose();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Error al procesar la tarea: " + e.getMessage(),
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmed = false;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDNewTask dialog = new JDNewTask(new javax.swing.JFrame(), true, new ProjectModel());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    //GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner spnDuration;
    private javax.swing.JSpinner spnPlannedEndDate;
    private javax.swing.JSpinner spnStartDate;
    private javax.swing.JTextField txtTaskName;
    //GEN-END:variables
}
