package com.pfs.erp.dto;

import java.util.Date;

public class PurchaseDTO {


    private String contentsName;
    private Double perUnitPrice;
    private Double purchasedUnits;
    private String purchasedFrom;
    private Date purchasedOn;


    public String getContentsName() {
        return contentsName;
    }

    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
    }

    public Double getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(Double perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
    }

    public Double getPurchasedUnits() {
        return purchasedUnits;
    }

    public void setPurchasedUnits(Double purchasedUnits) {
        this.purchasedUnits = purchasedUnits;
    }

    public String getPurchasedFrom() {
        return purchasedFrom;
    }

    public void setPurchasedFrom(String purchasedFrom) {
        this.purchasedFrom = purchasedFrom;
    }

    public Date getPurchasedOn() {
        return purchasedOn;
    }

    public void setPurchasedOn(Date purchasedOn) {
        this.purchasedOn = purchasedOn;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "contentsName='" + contentsName + '\'' +
                ", perUnitPrice=" + perUnitPrice +
                ", purchasedUnits=" + purchasedUnits +
                ", purchasedFrom='" + purchasedFrom + '\'' +
                ", purchasedOn=" + purchasedOn +
                '}';
    }
}
