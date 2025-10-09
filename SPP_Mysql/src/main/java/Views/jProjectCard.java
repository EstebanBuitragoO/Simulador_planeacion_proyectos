package Views;

import Models.ProjectModel;
import Models.TaskModel;
import Controllers.TaskController;
import Controllers.ProjectController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.border.AbstractBorder;
import java.awt.Insets;
import java.awt.Component;
import java.util.List;

public class jProjectCard extends javax.swing.JPanel {

    private ProjectModel project;
    private TaskController taskController;
    private ProjectController projectController;

    private static class RoundedBorder extends AbstractBorder {
        private final Color borderColor;
        private final int radius;
        private final int thickness;

        public RoundedBorder(Color borderColor, int radius, int thickness) {
            this.borderColor = borderColor;
            this.radius = radius;
            this.thickness = thickness;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(borderColor);
            g2d.setStroke(new java.awt.BasicStroke(thickness));
            g2d.drawRoundRect(x + thickness/2, y + thickness/2,
                            width - thickness, height - thickness, radius, radius);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness + 2, thickness + 2, thickness + 2, thickness + 2);
        }
    }

    public jProjectCard() {
        taskController = new TaskController();
        projectController = new ProjectController();
        initComponents();
        setupCardAppearance();
    }

    public jProjectCard(ProjectModel project) {
        this.project = project;
        taskController = new TaskController();
        projectController = new ProjectController();
        initComponents();
        setupCardAppearance();
        setupProjectData();
    }

    public jProjectCard(ProjectModel project, boolean compactMode) {
        this.project = project;
        taskController = new TaskController();
        projectController = new ProjectController();
        initComponents();
        setupCardAppearance();
        setupProjectData();

        if (compactMode) {
            lblDetail.setVisible(false);
        }
    }

    private void setupCardAppearance() {
        this.setBorder(new RoundedBorder(new Color(220, 220, 220), 12, 1));

        this.setBackground(Color.WHITE);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Pintar fondo redondeado
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);

        // Agregar una sombra sutil (opcional)
        g2d.setColor(new Color(0, 0, 0, 10));
        g2d.fillRoundRect(2, 2, getWidth(), getHeight(), 12, 12);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 12, 12);

        g2d.dispose();
        super.paintComponent(g);
    }

    private void setupProjectData() {
        if (project == null) return;

        List<TaskModel> tasks = taskController.getTasksByProject(project.getId());

        int progress = taskController.calculateProgress(tasks);
        ProjectModel.Risk risk = projectController.calculateRisk(tasks);
        String timeRemaining = taskController.calculateTimeRemaining(tasks);

        lblTitle.setText(project.getName());
        lblRisk.setText(risk.getDisplayName());
        lblRisk.setForeground(risk.getDisplayColor());
        progressBar.setValue(progress);
        lblDetail.setText(String.format("Progreso: %d%% • Tiempo restante: %s", progress, timeRemaining));
    }

    public void setProject(ProjectModel project) {
        this.project = project;
        setupProjectData();
    }

    public ProjectModel getProject() {
        return project;
    }

    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblRisk = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        lblDetail = new javax.swing.JLabel();
        btnOpen = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setForeground(new java.awt.Color(204, 41, 55));

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(30, 63, 98));
        lblTitle.setText("Proyecto");

        lblRisk.setForeground(new java.awt.Color(153, 153, 153));
        lblRisk.setText("Riesgo");

        lblDetail.setForeground(new java.awt.Color(153, 153, 153));
        lblDetail.setText("Detalle");

        btnOpen.setBackground(new java.awt.Color(255, 101, 0));
        btnOpen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOpen.setForeground(new java.awt.Color(255, 255, 255));
        btnOpen.setText("Abrir");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(30, 63, 98));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRisk))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit))
                    .addComponent(lblDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(lblRisk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        if (project != null) {
            java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
            if (window instanceof Views.JMainDashboard) {
                Views.JMainDashboard dashboard = (Views.JMainDashboard) window;
                dashboard.openProjectKanban(project);
            }
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (project != null) {
            java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
            if (window instanceof javax.swing.JFrame) {
                JDNewProject editDialog = new JDNewProject((javax.swing.JFrame) window, true, project);
                editDialog.setVisible(true);

                if (editDialog.isConfirmed()) {
                    Controllers.ProjectController projectController = new Controllers.ProjectController();
                    try {
                        String result = projectController.updateProject(
                            project.getId(),
                            editDialog.getProjectName(),
                            editDialog.getDescription(),
                            editDialog.getStartDate(),
                            editDialog.getEndDate()
                        );

                        if (result.contains("exitosamente")) {
                            if (window instanceof Views.JMainDashboard) {
                                Views.JMainDashboard dashboard = (Views.JMainDashboard) window;
                                dashboard.refreshProjects();
                            }
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(this,
                                "Error al actualizar proyecto: " + result,
                                "Error",
                                javax.swing.JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this,
                            "Error al actualizar proyecto: " + e.getMessage(),
                            "Error",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed


    //GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOpen;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblRisk;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JProgressBar progressBar;
    //GEN-END:variables
}
