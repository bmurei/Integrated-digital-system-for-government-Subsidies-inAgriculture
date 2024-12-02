/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package agripro.dashboard.form;

import agripro.backend.models.User;
import agripro.backend.retrieve.GetUserData;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angera
 */
public class ViewReports extends javax.swing.JPanel {

    private String userEmail;
    private String role;
    private String report;
    private String farmerId;
    private String supplierId;
    private String userId;
    private String serialboard;

    public ViewReports(String email, String userRole, String report) {

        this.userEmail = email;
        this.role = userRole;
        this.report = report;

        // Set up user details based on role
        User user = GetUserData.getUserByEmail(userEmail);
        userId = user.getUserId();
        if ("Farmer".equals(userRole)) {
            farmerId = user.getFarmerId();
        } else if ("Serial Board Officer".equals(userRole)) {
            serialboard = user.getSerialBoardName();
            supplierId = user.getSupplierId();
        }

        initComponents();
        initTableData();
    }

    private void initTableData() {

        var id = Integer.parseInt(userId);
        int fId = 0;
        if(role.equals("Farmer")){
          fId = Integer.parseInt(farmerId);  
        }    
        // Clear previous data before setting new data
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous rows

        switch (role) {
            case "Chief Agricultural Officer" -> {
                switch (report) {

                    case "Adverts" -> {
                        reportName.setText("Subdisies Advertised");
                        loadAdvertised();
                    }
                    case "Registered Farmers" -> {
                        loadRegisteredFarmers();
                        reportName.setText("Registered Farmers");
                    }
                    case "Approved" -> {
                        reportName.setText("Approved Applications");
                        loadApproved();
                    }
                    case "Declined" -> {
                        reportName.setText("Declined Applications");
                        loadDeclined();
                    }
                    case "Disbursements" -> {
                        reportName.setText("Disbursment");
                        loadDisbursement();
                    }
                    default -> {
                        reportName.setText("Report not recognized");
                        table.setVisible(false);
                    }
                }
            }

            case "Farmer" -> {
                switch (report) {

                    case "My Subsidies" -> {
                        reportName.setText("My Subsidies");
                        loadMySubsidies(fId);
                    }
                    default -> {
                        reportName.setText("Report not recognized");
                        table.setVisible(false);
                    }
                }
            }

            case "Serial Board Officer" -> {
                if (report.equals("Our Applicants")) {
                    reportName.setText("Our Applicants");
                    OurAppliedFarmers();

                }
            }

            case "Agricultural Minister(CS)" -> {
                switch (report) {

                    case "Adverts" -> {
                        reportName.setText("Subdisies Advertised");
                        loadAdvertised();
                    }
                    case "Registered Farmers" -> {
                        loadRegisteredFarmers();
                        reportName.setText("Registered Farmers");
                    }
                    case "Approved" -> {
                        reportName.setText("Approved Applications");
                        loadApproved();
                    }
                    case "Declined" -> {
                        reportName.setText("Declined Applications");
                        loadDeclined();
                    }
                    case "Disbursements" -> {
                        reportName.setText("Disbursment");
                        loadDisbursement();
                    }
                    default -> {
                        reportName.setText("Report not recognized");
                        table.setVisible(false);
                    }
                }
            }

            default -> {
                reportName.setText("User role not recognized");
                table.setVisible(false);
            }
        }
    }

    public void loadMySubsidies(int fId) {
        List<List<Object>> data = GetUserData.getMySubsidies(fId); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"SerialNo.", "Farmer Name", "Serial Boards",
            "Subsidy Category", "Subsidy Type", "Amount Billed", "Status"});

        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    public void loadRegisteredFarmers() {
        List<List<Object>> data = GetUserData.getRegisteredFarmers(); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"ID", "Farmer Name", "Physical Address", "Subcounty", "Location",
            "Subsidy Applied", "Total Amount Billed"});

        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    public void loadAdvertised() {
        List<List<Object>> data = GetUserData.getAdvertised(); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"ID", "Category", "Type", "Posted On", "Due Date", "Amount/Unit", "Farmers Applied", "Farmers Approved", "Farmers Declined"});

        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    public void loadApproved() {
        List<List<Object>> data = GetUserData.getApproved(); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"FarmerID", "SerialNo.", "Farmer Name", "Nearest Serial Boards",
            "Subsidy Category", "Subsidy Type", "Amount Billed"});

        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    public void loadDeclined() {
        List<List<Object>> data = GetUserData.getDeclinedApplications(); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"FarmerID", "SerialNo.", "Farmer Name", "Nearest Serial Boards",
            "Subsidy Category", "Subsidy Type", "Amount Billed"});

        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    public void loadDisbursement() {
        List<List<Object>> data = GetUserData.getDisbursements(); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"FarmerID", "SerialNo.", "Farmer Name", "Subcounty", "Nearest Serial Boards",
            "Subsidy Category", "Subsidy Type", "Amount Billed"});
        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    public void AppliedFarmers() {
        List<List<Object>> data = GetUserData.getAppliedFarmers(); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"FarmerID", "SerialNo.", "Farmer Name",
            "Subcounty", "Size of Farm", "Nearest Serial Board",
            "Subsidy Category", "Subsidy Type", "Quantity", "Amount Billed", "Status"});

        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    public void ApprovedSubsidies() {

    }

    public void OurAppliedFarmers() {
        List<List<Object>> data = GetUserData.getSerialBoardAppliedFarmers(serialboard); // Fetch data from UserData
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Set appropriate column titles based on your database fields
        model.setColumnIdentifiers(new String[]{"FarmerID","Farmer Name", "Telephone","Email","Physical Address", 
            "Village","Serial Board","SerialNo.", "Amount Billed", "Amount Paid","Application Type","Application Date","Status"});

        for (List<Object> row : data) {
            model.addRow(row.toArray());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new agripro.dashboard.swing.PanelTransparent();
        reportName = new javax.swing.JLabel();
        panelTransparent2 = new agripro.dashboard.swing.PanelTransparent();
        spTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1100, 650));

        panelTransparent1.setAutoscrolls(true);
        panelTransparent1.setPreferredSize(new java.awt.Dimension(1100, 650));

        reportName.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        reportName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportName.setText("Confirm Subsidies Approvals for Disbursement");
        reportName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportName.setPreferredSize(new java.awt.Dimension(1100, 50));

        panelTransparent2.setAutoscrolls(true);
        panelTransparent2.setPreferredSize(new java.awt.Dimension(1100, 600));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setColumnSelectionAllowed(true);
        table.setDragEnabled(true);
        table.setFillsViewportHeight(true);
        table.setPreferredSize(new java.awt.Dimension(1000, 0));
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addComponent(reportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private agripro.dashboard.swing.PanelTransparent panelTransparent1;
    private agripro.dashboard.swing.PanelTransparent panelTransparent2;
    private javax.swing.JLabel reportName;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
