package com.example.hw7rest_resp_entity.rest;

public class Shop {
    private String name;
    private String address;
    private String id;
    private int employeeQuantity;
    private boolean siteExists;

    public Shop(String name, String address, String id, int employeeQuantity, boolean siteExists) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.employeeQuantity = employeeQuantity;
        this.siteExists = siteExists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(int employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public boolean isSiteExists() {
        return siteExists;
    }

    public void setSiteExists(boolean siteExists) {
        this.siteExists = siteExists;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", employeeQuantity=" + employeeQuantity +
                ", siteExists=" + siteExists +
                '}';
    }
}
