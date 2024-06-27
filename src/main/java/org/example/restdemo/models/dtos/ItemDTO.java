package org.example.restdemo.models.dtos;

public class ItemDTO {
    private int id;
    private  String  name;
    private int quantity;
    private String barcode;
    private String enteredDate;

    public ItemDTO() {
    }

    public int getId() {
        return id;
    }

    public ItemDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public ItemDTO setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public String getEnteredDate() {
        return enteredDate;
    }

    public ItemDTO setEnteredDate(String enteredDate) {
        this.enteredDate = enteredDate;
        return this;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", barcode='" + barcode + '\'' +
                ", enteredDate='" + enteredDate + '\'' +
                '}';
    }
}
