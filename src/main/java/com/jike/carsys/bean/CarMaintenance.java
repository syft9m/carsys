package com.jike.carsys.bean;

public class CarMaintenance {
    private Integer maintenanceId;
    private String appointmentTime;
    private String isVip;
    private String name;
    private String phone;
    private String carNo;

    public CarMaintenance() {

    }

    public CarMaintenance(Integer maintenanceId, String appointmentTime, String isVip, String name, String phone, String carNo) {
        this.maintenanceId = maintenanceId;
        this.appointmentTime = appointmentTime;
        this.isVip = isVip;
        this.name = name;
        this.phone = phone;
        this.carNo = carNo;
    }

    public CarMaintenance(String isVip) {
        this.isVip = isVip;
    }

    public CarMaintenance(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
}
