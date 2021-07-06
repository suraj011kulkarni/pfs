package com.pfs.erp.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table
@Entity
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "contents_id", referencedColumnName = "id")
    private Contents contents;


    @Temporal(TemporalType.DATE)
    private Date manufacturedOn;

    @Column
    @NotNull
    private Integer quantity;

    @Column
    @NotNull
    private Double weight;


    public Stock() {
    }


    public Stock(Product product, Date manufacturedOn, @NotNull Integer quantity, @NotNull Double weight) {
        this.product = product;
        this.manufacturedOn = manufacturedOn;
        this.quantity = quantity;
        this.weight = weight;
    }

    public Stock(Contents contents, Date manufacturedOn, @NotNull Integer quantity, @NotNull Double weight) {
        this.contents = contents;
        this.manufacturedOn = manufacturedOn;
        this.quantity = quantity;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getManufacturedOn() {
        return manufacturedOn;
    }

    public void setManufacturedOn(Date manufacturedOn) {
        this.manufacturedOn = manufacturedOn;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", product=" + product +
                ", contents=" + contents +
                ", manufacturedOn=" + manufacturedOn +
                ", quantity=" + quantity +
                ", weight=" + weight +
                '}';
    }
}
