package com.jike.carsys.bean;


public class Car {
    private Integer carId;
    private String brand;
    private String type;
    private Float price;

    public Car() {

    }

    public Car(Integer carId, String brand, String type, Float price) {
        this.carId = carId;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(String type, Float price) {
        this.type = type;
        this.price = price;
    }

    public Car(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public Car(float price) {
        this.price = price;
    }

    public Car(int carId, String type, Float price) {
        this.carId = carId;
        this.type = type;
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carId +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

}
