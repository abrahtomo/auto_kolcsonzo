package hu.unideb.inf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {


    @Id
    @GeneratedValue
    private Long id;

    private String vehicleType;

    private String make;

    private String model;

    private int year;

    private String engine;

    private String fuelType;

    private int seatingCapacity;

    public Vehicle() {}

    public Vehicle(String vehicleType, String make, String model, int year, String engine, String fuelType, int seatingCapacity) {
        this.vehicleType = vehicleType;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
