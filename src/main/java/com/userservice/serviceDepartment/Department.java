package com.userservice.serviceDepartment;

public class Department {
    private long Id;
    private String deparmentName;
    private String deparmentAddress;
    private String deparmentCode;

    public Department() {
    }

    public Department(long id, String deparmentName, String deparmentAddress, String deparmentCode) {
        Id = id;
        this.deparmentName = deparmentName;
        this.deparmentAddress = deparmentAddress;
        this.deparmentCode = deparmentCode;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDeparmentName() {
        return deparmentName;
    }

    public void setDeparmentName(String deparmentName) {
        this.deparmentName = deparmentName;
    }

    public String getDeparmentAddress() {
        return deparmentAddress;
    }

    public void setDeparmentAddress(String deparmentAddress) {
        this.deparmentAddress = deparmentAddress;
    }

    public String getDeparmentCode() {
        return deparmentCode;
    }

    public void setDeparmentCode(String deparmentCode) {
        this.deparmentCode = deparmentCode;
    }
}
