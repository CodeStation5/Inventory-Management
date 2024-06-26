package com.example.demo.domain;

import com.example.demo.validators.ItemListCheck;
import com.example.demo.validators.ValidDeletePart;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
// Validator to check inventory
@ItemListCheck
@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Max(value = 100, message = "Inventory max is 100")
    int invHigh;
    @Min(value = 0, message = "Inventory min is at 0")
    int invLow;

    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;

    @ManyToMany
    @JoinTable(name = "product_part", joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> products = new HashSet<>();

    // No argument constructor
    public Part(){}

    public Part(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    // Constructor to take in all values except min/max inventory
    public Part(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
    }
    // Constructor to take in all needed values
    public Part (long id, String name, double price, int inv, int invLow, int invHigh) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.inv = inv;
        this.invHigh = invHigh;
        this.invLow = invLow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getInvHigh(){
        return invHigh;
    }
    public void setInvHigh(int invHigh){
        this.invHigh = invHigh;
    }
    public int getInvLow() {
        return invLow;
    }
    public void setInvLow(int invLow){
        this.invLow = invLow;
    }
    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
