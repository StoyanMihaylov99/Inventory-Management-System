package org.example.restdemo.models.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.Date;

public class ItemDTO {
    @NotNull
    private int id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name length must be between 2 and 50 characters")
    private  String  name;
    @NotNull(message = "Quantity cannot be blank")
    @Positive(message = "Quantity should be positive")
    private int quantity;
    @NotBlank(message = "Barcode cannot be blank")
    @Size(min = 0, max = 30, message = "Barcode length must be between 0 and 30 characters")
    private String barcode;
    @NotNull(message = "Date cannot be blank")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date enteredDate;

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


    public Date getEnteredDate() {
        return enteredDate;
    }

    public ItemDTO setEnteredDate(Date enteredDate) {
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
