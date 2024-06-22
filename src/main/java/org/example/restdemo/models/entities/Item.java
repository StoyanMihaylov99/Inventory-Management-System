package org.example.restdemo.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private  String  name;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "barcode", nullable = false, columnDefinition = "TEXT")
    private String barcode;
    @Column(name = "enteredDate")
    private String enteredDate;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public Item setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public Item setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public String getEnteredDate() {
        return enteredDate;
    }

    public Item setEnteredDate(String enteredDate) {
        this.enteredDate = enteredDate;
        return this;
    }
}
