package com.pfs.erp.domain;

import javax.persistence.Basic;
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
public class Purchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contents_id",referencedColumnName = "id")
    @NotNull
    private Contents contents;

    @Column
    @NotNull
    private Double perUnitPrice;

    @Column
    @NotNull
    private Double purchasedUnits;

    @Column
    private String purchasedFrom;



    @Basic
    @Temporal(value = TemporalType.DATE)
    private Date purchasedOn;


    public Purchase() {
    }


    public Purchase(@NotNull Contents contents, @NotNull Double perUnitPrice, @NotNull Double purchasedUnits, String purchasedFrom, Date purchasedOn) {
        this.contents = contents;
        this.perUnitPrice = perUnitPrice;
        this.purchasedUnits = purchasedUnits;
        this.purchasedFrom = purchasedFrom;
        this.purchasedOn = purchasedOn;
    }


    public Long getId() {
        return id;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;

        if (!id.equals(purchase.id)) return false;
        if (!contents.equals(purchase.contents)) return false;
        if (!perUnitPrice.equals(purchase.perUnitPrice)) return false;
        if (!purchasedUnits.equals(purchase.purchasedUnits)) return false;
        if (purchasedFrom != null ? !purchasedFrom.equals(purchase.purchasedFrom) : purchase.purchasedFrom != null)
            return false;
        return purchasedOn != null ? purchasedOn.equals(purchase.purchasedOn) : purchase.purchasedOn == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + contents.hashCode();
        result = 31 * result + perUnitPrice.hashCode();
        result = 31 * result + purchasedUnits.hashCode();
        result = 31 * result + (purchasedFrom != null ? purchasedFrom.hashCode() : 0);
        result = 31 * result + (purchasedOn != null ? purchasedOn.hashCode() : 0);
        return result;
    }
}
