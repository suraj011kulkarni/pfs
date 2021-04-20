package com.pfs.erp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;


    @Column
    private Double weight;


    public Contents() {
    }

    public Contents(String name, Double price,Double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Contents(Long id, String name, Double price, Double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price!=null?price:0;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contents)) return false;

        Contents contents = (Contents) o;

        return name != null ? name.equals(contents.name) : contents.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
