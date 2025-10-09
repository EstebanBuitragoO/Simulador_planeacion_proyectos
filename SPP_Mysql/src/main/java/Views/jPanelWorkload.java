package Views;

public class jPanelWorkload extends javax.swing.JPanel {

    public jPanelWorkload() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    //GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblProjectName = new javax.swing.JLabel();
        scrWorkload = new javax.swing.JScrollPane();
        jPanelContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHeader.setPreferredSize(new java.awt.Dimension(0, 80));
        jPanelHeader.setLayout(null);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitle.setForeground(new java.awt.Color(30, 63, 98));
        lblTitle.setText("Diagrama de Cargas");
        jPanelHeader.add(lblTitle);
        lblTitle.setBounds(10, 10, 300, 40);

        lblProjectName.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblProjectName.setForeground(new java.awt.Color(100, 100, 100));
        jPanelHeader.add(lblProjectName);
        lblProjectName.setBounds(330, 25, 400, 30);

        add(jPanelHeader, java.awt.BorderLayout.PAGE_START);

        scrWorkload.setBorder(null);
        scrWorkload.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContent.setLayout(new javax.swing.BoxLayout(jPanelContent, javax.swing.BoxLayout.Y_AXIS));
        scrWorkload.setViewportView(jPanelContent);

        add(scrWorkload, java.awt.BorderLayout.CENTER);
    }//GEN-END:initComponents


    //GEN-BEGIN:variables
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrWorkload;
    //GEN-END:variables
}
