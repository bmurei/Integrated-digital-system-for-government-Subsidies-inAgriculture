package agripro.frontend;

import agripro.backend.models.LoginModel;
import agripro.dashboard.main.Main;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JOptionPane;
import ru.krlvm.swingacrylic.SwingAcrylic;

/**
 *
 * @author angera
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Check if the window is maximized
                if ((getExtendedState() & MAXIMIZED_BOTH) == MAXIMIZED_BOTH) {
                    // Set background color of JFrame when maximized
                    getContentPane().setBackground(new Color(153, 153, 153));
                    // Center jPanel1
                    Container.setLocation((getWidth() - Container.getWidth()) / 2,
                            (getHeight() - Container.getHeight()) / 2);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        appName = new javax.swing.JLabel();
        appDescription = new javax.swing.JLabel();
        welcomeMessage = new javax.swing.JLabel();
        copyrights = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        LoginTitle = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        userEmail = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        userPassword = new javax.swing.JPasswordField();
        LoginBtn = new javax.swing.JButton();
        labelLink = new javax.swing.JLabel();
        LinkToSignUpBtn = new javax.swing.JButton();
        LinkToResetPasswordBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setBackground(new java.awt.Color(0, 102, 102));

        Container.setBackground(new java.awt.Color(255, 255, 255));
        Container.setPreferredSize(new java.awt.Dimension(800, 500));
        Container.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 51, 51));
        Right.setForeground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        logo.setBackground(new java.awt.Color(0, 102, 102));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        appName.setBackground(new java.awt.Color(0, 102, 102));
        appName.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        appName.setForeground(new java.awt.Color(255, 255, 255));
        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setLabelFor(Left);
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
        welcomeMessage.setText("Welcome Back Friend!");
        welcomeMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        copyrights.setBackground(new java.awt.Color(0, 102, 102));
        copyrights.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        copyrights.setForeground(new java.awt.Color(255, 255, 255));
        copyrights.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrights.setText("<html>\n<p>copyright &copy;  <span style=\"font-weight: bold\">Brian Murei</span> 2024.  All rights reserved. </p>\n</html>");
        copyrights.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(welcomeMessage)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(appDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(logo))
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(appName))))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(copyrights, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(appName)
                .addGap(18, 18, 18)
                .addComponent(appDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(welcomeMessage)
                .addGap(18, 18, 18)
                .addComponent(copyrights, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        Container.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        LoginTitle.setBackground(new java.awt.Color(255, 255, 255));
        LoginTitle.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        LoginTitle.setForeground(new java.awt.Color(0, 102, 102));
        LoginTitle.setLabelFor(Right);
        LoginTitle.setText("LOGIN");

        labelEmail.setBackground(new java.awt.Color(102, 102, 102));
        labelEmail.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelEmail.setLabelFor(userEmail);
        labelEmail.setText("Email");

        userEmail.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        userEmail.setName("userEmail"); // NOI18N

        labelPassword.setBackground(new java.awt.Color(102, 102, 102));
        labelPassword.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelPassword.setLabelFor(userPassword);
        labelPassword.setText("Password");

        userPassword.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        userPassword.setName("userPassword"); // NOI18N

        LoginBtn.setBackground(new java.awt.Color(0, 102, 102));
        LoginBtn.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        labelLink.setBackground(new java.awt.Color(255, 255, 255));
        labelLink.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        labelLink.setLabelFor(LinkToSignUpBtn);
        labelLink.setText("I dont have an account");

        LinkToSignUpBtn.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        LinkToSignUpBtn.setForeground(new java.awt.Color(255, 51, 0));
        LinkToSignUpBtn.setText("Create an account");
        LinkToSignUpBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LinkToSignUpBtn.setBorderPainted(false);
        LinkToSignUpBtn.setContentAreaFilled(false);
        LinkToSignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinkToSignUpBtnActionPerformed(evt);
            }
        });

        LinkToResetPasswordBtn.setFont(new java.awt.Font("Cantarell", 2, 14)); // NOI18N
        LinkToResetPasswordBtn.setForeground(new java.awt.Color(0, 51, 255));
        LinkToResetPasswordBtn.setText("forgot password");
        LinkToResetPasswordBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LinkToResetPasswordBtn.setBorderPainted(false);
        LinkToResetPasswordBtn.setContentAreaFilled(false);
        LinkToResetPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinkToResetPasswordBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(LoginTitle)
                .addGap(143, 143, 143))
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LinkToResetPasswordBtn)
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(userPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                        .addComponent(userEmail)
                        .addComponent(labelPassword)
                        .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addComponent(labelLink, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LinkToSignUpBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginTitle)
                .addGap(34, 34, 34)
                .addComponent(labelEmail)
                .addGap(18, 18, 18)
                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LinkToResetPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLink, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LinkToSignUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        Container.add(Left);
        Left.setBounds(400, 0, 400, 500);

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

    private void LinkToSignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LinkToSignUpBtnActionPerformed
        SignUp SignUpFrame = new SignUp("Login");
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LinkToSignUpBtnActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        var email = userEmail.getText().toLowerCase();
        var pass = new String(userPassword.getPassword()); // Get password securely

        // Authenticate the user using the LoginModel
        boolean authenticated = LoginModel.authenticateUser(email, pass);

        if (authenticated) {
            // If authenticated, open the main frame
            SwingAcrylic.prepareSwing();
            Main frame = new Main(email); // Pass email if needed

            frame.setVisible(true);
            SwingAcrylic.processFrame(frame);
            
            dispose();
            
        } else {
            // If authentication fails, show an error message
            JOptionPane.showMessageDialog(this, "Invalid email or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void LinkToResetPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LinkToResetPasswordBtnActionPerformed
        ResetPassword1 ResetPassword1Frame = new ResetPassword1();
        ResetPassword1Frame.setVisible(true);
        ResetPassword1Frame.pack();
        ResetPassword1Frame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LinkToResetPasswordBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Left;
    private javax.swing.JButton LinkToResetPasswordBtn;
    private javax.swing.JButton LinkToSignUpBtn;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel LoginTitle;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel appDescription;
    private javax.swing.JLabel appName;
    private javax.swing.JLabel copyrights;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelLink;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField userEmail;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JLabel welcomeMessage;
    // End of variables declaration//GEN-END:variables
}
