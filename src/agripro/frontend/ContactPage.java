
package agripro.frontend;

import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class ContactPage extends javax.swing.JFrame {

    /**
     * Creates new form ContactPage
     */
    private String userEmail;
    
    public ContactPage(String email) {
        this.userEmail = email;
        initComponents();
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Check if the window is maximized
                if ((getExtendedState() & MAXIMIZED_BOTH) == MAXIMIZED_BOTH) {
                    // Set background color of JFrame when maximized
                    getContentPane().setBackground(new Color(153,153,153));
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
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        socialmedea = new javax.swing.JPanel();
        facebook = new javax.swing.JLabel();
        tweeter = new javax.swing.JLabel();
        linkedIn = new javax.swing.JLabel();
        ig = new javax.swing.JLabel();
        youtube = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        emailAcc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contact Support");
        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(900, 600));

        Container.setBackground(new java.awt.Color(255, 255, 255));
        Container.setPreferredSize(new java.awt.Dimension(900, 600));

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(450, 600));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Let's Get in touch");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/email-symbol-icon.png"))); // NOI18N
        jLabel2.setText("info@agriprodevs.co.ke");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/call-now-icon.png"))); // NOI18N
        jLabel3.setText("(+254) 797 630228");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/earth-icon.png"))); // NOI18N
        jLabel4.setText("agriprodevs.co.ke");

        socialmedea.setBackground(new java.awt.Color(255, 255, 255));

        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/facebook-round-color-icon.png"))); // NOI18N

        tweeter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/x-social-media-logo-icon.png"))); // NOI18N

        linkedIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/linkedin-app-icon.png"))); // NOI18N

        ig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/ig-instagram-icon.png"))); // NOI18N

        youtube.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/youtube-color-icon.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Connect with Us:");

        javax.swing.GroupLayout socialmedeaLayout = new javax.swing.GroupLayout(socialmedea);
        socialmedea.setLayout(socialmedeaLayout);
        socialmedeaLayout.setHorizontalGroup(
            socialmedeaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(socialmedeaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(socialmedeaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(socialmedeaLayout.createSequentialGroup()
                        .addComponent(facebook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tweeter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(linkedIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(youtube))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        socialmedeaLayout.setVerticalGroup(
            socialmedeaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, socialmedeaLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(socialmedeaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(youtube)
                    .addComponent(ig)
                    .addComponent(linkedIn)
                    .addComponent(tweeter)
                    .addComponent(facebook))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/whatsapp-color-icon.png"))); // NOI18N
        jLabel6.setText("+254710398690");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addGap(0, 82, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(socialmedea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(logo)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(45, 45, 45)
                .addComponent(socialmedea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        Right.setBackground(new java.awt.Color(0, 51, 51));
        Right.setForeground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(450, 600));

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Cantarell", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact us");

        jLabel8.setBackground(new java.awt.Color(0, 51, 51));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setLabelFor(fullName);
        jLabel8.setText("Full Name");

        jLabel9.setBackground(new java.awt.Color(0, 51, 51));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setLabelFor(emailAcc);
        jLabel9.setText("Email");

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setLabelFor(message);
        jLabel10.setText("Message");

        fullName.setBackground(new java.awt.Color(0, 51, 51));
        fullName.setForeground(new java.awt.Color(255, 255, 255));
        fullName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        fullName.setCaretColor(new java.awt.Color(255, 255, 255));
        fullName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        emailAcc.setBackground(new java.awt.Color(0, 51, 51));
        emailAcc.setForeground(new java.awt.Color(255, 255, 255));
        emailAcc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        emailAcc.setCaretColor(new java.awt.Color(255, 255, 255));

        message.setBackground(new java.awt.Color(0, 51, 51));
        message.setColumns(20);
        message.setForeground(new java.awt.Color(255, 255, 255));
        message.setLineWrap(true);
        message.setRows(5);
        message.setWrapStyleWord(true);
        message.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        message.setCaretColor(new java.awt.Color(255, 255, 255));
        message.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(message);

        jButton1.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Send");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(149, 149, 149))
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel8)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)
                        .addComponent(fullName)
                        .addComponent(emailAcc, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JTextField emailAcc;
    private javax.swing.JLabel facebook;
    private javax.swing.JTextField fullName;
    private javax.swing.JLabel ig;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel linkedIn;
    private javax.swing.JLabel logo;
    private javax.swing.JTextArea message;
    private javax.swing.JPanel socialmedea;
    private javax.swing.JLabel tweeter;
    private javax.swing.JLabel youtube;
    // End of variables declaration//GEN-END:variables
}
