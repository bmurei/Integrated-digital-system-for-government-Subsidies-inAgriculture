package agripro.dashboard.component;

import agripro.dashboard.swing.PanelTransparent;
import java.awt.event.ActionListener;

public class Header extends PanelTransparent {
    
    private String name;
    private String role;
    public Header(String username, String userRole) {
        this.name = username;
        this.role = userRole;
        initComponents();
        init();
        setTransparent(0.5f);
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }
    public void addLogoutEvent(ActionListener event){
        exitBtn.addActionListener(event);
    }
    
    private void init(){
        lbRole.setText(role);
        lbUserName.setText(name);
        buttonBadges1.setBadges(2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new agripro.dashboard.swing.Button();
        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        exitBtn = new agripro.dashboard.swing.Button();
        buttonBadges1 = new agripro.dashboard.swing.ButtonBadges();

        setBackground(new java.awt.Color(0, 102, 102));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(450, 49));
        setTransparent(0.3F);

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/menu.png"))); // NOI18N
        cmdMenu.setEffectColor(new java.awt.Color(0, 102, 102));
        cmdMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbUserName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(33, 33, 33));
        lbUserName.setText("Brian Murei");

        lbRole.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        lbRole.setForeground(new java.awt.Color(33, 33, 33));
        lbRole.setText("Admin");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(3, 8));

        exitBtn.setText("Logout");
        exitBtn.setEffectColor(new java.awt.Color(0, 153, 153));

        buttonBadges1.setForeground(new java.awt.Color(255, 51, 51));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agripro/dashboard/icon/notification.png"))); // NOI18N
        buttonBadges1.setBadges(5);
        buttonBadges1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonBadges1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRole))
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private agripro.dashboard.swing.ButtonBadges buttonBadges1;
    private agripro.dashboard.swing.Button cmdMenu;
    private agripro.dashboard.swing.Button exitBtn;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    // End of variables declaration//GEN-END:variables
}
