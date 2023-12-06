package org.axe.entity;


import javax.persistence.*;

@Entity
@Table (name ="cars")
public class Car {
    @Id
    @Column (name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (length = 8)
    private String Car;




}
