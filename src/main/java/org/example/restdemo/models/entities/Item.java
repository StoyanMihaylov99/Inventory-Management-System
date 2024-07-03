package org.example.restdemo.models.entities;

import jakarta.persistence.*;

import java.util.Date;

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
    private Date enteredDate;

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

    public Date getEnteredDate() {
        return enteredDate;
    }

    public Item setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
        return this;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", barcode='" + barcode + '\'' +
                ", enteredDate='" + enteredDate + '\'' +
                '}';
    }
}
