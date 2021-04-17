package com.pfs.erp.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class ProductContents {

    @Id
    private Long id;

    @Column
    private Product product;

    @Column
    private Contents contents;

    @Column
    private Double weight;


    public ProductContents() {
    }

    public ProductContents(Product product, Contents contents, Double weight) {
        this.product = product;
        this.contents = contents;
        this.weight = weight;
    }

    public ProductContents(Long id, Product product, Contents contents, Double weight) {
        this.id = id;
        this.product = product;
        this.contents = contents;
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

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
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
        if (!(o instanceof ProductContents)) return false;

        ProductContents that = (ProductContents) o;

        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return contents != null ? contents.equals(that.contents) : that.contents == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ProductContents{" +
                "id=" + id +
                ", product=" + product.getName() +
                ", contents=" + contents.getName() +
                ", weight=" + weight +
                '}';
    }
}

