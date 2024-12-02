package agripro.backend.models;

public class User {

    private String userId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String userRole;

    // Farmer-specific fields
    private String farmerId;
    private String idNo;
    private String subcounty;
    private String locationName;
    private String villageName;
    private String plotNo;
    private String address;
    private String crops;

    //specifics for Input Supplier
    private String supplierId;
    private String serialBoardName;
    private String serialBoardLocation;

    // Constructor for regular users (without farmer-specific fields)
    public User(String id, String name, String email, String phone, String password, String userRole) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.userRole = userRole;
    }

    // Constructor for input suppliers users (with input supplier-specific fields)
    public User(String id, String name, String email, String phone, String password, String userRole, String sid, String idNo,String boardName, String boardLocation) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.userRole = userRole;
        this.supplierId = sid;
        this.idNo = idNo;
        this.serialBoardName = boardName;
        this.serialBoardLocation = boardLocation;

    }

    // Constructor for farmers (with farmer-specific fields)
    public User(String id, String name, String email, String phone, String password, String userRole, String fId, String idNo, String subcounty, String locationName, String villageName, String plotNo, String addressline) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.userRole = userRole;
        this.farmerId = fId;
        this.idNo = idNo;
        this.subcounty = subcounty;
        this.locationName = locationName;
        this.villageName = villageName;
        this.plotNo = plotNo;
        this.address = addressline;
    }

    // Getters and setters for common fields
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    // Getters and setters for farmer-specific fields
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSubcounty() {
        return subcounty;
    }

    public void setSubcounty(String subcounty) {
        this.subcounty = subcounty;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    // Getters and setters for common fields
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSerialBoardLocation() {
        return serialBoardLocation;
    }

    public void setSerialBoardLocation(String serialBoardLocation) {
        this.serialBoardLocation = serialBoardLocation;
    }

    public String getSerialBoardName() {
        return serialBoardName;
    }

    public void setSerialBoardName(String serialBoardName) {
        this.serialBoardName = serialBoardName;
    }

    // Method to check if the user is a farmer
    public boolean isFarmer() {
        return "Farmer".equalsIgnoreCase(this.userRole);
    }

    // Method to check if the user is a inputSupplier
    public boolean isSupplier() {
        return "Serial Board Officer".equalsIgnoreCase(this.userRole);
    }

    // Override toString to display user and farmer info
    @Override
    public String toString() {
        if (isFarmer()) {
            return "Farmer [id=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone
                    + ", idNo=" + idNo + ", subcounty=" + subcounty + ", locationName=" + locationName
                    + ", villageName=" + villageName + ", plotNo=" + plotNo + ", farmSize=" + address
                    + ", crops=" + crops + "]";
        } else {
            return "User [id=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", role=" + userRole + "]";
        }
    }
}
