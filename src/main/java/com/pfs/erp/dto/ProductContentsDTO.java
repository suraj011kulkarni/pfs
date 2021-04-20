package com.pfs.erp.dto;

import javax.validation.constraints.NotNull;

public class ProductContentsDTO {

    private Long id;

    @NotNull(message = "product name should not be null")
    private String productName;

    @NotNull(message = "content name should not be null")
    private String contentsName;

    @NotNull(message = "weight should not be null")
    private Double weight;

    public ProductContentsDTO() {
    }

    public ProductContentsDTO(String productName, String contentsName, Double weight) {
        this.productName = productName;
        this.contentsName = contentsName;
        this.weight = weight;
    }

    public ProductContentsDTO(Long id, String productName, String contentsName, Double weight) {
        this.id = id;
        this.productName = productName;
        this.contentsName = contentsName;
        this.weight = weight;
    }


    public ProductContentsDTO(String productName, String contentsName) {
        this.productName = productName;
        this.contentsName = contentsName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
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
        if (!(o instanceof ProductContentsDTO)) return false;

        ProductContentsDTO that = (ProductContentsDTO) o;

        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        return contentsName != null ? contentsName.equals(that.contentsName) : that.contentsName == null;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (contentsName != null ? contentsName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ProductContentsDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", contentsName='" + contentsName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
