
package agripro.dashboard.model;

import java.util.Date;

public class Farmer {
    // Existing fields
    private String farmerName;
    private int farmerId;
    private String subsidyId;
    private String farmerSubCounty;
    private String serialBoards;
    private String farmSize;
    private String subsidyCategory;
    private String subsidyType;
    private String applicationStatus;
    private double amountBilled;
    private String quantity;
    private String status;
    private String applicationDate;
    private String serialNo;

    // New fields
    private String location;
    private String addressLine;

    // Getters and Setters for new fields
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    // Existing getters and setters
    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getSubsidyId() {
        return subsidyId;
    }

    public void setSubsidyId(String subsidyId) {
        this.subsidyId = subsidyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFarmerSubCounty() {
        return farmerSubCounty;
    }

    public void setFarmerSubCounty(String farmerSubCounty) {
        this.farmerSubCounty = farmerSubCounty;
    }

    public String getSerialBoards() {
        return serialBoards;
    }

    public void setSerialBoards(String serialBoards) {
        this.serialBoards = serialBoards;
    }

    public String getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(String farmSize) {
        this.farmSize = farmSize;
    }

    public String getSubsidyCategory() {
        return subsidyCategory;
    }

    public void setSubsidyCategory(String subsidyCategory) {
        this.subsidyCategory = subsidyCategory;
    }

    public String getSubsidyType() {
        return subsidyType;
    }

    public void setSubsidyType(String subsidyType) {
        this.subsidyType = subsidyType;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public double getAmountBilled() {
        return amountBilled;
    }

    public void setAmountBilled(double amountBilled) {
        this.amountBilled = amountBilled;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}

