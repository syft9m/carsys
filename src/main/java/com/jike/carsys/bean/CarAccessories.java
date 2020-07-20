package com.jike.carsys.bean;

public class CarAccessories {
    private Integer id;
    private String brand;
    private String accessoriesName;
    private Boolean availability;
    private Float price;


    public CarAccessories(Integer id, String brand, String accessoriesName, Boolean availability, Float price) {
        this.id = id;
        this.brand = brand;
        this.accessoriesName = accessoriesName;
        this.availability = availability;
        this.price = price;
    }

    public CarAccessories() {
    }

    public CarAccessories(String accessoriesName, boolean availability) {
        this.accessoriesName = accessoriesName;
        this.availability = availability;
    }

    public CarAccessories(String accessoriesName, Float price) {
        this.accessoriesName = accessoriesName;
        this.price = price;
    }

    public CarAccessories(String accessoriesName, boolean availability, Float price) {
        this.accessoriesName = accessoriesName;
        this.availability = availability;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAccessoriesName() {
        return accessoriesName;
    }

    public void setAccessoriesName(String accessories_name) {
        this.accessoriesName = accessories_name;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarAccessories{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", accessories_name='" + accessoriesName + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                '}';
    }
}
