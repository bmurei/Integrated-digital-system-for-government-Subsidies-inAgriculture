package agripro.dashboard.component;

import agripro.dashboard.event.EventMenu;
import agripro.dashboard.event.EventMenuSelected;
import agripro.dashboard.event.EventShowPopupMenu;
import agripro.dashboard.model.ModelMenu;
import agripro.dashboard.swing.MenuAnimation;
import agripro.dashboard.swing.MenuItem;
import agripro.dashboard.swing.PanelTransparent;
import agripro.dashboard.swing.scrollbar.ScrollBarCustom;
import java.awt.Component;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends PanelTransparent {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    private String userRole;

    public Menu(String role) {
        initComponents();
        this.userRole = role;
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
        setTransparent(0.5f);
    }

    public void initMenuItem() {
    // Check for null and assign a default role if necessary
    if (userRole == null) {
        System.out.println("User role is null. Setting default role.");
        userRole = "Guest"; // or handle as needed
    } else {
        System.out.println("Current user role: " + userRole);
    }

    // Default menu items
    addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/1.png")), "Dashboard", "Home", "My Profile"));
    
    // Switch case to determine menu items based on user role
    switch (userRole) {
        case "Farmer" -> {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/2.png")), "Subsidy Application",  "Subsequent Application"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/3.png")), "My Applications"));
            }
        
        case "Serial Board Officer" -> {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/2.png")), "Subsidies", "View Applications"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/4.png")), "Farmers", "View All"));
            }
        

        
        case "Chief Agricultural Officer" -> {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/5.png")), "Applications", "Create Advert","Update Advert"));
            
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/6.png")), "Reports", "Registered Farmers","Adverts","Approved Applications","Declined Aplications","Disbursements"));
            }

        case "Agricultural Minister(CS)" -> {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/7.png")), "Administration", "User Management", "Policy Management"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/6.png")), "Reports", "Registered Farmers","Adverts","Approved Applications","Declined Aplications","Disbursements"));
            }

        default -> // Handle unrecognized role
            System.out.println("Role not recognized. Default menu items will be shown.");
    }

    // Common menu items for all users
    addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/agripro/dashboard/icon/13.png")), "Our Contacts"));
}


    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile1 = new agripro.dashboard.component.Profile();
        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 102, 102));
        setPreferredSize(new java.awt.Dimension(215, 644));
        setTransparent(0.8F);

        profile1.setPreferredSize(new java.awt.Dimension(215, 80));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setOpaque(false);
        sp.setPreferredSize(new java.awt.Dimension(215, 558));

        panel.setBackground(new java.awt.Color(0, 153, 153));
        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(215, 558));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private agripro.dashboard.component.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
