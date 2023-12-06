package org.axe.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="customers")

public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "customer_ID")
    private int id;
    @Column(name = "customerName",length = 30)
    private String name;

    @OneToMany (fetch = FetchType.EAGER)
    private List<Car> ownedCars = new ArrayList<>();

    public Customer() {

    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCar(Car car){
        ownedCars.add(car);
    }






}
