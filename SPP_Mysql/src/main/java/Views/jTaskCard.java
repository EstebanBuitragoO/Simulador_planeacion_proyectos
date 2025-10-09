package Views;

import Models.TaskModel;
import Models.ProjectModel;
import Controllers.TaskController;

public class jTaskCard extends javax.swing.JPanel {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(jTaskCard.class.getName());
    private TaskModel task;
    private ProjectModel project;
    private JMainDashboard parentDashboard;
    private TaskController taskController;

    public jTaskCard() {
        initComponents();
    }

    public jTaskCard(TaskModel task, ProjectModel project, JMainDashboard parentDashboard) {
        this.task = task;
        this.project = project;
        this.parentDashboard = parentDashboard;
        this.taskController = new TaskController();
        initComponents();
        setupTaskData();
        setupStatusComboBox();
    }

    private void setupTaskData() {
        if (task != null) {
            txtTaskName.setText(task.getName());
            txtDays.setText(task.getDurationDays() != null ? task.getDurationDays() + " días" : "Sin duración");
        }
    }

    private void setupStatusComboBox() {
        if (task != null) {
            switch (task.getStatus()) {
                case TODO:
                    cmbStatus.setSelectedIndex(0);
                    break;
                case EN_PROGRESO:
                    cmbStatus.setSelectedIndex(1);
                    break;
                case BLOQUEADO:
                    cmbStatus.setSelectedIndex(2);
                    break;
                case HECHO:
                    cmbStatus.setSelectedIndex(3);
                    break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        txtTaskName = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        txtDays = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(15, 1, 15, 1)));
        setMaximumSize(new java.awt.Dimension(32767, 110));
        setPreferredSize(new java.awt.Dimension(0, 120));

        txtTaskName.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtTaskName.setForeground(new java.awt.Color(30, 63, 98));
        txtTaskName.setText("Tarea");

        btnEditar.setBackground(new java.awt.Color(255, 101, 0));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtDays.setFont(new java.awt.Font("Segoe UI", 0, 10));
        txtDays.setText("Duracion Tarea:");

        cmbStatus.setBackground(new java.awt.Color(245, 245, 245));
        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        cmbStatus.setForeground(new java.awt.Color(30, 63, 98));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "To Do", "En Progreso", "Bloqueado", "Hecho" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTaskName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTaskName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDays)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
    }//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (task != null && project != null && parentDashboard != null) {
            java.awt.Frame frame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
            JDNewTask dialog = new JDNewTask(frame, true, project, task);
            dialog.setVisible(true);

            if (dialog.isConfirmed()) {
                parentDashboard.loadKanbanTasks(project.getId());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        if (task != null) {
            int selectedIndex = cmbStatus.getSelectedIndex();
            TaskModel.Status newStatus = null;

            switch (selectedIndex) {
                case 0:
                    newStatus = TaskModel.Status.TODO;
                    break;
                case 1:
                    newStatus = TaskModel.Status.EN_PROGRESO;
                    break;
                case 2:
                    newStatus = TaskModel.Status.BLOQUEADO;
                    break;
                case 3:
                    newStatus = TaskModel.Status.HECHO;
                    break;
            }

            if (newStatus != null && newStatus != task.getStatus()) {
                String result = taskController.updateTaskStatus(task.getId(), newStatus);

                if (result.contains("exitosamente") && parentDashboard != null && project != null) {
                    parentDashboard.loadKanbanTasks(project.getId());
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, result, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_cmbStatusActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> new jTaskCard().setVisible(true));
    }

    //GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel txtDays;
    private javax.swing.JLabel txtTaskName;
    //GEN-END:variables
}
