/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package agripro.dashboard.form;

import static agripro.backend.insert.InsertIntoDB.makeApplication;
import static agripro.backend.retrieve.GetUserData.getFarmerSubsidyDetails;
import agripro.dashboard.model.FarmerSubsidyApplication;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author angera
 */
public class SubsequentApplication extends javax.swing.JPanel {

    /**
     * Creates new form SubsequentApplication
     */
    private String farmerId;

    public SubsequentApplication(String farmerId) {
        this.farmerId = farmerId;
        initComponents();
        loadSubsidyDetails();
    }
    
    
    

    // Custom TableCellRenderer for displaying a button
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            setBackground(new Color(255, 99, 71)); // Red color
            setForeground(Color.WHITE);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value == null ? "Apply" : value.toString());
            return this;
        }
    }

// Custom TableCellEditor for handling button clicks
    class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private JButton button;
        private FarmerSubsidyApplication currentDetail;
        private List<FarmerSubsidyApplication> subsidyDetails;

        public ButtonEditor(List<FarmerSubsidyApplication> subsidyDetails) {
            this.subsidyDetails = subsidyDetails;
            button = new JButton("Apply");
            button.setOpaque(true);
            button.setBackground(new Color(255, 99, 71)); // Red color
            button.setForeground(Color.WHITE);

            // Add an ActionListener to handle button clicks
            button.addActionListener(e -> {
                handleApplication(currentDetail); // Use the current detail
                fireEditingStopped(); // Notify the editor to stop editing
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            currentDetail = subsidyDetails.get(row); // Get the current detail based on the row
            button.setText(value == null ? "Apply" : value.toString());
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Apply"; // Return the button label
        }
    }

    private void loadSubsidyDetails() {
        List<FarmerSubsidyApplication> subsidyDetails = getFarmerSubsidyDetails(farmerId);

        if (subsidyDetails == null || subsidyDetails.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No subsidy details found for this farmer.", "No Data", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);

        model.setColumnIdentifiers(new Object[]{
            "Application Date", "Serial No", "Farmer Name", "Sub-County",
            "Quantity", "Amount Billed", "Status", "Action"
        });

        for (FarmerSubsidyApplication detail : subsidyDetails) {
            Object[] row = {
                detail.getApplicationDate(),
                detail.getSerialNo(),
                detail.getFarmerName(),
                detail.getFarmerSubCounty(),
                detail.getQuantity(),
                detail.getAmountBilled(),
                detail.getStatus(),
                "Apply" // Placeholder for the button
            };
            model.addRow(row);
        }

        // Set renderer and editor for the "Action" column
        table1.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table1.getColumn("Action").setCellEditor(new ButtonEditor(subsidyDetails));
    }

    private void handleApplication(FarmerSubsidyApplication detail) {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int response = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to apply for " + detail.getSubsidyType() + " for the year " + currentYear + "'s application?",
                "Confirm Application", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            // Attempt to submit the application
            int serial = makeApplication(
                    farmerId, detail.getSubsidyId(), detail.getQuantity(),
                    detail.getSerialBoards(), detail.getAmountBilled(), detail.getFarmSize(), "Subsequent Application");

            // Show success or failure message based on result
            if (serial != -1) {
                JOptionPane.showMessageDialog(this, serial + " Application submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to submit application. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent2 = new agripro.dashboard.swing.PanelTransparent();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new agripro.dashboard.swing.table.Table();

        setBackground(new java.awt.Color(0, 102, 102));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        panelTransparent2.setPreferredSize(new java.awt.Dimension(1100, 700));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUBMIT SUBSEQUENT SUBSIDY APPLICATION");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(1100, 50));

        jScrollPane1.setBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1100, 650));

        table1.setAutoCreateRowSorter(true);
        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout panelTransparent2Layout = new javax.swing.GroupLayout(panelTransparent2);
        panelTransparent2.setLayout(panelTransparent2Layout);
        panelTransparent2Layout.setHorizontalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addGroup(panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTransparent2Layout.setVerticalGroup(
            panelTransparent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("SUBMIT SUBSEQUENT SUBSIDY APPLICATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private agripro.dashboard.swing.PanelTransparent panelTransparent2;
    private agripro.dashboard.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
