package agripro.dashboard.model;

import java.util.Date;

public class FarmerSubsidyDetail {
    private int farmerId;
    private String farmerName;
    private String farmerPhone;
    private String farmerEmail;
    private String farmerSubCounty;
    private String farmerVillage;
    private String serialNo;
    private double amountBilled;
    private double amountPaid;
    private String quantity;  // For quantity
    private String applicationDate;
    private String applicationType; // For application type
    private int subsidyId; // New field for subsidyId

    // Getters
    public int getFarmerId() {
        return farmerId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public String getFarmerPhone() {
        return farmerPhone;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public String getFarmerSubCounty() {
        return farmerSubCounty;
    }

    public String getFarmerVillage() {
        return farmerVillage;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public double getAmountBilled() {
        return amountBilled;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public int getSubsidyId() {
        return subsidyId;
    }

    // Setters
    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public void setFarmerPhone(String farmerPhone) {
        this.farmerPhone = farmerPhone;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public void setFarmerSubCounty(String farmerSubCounty) {
        this.farmerSubCounty = farmerSubCounty;
    }

    public void setFarmerVillage(String farmerVillage) {
        this.farmerVillage = farmerVillage;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public void setAmountBilled(double amountBilled) {
        this.amountBilled = amountBilled;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public void setSubsidyId(int subsidyId) {
        this.subsidyId = subsidyId;
    }
}
