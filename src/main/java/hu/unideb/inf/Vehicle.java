package hu.unideb.inf;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vehicleType;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String engine;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private int seatingCapacity;

    public Vehicle(String vehicleType, String make, String model, int year, String engine, String fuelType, int seatingCapacity) {
        this.vehicleType = vehicleType;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
    }
}
