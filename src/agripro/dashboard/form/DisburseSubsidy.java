/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package agripro.dashboard.form;

import agripro.backend.insert.InsertIntoDB;
import agripro.backend.retrieve.GetUserData;
import agripro.backend.update.UpdateDB;
import agripro.dashboard.model.Farmer;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author angera
 */
public class DisburseSubsidy extends javax.swing.JPanel {

    private String serialNo;
    private String farmerId;
    private String subsidyId;
    private String serialboards;

    public DisburseSubsidy(String serial, String farmer, String serialboard) {
        initComponents();
        
        this.farmerId = farmer;
        this.serialNo = serial;
        this.serialboards = serialboard;

        initComponents();
        initData();
    }

    private void initData() {
        List<Farmer> application = GetUserData.getConfirmedSubsidyDetails(serialNo);

        if (application.isEmpty()) {
            System.out.println("No subsidy details found for Farmer ID: " + farmerId + ", Serial No: " + serialNo);
            return;
        }

        // Iterate over the details and populate the fields
        for (Farmer detail : application) {
            if (detail != null) {
                addressTxt.setText("Address Line 1: " + (detail.getAddressLine() != null ? detail.getAddressLine() : "N/A"));
                amountTxt.setText("Total Billed Amount: Ksh. " + detail.getAmountBilled());
                fullnameTxt.setText("Name: " + (detail.getFarmerName() != null ? detail.getFarmerName() : "N/A"));
                idnoTxt.setText("ID NO: " + detail.getFarmerId());
                locationTxt.setText("Location: " + (detail.getLocation() != null ? detail.getLocation() : "N/A"));
                productTxt.setText("Type of Subsidy Applied: " + (detail.getSubsidyType() != null ? detail.getSubsidyType() : "N/A"));
                subcountyTxt.setText("Sub-County: " + (detail.getFarmerSubCounty() != null ? detail.getFarmerSubCounty() : "N/A"));
                sizeOfFarmTxt.setText("Size of Farm: " + (detail.getFarmSize() != null ? detail.getFarmSize() : "N/A"));
                typeOfSubsidyTxt.setText("Subsidy Category: " + (detail.getSubsidyCategory() != null ? detail.getSubsidyCategory() : "N/A"));
                subsidyId = detail.getSubsidyId();

                // Debug output for each field
                System.out.println("Fetched details for farmer: " + detail.getFarmerName());
            } else {
                System.out.println("No details available for this entry.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        sizeOfFarmTxt = new javax.swing.JLabel();
        typeOfSubsidyTxt = new javax.swing.JLabel();
        amountTxt = new javax.swing.JLabel();
        productTxt = new javax.swing.JLabel();
        addressTxt = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        fullnameTxt = new javax.swing.JLabel();
        subcountyTxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        locationTxt = new javax.swing.JLabel();
        idnoTxt = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentTxt = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        amountPaidTxt = new javax.swing.JTextField();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        confirmBtn = new javax.swing.JButton();
        putOnHold = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 204));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1100, 650));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DISBURSE SUBSIDY");
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 26));

        jLayeredPane4.setPreferredSize(new java.awt.Dimension(800, 530));

        sizeOfFarmTxt.setText("Size of the Farm");

        typeOfSubsidyTxt.setText("Type of subsidy");

        amountTxt.setText("Amount");

        productTxt.setText("Subsidy Product");

        addressTxt.setText("Physical Address");

        jLayeredPane2.setLayer(sizeOfFarmTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(typeOfSubsidyTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(amountTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(productTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(addressTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountTxt)
                    .addComponent(addressTxt)
                    .addComponent(sizeOfFarmTxt)
                    .addComponent(productTxt)
                    .addComponent(typeOfSubsidyTxt))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addComponent(sizeOfFarmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeOfSubsidyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(amountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        fullnameTxt.setText("Full Name");

        subcountyTxt.setText("Sub-County\n");

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel4.setText("Physical Location");

        locationTxt.setText("Location");

        idnoTxt.setText("ID NO");

        jLayeredPane1.setLayer(fullnameTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(subcountyTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(locationTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(idnoTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(locationTxt)
                    .addComponent(subcountyTxt)
                    .addComponent(jLabel4)
                    .addComponent(idnoTxt)
                    .addComponent(fullnameTxt))
                .addGap(0, 236, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(fullnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(idnoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(subcountyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(locationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        commentTxt.setBackground(new java.awt.Color(0, 204, 204));
        commentTxt.setColumns(20);
        commentTxt.setLineWrap(true);
        commentTxt.setRows(5);
        commentTxt.setWrapStyleWord(true);
        commentTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        commentTxt.setDragEnabled(true);
        commentTxt.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(commentTxt);

        jLabel13.setText("Comment*");

        jLabel2.setText("Amount Paid");

        amountPaidTxt.setBackground(new java.awt.Color(0, 204, 204));
        amountPaidTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLayeredPane5.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(amountPaidTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(amountPaidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountPaidTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        confirmBtn.setBackground(new java.awt.Color(0, 255, 0));
        confirmBtn.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Approve");
        confirmBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        putOnHold.setBackground(new java.awt.Color(255, 0, 102));
        putOnHold.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        putOnHold.setForeground(new java.awt.Color(255, 255, 255));
        putOnHold.setText("Put On Hold");
        putOnHold.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        putOnHold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                putOnHoldActionPerformed(evt);
            }
        });

        jLayeredPane6.setLayer(confirmBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(putOnHold, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(putOnHold)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(putOnHold, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLayeredPane3.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLayeredPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLayeredPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLayeredPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addComponent(jLayeredPane1)
                .addGap(35, 35, 35)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLayeredPane4.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void putOnHoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_putOnHoldActionPerformed
        // TODO add your handling code here:
        // Get the comments from the commentTxt field
        String comments = commentTxt.getText().trim();
        String status = "On Hold";

        UpdateDB.updateUserApplication(serialNo, comments, status);

        // Close the dialog (popup) after submission
        SwingUtilities.getWindowAncestor(this).dispose();

    }//GEN-LAST:event_putOnHoldActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // Get the comments from the commentTxt field
        String comments = commentTxt.getText().trim();
        double amountPaid = Double.parseDouble(amountPaidTxt.getText());
        String status = "Disbursed";

        boolean isInserted = InsertIntoDB.disburseSubdidy(serialNo, amountPaid, comments, serialboards);

        if (isInserted) {
            UpdateDB.setStatusDisbursed(serialNo, status);
            // Close the dialog (popup) after submission
            SwingUtilities.getWindowAncestor(this).dispose();
        }


    }//GEN-LAST:event_confirmBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressTxt;
    private javax.swing.JTextField amountPaidTxt;
    private javax.swing.JLabel amountTxt;
    private javax.swing.JTextArea commentTxt;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel fullnameTxt;
    private javax.swing.JLabel idnoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationTxt;
    private javax.swing.JLabel productTxt;
    private javax.swing.JButton putOnHold;
    private javax.swing.JLabel sizeOfFarmTxt;
    private javax.swing.JLabel subcountyTxt;
    private javax.swing.JLabel typeOfSubsidyTxt;
    // End of variables declaration//GEN-END:variables
}
