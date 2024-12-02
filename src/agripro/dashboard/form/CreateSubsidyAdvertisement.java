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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author angera
 */
public class CreateSubsidyAdvertisement extends javax.swing.JPanel {

    // Define subsidy types as arrays
    private String[] seedsTypes = {"Maize", "Beans", "Coffee", "Tea", "Cotton", "Sugarcane", "Pyretherum"};
    private String[] machineryTypes = {"Tractors", "Ploughs", "Harvesters", "Sprayers", "Tillage Equipment"};
    private String[] fertilizerTypes = {"NPK", "Urea", "DAP", "Compound Fertilizers"};
    private String[] pesticideTypes = {"Insecticides", "Herbicides", "Fungicides", "Rodenticides"};
    private String[] livestockFeedsTypes = {"Cattle Feed", "Poultry Feed", "Goat Feed", "Sheep Feed"};

    private Map<String, String[]> subsidyCategoriesMap = new HashMap<>();

    private SubsidyService service;

    public CreateSubsidyAdvertisement() {
        initComponents();
        initSubsidyCategoriesMap();
        populateSubsidyCategoryComboBox();
        populateDateComboBox();
        initListeners();
        service = new SubsidyService();
    }

    private void initSubsidyCategoriesMap() {
        subsidyCategoriesMap.put("Seeds", seedsTypes);
        subsidyCategoriesMap.put("Machinery and Equipments", machineryTypes);
        subsidyCategoriesMap.put("Fertilizer", fertilizerTypes);
        subsidyCategoriesMap.put("Pesticides", pesticideTypes);
        subsidyCategoriesMap.put("Livestock Feeds", livestockFeedsTypes);
    }

    private void populateSubsidyCategoryComboBox() {
        String[] categories = {"Seeds", "Fertilizer", "Pesticides", "Livestock Feeds", "Machinery and Equipments"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(categories);
        subsidyCategoryTxt.setModel(model);
    }

    private void initListeners() {
        subsidyCategoryTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSubsidyTypes();
            }
        });
    }

    private void updateSubsidyTypes() {
        String selectedCategory = (String) subsidyCategoryTxt.getSelectedItem();
        String[] subsidyTypes = subsidyCategoriesMap.get(selectedCategory);

        if (subsidyTypes != null) {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(subsidyTypes);
            subsudyTypeTxt.setModel(model);
        } else {
            subsudyTypeTxt.setModel(new DefaultComboBoxModel<>());
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        subsudyTypeTxt = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subsidyCategoryTxt = new javax.swing.JComboBox<>();
        amountPerUnitTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JComboBox<>();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        quantityAvailable = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(900, 400));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Subsidy Advertisement");

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
        jLabel4.setText("Due Date");

        dateTxt.setBackground(new java.awt.Color(0, 153, 153));
        dateTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton2.setText("CREATE ADVERT");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("Quantity");

        quantityAvailable.setBackground(new java.awt.Color(0, 153, 153));
        quantityAvailable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(subsudyTypeTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(subsidyCategoryTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(amountPerUnitTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dateTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(quantityAvailable, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(subsidyCategoryTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(subsudyTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(amountPerUnitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(dateTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLayeredPane2)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(quantityAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
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
                        .addGap(18, 18, 18)
                        .addComponent(dateTxt)))
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(amountPerUnitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(subsudyTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Retrieve input values
        var category = (String) subsidyCategoryTxt.getSelectedItem();
        var type = (String) subsudyTypeTxt.getSelectedItem();
        var amount = Integer.parseInt(amountPerUnitTxt.getText());
        var date = (String) dateTxt.getSelectedItem();
        var quantity = quantityAvailable.getText();

        // Insert the advertisement
        boolean isInserted = service.insertSubsidyAdvertisement(category, type, date, amount, quantity);

        if (isInserted) {
            // Show confirmation dialog with the details
            String message = String.format("Advertisement added successfully!\n\nCategory: %s\nType: %s\nAmount: %d\nDue Date: %s",
                    category, type, amount, date);
            JOptionPane.showMessageDialog(this, message, "Advertisement Added", JOptionPane.INFORMATION_MESSAGE);

            // Clear the input fields after the dialog is closed
            subsidyCategoryTxt.setSelectedIndex(0);
            subsudyTypeTxt.setSelectedIndex(0);
            amountPerUnitTxt.setText("");
            dateTxt.setSelectedIndex(-1);
            quantityAvailable.setText("");
        } else {
            // Handle failure case
            JOptionPane.showMessageDialog(this, "Failed to add the advertisement. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JTextField quantityAvailable;
    private javax.swing.JComboBox<String> subsidyCategoryTxt;
    private javax.swing.JComboBox<String> subsudyTypeTxt;
    // End of variables declaration//GEN-END:variables
}
