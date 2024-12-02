package agripro.dashboard.main;

import agripro.backend.models.User;
import agripro.backend.retrieve.GetUserData;
import agripro.dashboard.component.Header;
import agripro.dashboard.component.Menu;
import agripro.dashboard.event.EventMenuSelected;
import agripro.dashboard.event.EventShowPopupMenu;
import agripro.dashboard.form.ContactUs;
import agripro.dashboard.form.CreateSubsidyAdvertisement;
import agripro.dashboard.form.Form_Home;
import agripro.dashboard.form.MainForm;
import agripro.dashboard.form.MyProfile;
import agripro.dashboard.form.SubsequentApplication;
import agripro.dashboard.form.UpdateAdvert;
import agripro.dashboard.form.ViewReports;
import agripro.dashboard.swing.MenuItem;
import agripro.dashboard.swing.PopupMenu;
import agripro.dashboard.swing.icons.GoogleMaterialDesignIcons;
import agripro.dashboard.swing.icons.IconFontSwing;
import agripro.frontend.Login;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import ru.krlvm.swingacrylic.SwingAcrylic;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;

    private Animator animator;
    private String userEmail;
    private String userId;
    private String userName;
    private String userRole;
    private String farmerId;

    public Main(String email) {
        initComponents();
        this.userEmail = email;
        init();

    }

    private void init() {
        layout = new MigLayout("fill", "10[]10[100%, fill]10", "10[fill, top]10");
        bg.setLayout(layout);
        header = new Header(userName, userRole);
        main = new MainForm();

        User user = GetUserData.getUserByEmail(userEmail);
        userId = user.getUserId();
        userName = user.getName();
        userRole = user.getUserRole();

        System.out.println("Initializing user: " + userName + ", Role: " + userRole);

        if ("Farmer".equals(userRole)) {
            farmerId = user.getFarmerId();
        } else {
            System.out.println("User role is not Farmer. Redirecting to Home.");
            main.showForm(new Form_Home(userRole, userEmail));
        }

        menu = new Menu(userRole);
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        main.showForm(new Form_Home(userRole, userEmail));
                    } else if (subMenuIndex == 1) {
                        main.showForm(new MyProfile(userEmail));
                    }
                }

                switch (userRole) {
                    case "Farmer" -> {
                        switch (menuIndex) {
                            case 1 -> {
                                if (subMenuIndex == 0) {
                                    main.showForm(new SubsequentApplication(farmerId));
                                }
                            }
                            case 2 -> {

                                // View my subsidies
                                main.showForm(new ViewReports(userEmail, userRole, "My Subsidies"));

                            }

                            case 3 -> {
                                //contact us
                                 main.showForm(new ContactUs());
                            }
                            case 4 -> {
                                //about developers
                            }
                            default -> {
                            }
                        }
                    }
                    case "Serial Board Officer" -> {
                        switch (menuIndex) {
                            case 1 -> {
                                if (subMenuIndex == 0) {
                                    main.showForm(new ViewReports(userEmail, userRole, "Our Applicants"));
                                }
                            }
                            case 2 -> {
                                if (subMenuIndex == 0) {
                                    // View all farmers
                                    //main.showForm(new ViewReports(userEmail, userRole, "Our Registered Farmers"));
                                }
                            }
                            case 3 -> {
                                //contact us
                                 main.showForm(new ContactUs());
                            }
                            case 4 -> {
                                //about developers
                            }
                            default -> {
                            }
                        }
                    }
                    case "Chief Agricultural Officer" -> {
                        switch (menuIndex) {
                            case 1 -> {
                                switch (subMenuIndex) {
                                    case 0 -> // Create new adverts
                                        main.showForm(new CreateSubsidyAdvertisement());
                                    case 1 -> // Update advert
                                        main.showForm(new UpdateAdvert());
                                    case 2 -> {
                                        // Disburse
                                        //main.showForm(new Disburse())
                                    }
                                    default -> {
                                    }
                                }
                            }
                            
                            case 2 -> {
                                switch (subMenuIndex) {
                                    case 0 -> // Registered Farmers
                                        main.showForm(new ViewReports(userEmail, userRole, "Registered Farmers"));
                                    case 1 -> // View Adverts
                                        main.showForm(new ViewReports(userEmail, userRole, "Adverts"));
                                    case 2 -> // Approved Applications
                                        main.showForm(new ViewReports(userEmail, userRole, "Approved"));
                                    case 3 -> // Declined Applications
                                        main.showForm(new ViewReports(userEmail, userRole, "Declined"));
                                    case 4 -> // Disbursements
                                        main.showForm(new ViewReports(userEmail, userRole, "Disbursements"));
                                    case 5 -> {
                                    }
                                    default -> {
                                    }
                                }
                                //view Reports

                            }
                            case 3 -> {
                                //contact us
                                 main.showForm(new ContactUs());
                            }
                            default -> {
                            }
                        }
                    }
                    case "Agricultural Minister(CS)" -> {
                        switch (menuIndex) {
                            case 1 -> {
                                if (subMenuIndex == 0) {
                                    // User management
                                    //main.showForm(new UserManagement());
                                } else if (subMenuIndex == 1) {
                                    // Policy management
                                    //main.showForm(new PolicyManagement());
                                }
                            }
                            case 2 -> {
                                switch (subMenuIndex) {
                                    case 0 -> // Registered Farmers
                                        main.showForm(new ViewReports(userEmail, userRole, "Registered Farmers"));
                                    case 1 -> // View Adverts
                                        main.showForm(new ViewReports(userEmail, userRole, "Adverts"));
                                    case 2 -> // Approved Applications
                                        main.showForm(new ViewReports(userEmail, userRole, "Approved"));
                                    case 3 -> // Declined Applications
                                        main.showForm(new ViewReports(userEmail, userRole, "Declined"));
                                    case 4 -> // Disbursements
                                        main.showForm(new ViewReports(userEmail, userRole, "Disbursements"));
                                    case 5 -> {
                                    }
                                    default -> {
                                    }
                                }
                            }
                            case 3 -> {
                                //contact us
                                main.showForm(new ContactUs());
                            }
                            case 4 -> {
                                //about developers
                            }
                            default -> {
                            }
                        }
                    }
                    default -> {
                    }
                }

            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 62;
                int y = Main.this.getY() + com.getY() + 95;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 62 + (170 * (1f - fraction));
                } else {
                    width = 62 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        header.addLogoutEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Close the current dashboard
                dispose();

                //Prepare and display the login page
                SwingAcrylic.prepareSwing();
                Login LoginFrame = new Login();
                LoginFrame.setVisible(true);
                LoginFrame.setLocationRelativeTo(null);
                SwingAcrylic.processFrame(LoginFrame);

            }
        });
        //  Start with this form
        main.showForm(new Form_Home(userRole, userEmail));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new agripro.dashboard.swing.PanelTransparent();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setBackground(new java.awt.Color(0, 102, 102));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 783));

        bg.setBackground(new java.awt.Color(0, 102, 102));
        bg.setPreferredSize(new java.awt.Dimension(1366, 750));
        bg.setTransparent(0.5F);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private agripro.dashboard.swing.PanelTransparent bg;
    // End of variables declaration//GEN-END:variables
}
