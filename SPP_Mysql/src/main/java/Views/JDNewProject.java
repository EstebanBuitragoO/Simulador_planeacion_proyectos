package Views;

import Models.ProjectModel;
import java.sql.Date;

public class JDNewProject extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JDNewProject.class.getName());
    private boolean confirmed = false;
    private ProjectModel projectToEdit = null;
    private boolean isEditMode = false;

    public JDNewProject(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        getRootPane().setDefaultButton(btnCreate);
    }

    public JDNewProject(java.awt.Frame parent, boolean modal, ProjectModel project) {
        super(parent, modal);
        this.projectToEdit = project;
        this.isEditMode = true;
        initComponents();
        setLocationRelativeTo(parent);
        getRootPane().setDefaultButton(btnCreate);
        loadProjectData();
    }

    private void loadProjectData() {
        if (projectToEdit != null) {
            setTitle("Editar Proyecto");
            btnCreate.setText("Guardar");

            txtName.setText(projectToEdit.getName());
            txtDescription.setText(projectToEdit.getDescription());

            if (projectToEdit.getStartDate() != null) {
                spnStartDate.setValue(projectToEdit.getStartDate());
            }

            if (projectToEdit.getTargetEndDate() != null) {
                spnEndDate.setValue(projectToEdit.getTargetEndDate());
            }
        }
    }

    public boolean isEditMode() {
        return isEditMode;
    }

    public ProjectModel getProjectToEdit() {
        return projectToEdit;
    }

    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        spnStartDate = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spnEndDate = new javax.swing.JSpinner();
        btnCancel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Proyecto");
        setBackground(new java.awt.Color(245, 245, 245));
        setForeground(new java.awt.Color(245, 245, 245));
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setForeground(new java.awt.Color(30, 63, 98));
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 63, 98));
        jLabel2.setText("Descripcion");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 63, 98));
        jLabel3.setText("Fecha de Inicio");

        spnStartDate.setModel(new javax.swing.SpinnerDateModel());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 63, 98));
        jLabel4.setText("Fecha de Finalizacion");

        spnEndDate.setModel(new javax.swing.SpinnerDateModel());

        btnCancel.setBackground(new java.awt.Color(30, 63, 98));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(255, 101, 0));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Crear");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(spnEndDate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spnStartDate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCreate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnCreate))
                .addGap(16, 16, 16))
        );

        pack();
    }//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String nameProject = txtName.getText().trim();
        String description=txtDescription.getText().trim();
        if (nameProject.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingresa un nombre para el proyecto.", 
                    "Validación de creacion", javax.swing.JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return;
        }
        if (description.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingresa una descripcion  para el proyecto.", 
                    "Validación de creacion", javax.swing.JOptionPane.WARNING_MESSAGE);
            txtName.requestFocus();
            return;
        }
        
        confirmed = true;
        dispose();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
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
                JDNewProject dialog = new JDNewProject(new javax.swing.JFrame(), true);
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
    
    public boolean isConfirmed() { 
        return confirmed; 
    }
    public String getProjectName() { 
        return txtName.getText().trim(); 
    }
    public String getDescription() { 
        return txtDescription.getText().trim(); 
    }
    
    public Date getStartDate(){        
       String s = new java.text.SimpleDateFormat("yyyy-MM-dd")
              .format((java.util.Date) spnStartDate.getValue());
        java.sql.Date sqlDate = java.sql.Date.valueOf(s);
        return sqlDate;
    }
    
    public Date getEndDate(){
        String s = new java.text.SimpleDateFormat("yyyy-MM-dd")
              .format((java.util.Date) spnEndDate.getValue());
        java.sql.Date sqlDate = java.sql.Date.valueOf(s);
        return sqlDate;
    }

    //GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnEndDate;
    private javax.swing.JSpinner spnStartDate;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    //GEN-END:variables
}
