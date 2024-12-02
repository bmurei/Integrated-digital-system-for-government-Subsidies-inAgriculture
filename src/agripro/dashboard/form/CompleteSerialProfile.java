/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package agripro.dashboard.form;

import agripro.backend.insert.InsertIntoDB;
import agripro.backend.models.User;
import agripro.backend.retrieve.GetUserData;
import agripro.frontend.SetPassword;

/**
 *
 * @author angera
 */
public class CompleteSerialProfile extends javax.swing.JFrame {

    private String email;
    private String userId;
    private String username;

    
    
    
    
    public CompleteSerialProfile(String useremail) {
        this.email = useremail;
        initComponents();
        initUserData();
    }

    private void initUserData() {

        User user = GetUserData.getUserByEmail(email);

        userId = user.getUserId();

        usernameTxt.setText("NAME: " + user.getName());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new agripro.dashboard.swing.PanelTransparent();
        left = new agripro.dashboard.swing.PanelTransparent();
        usernameTxt = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        basicInfoNotation = new javax.swing.JLabel();
        addressNotation = new javax.swing.JLabel();
        txtSerialBoardLocation = new javax.swing.JTextField();
        idNoTxt = new javax.swing.JTextField();
        txtSerialBoardName = new javax.swing.JComboBox<>();
        submitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Container.setBackground(new java.awt.Color(0, 102, 102));
        Container.setFont(new java.awt.Font("Noto Sans ExtraCondensed", 1, 24)); // NOI18N
        Container.setPreferredSize(new java.awt.Dimension(700, 650));
        Container.setTransparent(0.5F);

        left.setBackground(new java.awt.Color(0, 102, 102));
        left.setToolTipText("");
        left.setFocusCycleRoot(true);
        left.setPreferredSize(new java.awt.Dimension(550, 500));
        left.setTransparent(0.3F);

        usernameTxt.setText("NAME: ");
        usernameTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        idLabel.setText("ID Number");

        addressLabel.setText("Serial Board Name");

        jLabel5.setText("Serial Board Location");

        basicInfoNotation.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        basicInfoNotation.setText("Basic Information");

        addressNotation.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        addressNotation.setText("Serial Board Information");

        txtSerialBoardLocation.setBackground(new java.awt.Color(0, 102, 102));
        txtSerialBoardLocation.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        idNoTxt.setBackground(new java.awt.Color(0, 102, 102));

        txtSerialBoardName.setBackground(new java.awt.Color(0, 102, 102));
        txtSerialBoardName.setEditable(true);
        txtSerialBoardName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moi’s Bridge Silos", "Kisumu Branch", "Ntimaru Depot", "Homa Bay Depot", "Muhoroni Depot", "Kendu Bay Depot", "Awendo Depot", "Nyansiango Depot", "Bondo Depot", "Chavakali Depot", "Lodwar Depot", "Turbo Depot", "Kipkaren River Depot", "Mokowe Depot", "Hola Depot", "Kilifi Depot", "Kwale Depot", "Changamwe Depot", "Lunga Lunga (Nairobi) Depot", "Kithimani Depot", "Emali Depot", "Kabarnet Depot", "Marigat Depot", "Ol Kalou Depot", "Marsabit Depot", "Mandera Depot", "Garissa Depot" }));

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSerialBoardLocation)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basicInfoNotation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idNoTxt)
                    .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressNotation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerialBoardName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(107, 107, 107))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(basicInfoNotation, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addressNotation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSerialBoardName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSerialBoardLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        submitBtn.setBackground(new java.awt.Color(51, 102, 255));
        submitBtn.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Save");
        submitBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMPLETE PROFILE");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(497, 497, 497)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:

        var idno = idNoTxt.getText();
        var name = (String) txtSerialBoardName.getSelectedItem();
        var location = txtSerialBoardLocation.getText();

        if (InsertIntoDB.createSupplierProfile(userId, idno, name, location)) {
            SetPassword PasswordFrame = new SetPassword(email);
            PasswordFrame.setVisible(true);
            PasswordFrame.pack();
            PasswordFrame.setLocationRelativeTo(null);
            this.dispose();
        }

    }//GEN-LAST:event_submitBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private agripro.dashboard.swing.PanelTransparent Container;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressNotation;
    private javax.swing.JLabel basicInfoNotation;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idNoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private agripro.dashboard.swing.PanelTransparent left;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField txtSerialBoardLocation;
    private javax.swing.JComboBox<String> txtSerialBoardName;
    private javax.swing.JLabel usernameTxt;
    // End of variables declaration//GEN-END:variables
}
