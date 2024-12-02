package agripro.dashboard.form;

import agripro.backend.models.SubsidyRecord;
import agripro.backend.services.SubsidyService;
import agripro.backend.models.User;
import agripro.backend.retrieve.GetUserData;
import agripro.backend.update.UpdateDB;
import agripro.dashboard.component.Card;
import agripro.dashboard.dialog.Message;
import agripro.dashboard.main.Main;
import agripro.dashboard.model.FarmerSubsidyApplication;
import agripro.dashboard.model.ModelCard;
import agripro.dashboard.swing.icons.GoogleMaterialDesignIcons;
import agripro.dashboard.swing.icons.IconFontSwing;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Form_Home extends javax.swing.JPanel {

    private String userRole;
    private String userEmail;
    private String farmerId;
    private String serialboard;
    private String supplierId;
    private SubsidyService service;
    private String serialNo;

    public Form_Home(String role, String email) {
        this.userRole = role;
        this.userEmail = email;
        this.service = new SubsidyService();
        initComponents();
        table1.fixTable(jScrollPane1);

        // Set up user details based on role
        User user = GetUserData.getUserByEmail(userEmail);
        if ("Farmer".equals(userRole)) {
            farmerId = user.getFarmerId();
        } else if ("Serial Board Officer".equals(userRole)) {
            serialboard = user.getSerialBoardName();
            supplierId = user.getSupplierId();
        }

        setOpaque(false);
        initCardData();

        initTableData();
    }

    private void initCardData() {
        try {
            if (userRole != null) {
                switch (userRole) {
                    case "Farmer" -> {
                        int advertsAvailable = service.getAdvertsCount();
                        int subsidiesReceived = service.getFarmerSubsidiesCount(farmerId);
                        int applicationsDone = service.getApplicationsCount(farmerId);

                        setCardVisibility(card1, advertsAvailable, "Adverts Available", GoogleMaterialDesignIcons.PEOPLE);
                        setCardVisibility(card2, subsidiesReceived, "Subsidies Received", GoogleMaterialDesignIcons.MONETIZATION_ON);
                        setCardVisibility(card3, applicationsDone, "Applications Done", GoogleMaterialDesignIcons.SHOPPING_BASKET);
                        setCardVisibility(card4, -1, "", null); // Hidden
                    }

                    case "Chief Agricultural Officer" -> {
                        int registeredFarmers = service.getRegisteredFarmersCount();
                        int advertsMade = service.getAdvertsCount();
                        int disbursementsDone = service.getDisbursementsCount();
                        int approvedSuppliers = -1;

                        setCardVisibility(card1, registeredFarmers, "Registered Farmers", GoogleMaterialDesignIcons.RECEIPT);
                        setCardVisibility(card2, advertsMade, "Adverts Made", GoogleMaterialDesignIcons.ASSIGNMENT);
                        setCardVisibility(card3, disbursementsDone, "Disbursements Done", GoogleMaterialDesignIcons.GROUP);
                        setCardVisibility(card4, approvedSuppliers, "Approved Suppliers", GoogleMaterialDesignIcons.LOCAL_SHIPPING);
                    }

                    case "Serial Board Officer" -> {
                        int disbursed = service.getDisbursedCount(serialboard);
                        int inProgress = service.getInProgressDisbursementsCount(serialboard);
                        int farmersAwaiting = service.getAwaitingFarmersCount(serialboard);

                        setCardVisibility(card1, disbursed, "Disbursed", GoogleMaterialDesignIcons.LOCAL_SHIPPING);
                        setCardVisibility(card2, inProgress, "Disbursement In Progress", GoogleMaterialDesignIcons.PAYMENT);
                        setCardVisibility(card3, farmersAwaiting, "Farmers Awaiting", GoogleMaterialDesignIcons.PAYMENT);
                        setCardVisibility(card4, -1, "", null); // Hidden
                    }

                    case "Agricultural Minister(CS)" -> {
                        int registeredFarmers = service.getRegisteredFarmersCount();
                        int advertsMade = service.getAdvertsCount();
                        int disbursementsDone = service.getDisbursementsCount();
                        int approvedSuppliers = -1;
                        setCardVisibility(card1, registeredFarmers, "Registered Farmers", GoogleMaterialDesignIcons.RECEIPT);
                        setCardVisibility(card2, advertsMade, "Adverts Made", GoogleMaterialDesignIcons.ASSIGNMENT);
                        setCardVisibility(card3, disbursementsDone, "Disbursements Done", GoogleMaterialDesignIcons.GROUP);
                        setCardVisibility(card4, approvedSuppliers, "Approved Suppliers", GoogleMaterialDesignIcons.LOCAL_SHIPPING);
                    }

                    default -> {
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error loading data: " + ex.getMessage());
        }
    }

   

    private void setCardVisibility(Card card, int value, String title, GoogleMaterialDesignIcons icon) {
        if (value != -1 && value >= 0) {
            Icon iconObj = IconFontSwing.buildIcon(icon, 50, new Color(75, 75, 75, 80), new Color(75, 75, 75, 15));
            card.setData(new ModelCard(title, value, 50, iconObj));
            card.setVisible(true);  // Show card if data is present
        } else {
            card.setVisible(false); // Hide card if no data
        }
    }
    
    private void initTableData() {
        switch (userRole) {
            case "Farmer" -> initAdvertisementsTable();
            case "Chief Agricultural Officer" -> initFarmersApplicationsTable();
            case "Serial Board Officer" -> initAwaitingDisbursementsTable();
            case "Agricultural Minister(CS)" -> initAwaitingConfirmationsTable();
        }
    }

    private void showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
    }

    private void initAdvertisementsTable() {
        reportName.setText("Open Advertisements");
        createTableModel(new String[]{"ID", "Category", "Type", "Due Date", "Amount/Unit", "Action"}, service.getAvailableSubsidies(), "Apply");
    }

    private void initFarmersApplicationsTable() {
        reportName.setText("Farmers Active Applications");
        createTableModel(new String[]{"FarmerID", "SerialNo.", "Farmer Name", "Subcounty", "Size of Farm", "Nearest Serial Boards",
            "Subsidy Category", "Subsidy Type", "Amount Billed", "Action"},
                GetUserData.getSubsidyApplications(), "Review");
    }

    private void initAwaitingDisbursementsTable() {
        reportName.setText("Confirmed For Dusbursement");
        createTableModel(new String[]{"FarmerID", "SerialNo.", "Farmer Name", "Subcounty", "Size of Farm", "Serial Boards",
            "Subsidy Category", "Subsidy Type", "Amount Billed", "Action"},
                GetUserData.getSubsidyDisbursed(serialboard), "Disburse");
    }

    private void initAwaitingConfirmationsTable() {
        reportName.setText("Approved Applications");
        createTableModel(new String[]{"SubsidyID", "Subsidy Category", "Subsidy Type", "Farmers Applied", "Approved Farmers",
            "Disbursement In Progress", "Disbursed To", "Total Amount", "Action"}, GetUserData.getSubsidyRecords(), "Confirm");
    }

    private void createTableModel(String[] columnNames, List<?> records, String action) {
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table1.setModel(model);

        if (records.isEmpty()) {
            model.addRow(new Object[]{"No records available", "", "", "", "", "", "", "", "", ""});
            hideActionColumn();
        } else {
            for (Object record : records) {
                model.addRow(formatRowData(record, action));
            }
            table1.getColumn("Action").setCellRenderer(new ButtonRenderer());
            table1.getColumn("Action").setCellEditor(new ButtonEditor(new JButton(action), userRole, this));
        }
    }

    private Object[] formatRowData(Object record, String action) {
        if (record instanceof Object[]) {
            Object[] row = (Object[]) record;
            return new Object[]{row[0], row[1], row[2], row[3], row[4], action};
        } else if (record instanceof FarmerSubsidyApplication app) {
            return new Object[]{
                app.getFarmerId(), app.getSerialNo(), app.getFarmerName(), app.getFarmerSubCounty(),
                app.getFarmSize(), app.getSerialBoards(), app.getSubsidyCategory(), app.getSubsidyType(),
                app.getAmountBilled(), action
            };
        } else if (record instanceof SubsidyRecord rec) {
            return new Object[]{
                rec.getSubsidyID(), rec.getSubsidyCategory(), rec.getSubsidyType(), rec.getFarmersApplied(),
                rec.getApprovedFarmers(), rec.getInProgress(), rec.getDisbursed(), rec.getTotalAmount(), action
            };
        }
        return new Object[0];
    }

    private void hideActionColumn() {
        table1.getColumn("Action").setMinWidth(0);
        table1.getColumn("Action").setMaxWidth(0);
    }

    private class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value == null ? "Apply" : value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {

        private String label;
        private JButton button;
        private String role;
        private Form_Home parentPanel;

        public ButtonEditor(JButton button, String role, Form_Home parent) {
            super(new JTextField());
            this.button = button;
            this.role = role;
            this.parentPanel = parent;
            button.addActionListener(new ActionListenerImpl());
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Apply" : value.toString();
            button.setText(label);
            return button;
        }

        private class ActionListenerImpl implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                if (row != -1) {
                    performAction(row);
                }
            }

            private void performAction(int row) {
                String id = table1.getValueAt(row, 0).toString();
                String category = table1.getValueAt(row, 1).toString();
                String type = table1.getValueAt(row, 2).toString();
                String amount = table1.getValueAt(row, 4).toString();

                switch (role) {
                    case "Farmer":
                        int idInt = Integer.parseInt(id);
                        if (SubsidyService.hasFarmerAppliedForSubsidy(farmerId, idInt)) {
                            JOptionPane.showMessageDialog(null, "You have already applied for this subsidy.");
                        } else {
                            displayDialog(new ApplySubsidy(userEmail, farmerId, id, category, type, amount), "Apply for Subsidy");
                        }
                        break;
                    case "Chief Agricultural Officer":
                        displayDialog(new ReviewUser(id, table1.getValueAt(row, 1).toString()), "Review Application");
                        break;
                    case "Serial Board Officer":
                        displayDialog(new DisburseSubsidy(table1.getValueAt(row, 1).toString(), table1.getValueAt(row, 0).toString(), serialboard), "Disburse Subsidy");
                        break;
                    case "Agricultural Minister(CS)":
                        int result = UpdateDB.setStatusDisbursementInProgress(id, "Disbursement In Progress");
                        if (result != -1) {
                            JOptionPane.showMessageDialog(null, "Disbursement status updated successfully for Subsidy ID: " + id);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update the disbursement status for Subsidy ID: " + id);
                        }
                        break;
                }
            }

            private void displayDialog(JPanel panel, String title) {
                JDialog dialog = new JDialog(Main.getFrames()[0], title, true);
                dialog.getContentPane().add(panel);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new agripro.dashboard.component.Card();
        jLabel1 = new javax.swing.JLabel();
        card2 = new agripro.dashboard.component.Card();
        card3 = new agripro.dashboard.component.Card();
        card4 = new agripro.dashboard.component.Card();
        panelTransparent1 = new agripro.dashboard.swing.PanelTransparent();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new agripro.dashboard.swing.table.Table();
        reportName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1100, 746));

        card1.setPreferredSize(new java.awt.Dimension(250, 117));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        card2.setBackground(new java.awt.Color(10, 30, 214));
        card2.setPreferredSize(new java.awt.Dimension(250, 117));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setPreferredSize(new java.awt.Dimension(250, 117));

        card4.setBackground(new java.awt.Color(60, 195, 0));
        card4.setPreferredSize(new java.awt.Dimension(250, 117));

        panelTransparent1.setAlignmentX(0.0F);
        panelTransparent1.setAlignmentY(0.0F);
        panelTransparent1.setPreferredSize(new java.awt.Dimension(750, 550));

        jScrollPane1.setAutoscrolls(true);

        table1.setAutoCreateRowSorter(true);
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Location", "Subcounty", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setColumnSelectionAllowed(true);
        table1.setFillsViewportHeight(true);
        table1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table1.setPreferredSize(new java.awt.Dimension(500, 0));
        table1.setRowMargin(2);
        table1.setShowGrid(true);
        jScrollPane1.setViewportView(table1);

        reportName.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        reportName.setForeground(new java.awt.Color(102, 102, 102));
        reportName.setText("Table title");

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelTransparent1Layout.createSequentialGroup()
                        .addComponent(reportName, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportName, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(card1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private agripro.dashboard.component.Card card1;
    private agripro.dashboard.component.Card card2;
    private agripro.dashboard.component.Card card3;
    private agripro.dashboard.component.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private agripro.dashboard.swing.PanelTransparent panelTransparent1;
    private javax.swing.JLabel reportName;
    private agripro.dashboard.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables

}
