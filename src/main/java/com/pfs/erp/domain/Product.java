package com.pfs.erp.domain;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Product {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Double basePrice;

    @Column
    private Double sellPrice;

    @Column
    private Double manufacturingCost;

    @Column
    private Double weight;

    public Product() {
    }

    public Product(String name, Double basePrice, Double sellPrice,Double weight,Double manufacturingCost) {
        this.name = name;
        this.basePrice = basePrice;
        this.sellPrice = sellPrice;
        this.weight = weight;
        this.manufacturingCost = manufacturingCost;
    }

    public Product(Long id, String name, Double basePrice, Double sellPrice, Double weight,Double manufacturingCost) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.sellPrice = sellPrice;
        this.weight = weight;
        this.manufacturingCost = manufacturingCost;
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

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getManufacturingCost() {
        return manufacturingCost;
    }

    public void setManufacturingCost(Double manufacturingCost) {
        this.manufacturingCost = manufacturingCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", sellPrice=" + sellPrice +
                ", weight=" + weight +
                '}';
    }
}
