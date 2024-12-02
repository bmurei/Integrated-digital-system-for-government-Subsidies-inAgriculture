package agripro.frontend;

import agripro.backend.insert.InsertIntoDB;
import agripro.dashboard.form.CompleteProfile;
import agripro.dashboard.form.CompleteSerialProfile;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author angera
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    private String origin;

    public SignUp(String origin) {

        this.origin = origin;

        initComponents();
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Check if the window is maximized
                if ((getExtendedState() & MAXIMIZED_BOTH) == MAXIMIZED_BOTH) {
                    // Set background color of JFrame when maximized
                    getContentPane().setBackground(new Color(153, 153, 153));
                    // Center jPanel1
                    CreateAccount.setLocation((getWidth() - CreateAccount.getWidth()) / 2,
                            (getHeight() - CreateAccount.getHeight()) / 2);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        copyrights = new javax.swing.JLabel();
        CreateAccount = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        appName = new javax.swing.JLabel();
        appDescription = new javax.swing.JLabel();
        welcomeMessage = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userEmail = new javax.swing.JTextField();
        telephone = new javax.swing.JTextField();
        SignUpBtn = new javax.swing.JButton();
        labelLink = new javax.swing.JLabel();
        LinkToSignInBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        roleTxt = new javax.swing.JComboBox<>();

        copyrights.setBackground(new java.awt.Color(0, 102, 102));
        copyrights.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        copyrights.setForeground(new java.awt.Color(255, 255, 255));
        copyrights.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrights.setText("<html>\n<p>copyright &copy;  <span style=\"font-weight: bold\">Brian Murei</span> 2024.  All rights reserved. </p>\n</html>");
        copyrights.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Account");
        setPreferredSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));

        CreateAccount.setBackground(new java.awt.Color(255, 255, 255));
        CreateAccount.setPreferredSize(new java.awt.Dimension(800, 500));

        Left.setBackground(new java.awt.Color(0, 51, 51));
        Left.setForeground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        logo.setBackground(new java.awt.Color(0, 102, 102));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/logo.png"))); // NOI18N

        appName.setBackground(new java.awt.Color(0, 102, 102));
        appName.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        appName.setForeground(new java.awt.Color(255, 255, 255));
        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setText("AgriPro");

        appDescription.setBackground(new java.awt.Color(0, 102, 102));
        appDescription.setFont(new java.awt.Font("Cantarell", 2, 18)); // NOI18N
        appDescription.setForeground(new java.awt.Color(255, 255, 255));
        appDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appDescription.setText("Every Farmer's Best Choice");
        appDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        welcomeMessage.setBackground(new java.awt.Color(0, 102, 102));
        welcomeMessage.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        welcomeMessage.setForeground(new java.awt.Color(255, 255, 255));
        welcomeMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeMessage.setText("Hey Buddy!, Welcome...");
        welcomeMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(appDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                        .addComponent(welcomeMessage)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                        .addComponent(appName)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(143, 143, 143))))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(appName)
                .addGap(12, 12, 12)
                .addComponent(appDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(welcomeMessage)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREATE ACCOUNT");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel2.setLabelFor(userName);
        jLabel2.setText("Full Name");

        userName.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel3.setLabelFor(userEmail);
        jLabel3.setText("Email");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel4.setLabelFor(telephone);
        jLabel4.setText("Telephone");

        userEmail.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        telephone.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        SignUpBtn.setBackground(new java.awt.Color(0, 102, 102));
        SignUpBtn.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        SignUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        SignUpBtn.setText("Create Account");
        SignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBtnActionPerformed(evt);
            }
        });

        labelLink.setBackground(new java.awt.Color(255, 255, 255));
        labelLink.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        labelLink.setText("Already have an account");

        LinkToSignInBtn.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        LinkToSignInBtn.setForeground(new java.awt.Color(255, 51, 0));
        LinkToSignInBtn.setText("Sign in to your account");
        LinkToSignInBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LinkToSignInBtn.setBorderPainted(false);
        LinkToSignInBtn.setContentAreaFilled(false);
        LinkToSignInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinkToSignInBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Select Role");

        roleTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Farmer", "Serial Board Officer", "Chief Agricultural Officer", "Agricultural Minister(CS)" }));

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(labelLink)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LinkToSignInBtn))
                    .addComponent(jLabel1)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(userEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(telephone, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(SignUpBtn)
                            .addComponent(jLabel5)
                            .addComponent(roleTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SignUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLink, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LinkToSignInBtn))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CreateAccountLayout = new javax.swing.GroupLayout(CreateAccount);
        CreateAccount.setLayout(CreateAccountLayout);
        CreateAccountLayout.setHorizontalGroup(
            CreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateAccountLayout.createSequentialGroup()
                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CreateAccountLayout.setVerticalGroup(
            CreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateAccountLayout.createSequentialGroup()
                .addGroup(CreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBtnActionPerformed

        var name = userName.getText().toUpperCase();
        var email = userEmail.getText().toLowerCase();
        var phone = telephone.getText();
        var role = (String) roleTxt.getSelectedItem();

        InsertIntoDB.insertUser(name, email, phone, role);

        if (role.equals("Farmer")) {
            CompleteProfile profile = new CompleteProfile(email);
            profile.setVisible(true);
            profile.pack();
            profile.setLocationRelativeTo(null);
            this.dispose();
        }else if (role.equals("Serial Board Officer")) {
            CompleteSerialProfile profile = new CompleteSerialProfile(email);
            profile.setVisible(true);
            profile.pack();
            profile.setLocationRelativeTo(null);
            this.dispose();
        }else {
            SetPassword PasswordFrame = new SetPassword(email);
            PasswordFrame.setVisible(true);
            PasswordFrame.pack();
            PasswordFrame.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_SignUpBtnActionPerformed

    private void LinkToSignInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LinkToSignInBtnActionPerformed
        if ("Login".equals(origin)) {
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_LinkToSignInBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CreateAccount;
    private javax.swing.JPanel Left;
    private javax.swing.JButton LinkToSignInBtn;
    private javax.swing.JPanel Right;
    private javax.swing.JButton SignUpBtn;
    private javax.swing.JLabel appDescription;
    private javax.swing.JLabel appName;
    private javax.swing.JLabel copyrights;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelLink;
    private javax.swing.JLabel logo;
    private javax.swing.JComboBox<String> roleTxt;
    private javax.swing.JTextField telephone;
    private javax.swing.JTextField userEmail;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel welcomeMessage;
    // End of variables declaration//GEN-END:variables
}
