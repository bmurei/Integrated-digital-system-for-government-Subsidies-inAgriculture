/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agripro.backend.models;

public class SubsidyRecord {
    private int subsidyID;
    private String subsidyCategory;
    private String subsidyType;
    private int farmersApplied;
    private int approvedFarmers;
    private int inprogress;
    private int disbursed;
    private double totalAmount;

    // Constructor
    public SubsidyRecord(int subsidyID, String subsidyCategory, String subsidyType, 
                         int farmersApplied, int approvedFarmers, int inProgress, int disbursed,double totalAmount) {
        this.subsidyID = subsidyID;
        this.subsidyCategory = subsidyCategory;
        this.subsidyType = subsidyType;
        this.farmersApplied = farmersApplied;
        this.approvedFarmers = approvedFarmers;
        this.totalAmount = totalAmount;
        this.inprogress = inProgress;
        this.disbursed = disbursed;
    }

    // Getters
    public int getSubsidyID() { return subsidyID; }
    public String getSubsidyCategory() { return subsidyCategory; }
    public String getSubsidyType() { return subsidyType; }
    public int getFarmersApplied() { return farmersApplied; }
    public int getApprovedFarmers() { return approvedFarmers; }
    public int getInProgress() { return inprogress; }
    public int getDisbursed() { return disbursed; }
    public double getTotalAmount() { return totalAmount; }
    
}

