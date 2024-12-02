/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package agripro.dashboard.form;

import agripro.backend.services.SubsidyService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UpdateAdvert extends javax.swing.JPanel {

    private String id;
    private String status;
    private String category;
    private String type;
    private String amount;
    private String date;
    private SubsidyService service;

    public UpdateAdvert() {
        initComponents();
        populateSubsidyCategory();
        populateDateComboBox();
        initListeners();
        service = new SubsidyService();
    }

    private void populateSubsidyCategory() {
        // Fetch the available subsidy categories
        List<Object[]> subsidies = SubsidyService.getAvailableSubsidies();

        // Clear the ComboBox before adding new items
        subsidyCategoryTxt.removeAllItems();

        if (subsidies.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No available subsidies to display.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Use a Set to ensure unique categories
        Set<String> categories = new HashSet<>();
        for (Object[] subsidy : subsidies) {
            String catys = (String) subsidy[1];
            categories.add(catys);
        }

        // Add each unique category to the ComboBox
        for (String cat : categories) {
            subsidyCategoryTxt.addItem(cat);
        }

        System.out.println("Subsidy categories loaded into ComboBox.");
    }

    private void initListeners() {
        subsidyCategoryTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSubsidyTypes();
            }
        });

        subsudyTypeTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFieldsBasedOnType();
            }
        });
    }

    private void updateSubsidyTypes() {
        String selectedCategory = (String) subsidyCategoryTxt.getSelectedItem();
        List<String> subsidyTypes = service.getSubsidyTypesByCategory(selectedCategory);

        if (subsidyTypes != null) {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(subsidyTypes.toArray(new String[0]));
            subsudyTypeTxt.setModel(model);
        } else {
            subsudyTypeTxt.setModel(new DefaultComboBoxModel<>());
        }
    }

    private void updateFieldsBasedOnType() {
        String selectedType = (String) subsudyTypeTxt.getSelectedItem();
        Map<String, Object> details = service.getSubsidyDetailsByType(selectedType);

        if (details != null) {
            dateTxt.setSelectedItem((String) details.get("dueDate"));
            amountPerUnitTxt.setText(String.valueOf(details.get("amount")));
        } else {
            dateTxt.setSelectedIndex(-1);
            amountPerUnitTxt.setText("");
        }
    }
    
    
    private void populateDateComboBox() {
        // Get today's date
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(2099, 12, 31);  // Set end date to December 31, 2099
        List<String> dates = new ArrayList<>();

        // Generate dates from today to endDate
        while (!startDate.isAfter(endDate)) {
            dates.add(startDate.toString());  // Add date as a string in "YYYY-MM-DD" format
            startDate = startDate.plusDays(1);  // Move to the next day
        }

        // Populate ComboBox
        dateTxt.removeAllItems();  // Clear existing items
        for (String date : dates) {
            dateTxt.addItem(date);  // Add each date to the ComboBox
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTransparent1 = new agripro.dashboard.swing.PanelTransparent();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        subsudyTypeTxt = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subsidyCategoryTxt = new javax.swing.JComboBox<>();
        amountPerUnitTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        advertStatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1100, 650));

        panelTransparent1.setPreferredSize(new java.awt.Dimension(1100, 650));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Update Subsidy Advertisement");

        subsudyTypeTxt.setBackground(new java.awt.Color(0, 153, 153));
        subsudyTypeTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maize", "Beans", "Sunflower", "pyrethrum", " " }));
        subsudyTypeTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Subsidy Category");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("Specific Type");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Amount per unit");

        subsidyCategoryTxt.setBackground(new java.awt.Color(0, 153, 153));
        subsidyCategoryTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fertilizer", "Seeds", "Pesticides", "Equipments", "Livestock feeds", " " }));
        subsidyCategoryTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        amountPerUnitTxt.setBackground(new java.awt.Color(0, 153, 153));
        amountPerUnitTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Extend/Reduce Due Date");

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton2.setText("CREATE ADVERT");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLayeredPane2.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        advertStatus.setBackground(new java.awt.Color(0, 153, 153));
        advertStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "open", "close" }));
        advertStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("Advertisement Status: *Close/Open");

        jLayeredPane3.setLayer(advertStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(advertStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(advertStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        dateTxt.setBackground(new java.awt.Color(0, 153, 153));
        dateTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("Quantity");

        quantityTxt.setBackground(new java.awt.Color(0, 153, 153));
        quantityTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(subsudyTypeTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(subsidyCategoryTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(amountPerUnitTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dateTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(quantityTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(jLabel1))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(subsidyCategoryTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addComponent(subsudyTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addGap(161, 161, 161)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(amountPerUnitTxt)
                                    .addComponent(dateTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jLayeredPane2))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(subsidyCategoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateTxt)))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(amountPerUnitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(subsudyTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Retrieve input value

        String new_status = (String) advertStatus.getSelectedItem();
        double new_amount = Double.parseDouble(amountPerUnitTxt.getText());
        String new_date = (String) dateTxt.getSelectedItem();
        String quantity = quantityTxt.getText();

        int subsidyId = Integer.parseInt(id);

        // Insert the advertisement
        boolean isUpdated = service.updateSubsidyAdvertisement(subsidyId, new_date, new_amount, new_status, quantity);

        if (isUpdated) {
            // Show confirmation dialog with the details
            String message = String.format("Advertisement updated successfully!\n\nCategory: %s\nType: %s\nCurrent Amount: %f\nDue Date: %s\nNew Status: %s",
                    category, type, new_amount, new_date, new_status);
            JOptionPane.showMessageDialog(this, message, "Advertisement Updated", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Handle failure case
            JOptionPane.showMessageDialog(this, "Failed to update the advertisement. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> advertStatus;
    private javax.swing.JTextField amountPerUnitTxt;
    private javax.swing.JComboBox<String> dateTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private agripro.dashboard.swing.PanelTransparent panelTransparent1;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JComboBox<String> subsidyCategoryTxt;
    private javax.swing.JComboBox<String> subsudyTypeTxt;
    // End of variables declaration//GEN-END:variables
}
