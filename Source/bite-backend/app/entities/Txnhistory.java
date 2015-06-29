package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Daniel on 6/27/2015.
 */
@Entity
public class Txnhistory {
    private int txnId;
    private byte listId;
    private int cheffieId;
    private int foodieId;
    private Double amount;
    private Integer servings;
    private Timestamp startTime;
    private Timestamp confirmedTime;
    private Timestamp completedTime;
    private Timestamp pickedupTime;
    private String paymentRef;
    private String paymentType;
    private Timestamp paymentTime;

    @Id
    @Column(name = "txnId", nullable = false, insertable = true, updatable = true)
    public int getTxnId() {
        return txnId;
    }

    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }

    @Basic
    @Column(name = "listId", nullable = false, insertable = true, updatable = true)
    public byte getListId() {
        return listId;
    }

    public void setListId(byte listId) {
        this.listId = listId;
    }

    @Basic
    @Column(name = "cheffieId", nullable = false, insertable = true, updatable = true)
    public int getCheffieId() {
        return cheffieId;
    }

    public void setCheffieId(int cheffieId) {
        this.cheffieId = cheffieId;
    }

    @Basic
    @Column(name = "foodieId", nullable = false, insertable = true, updatable = true)
    public int getFoodieId() {
        return foodieId;
    }

    public void setFoodieId(int foodieId) {
        this.foodieId = foodieId;
    }

    @Basic
    @Column(name = "amount", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "servings", nullable = true, insertable = true, updatable = true)
    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    @Basic
    @Column(name = "startTime", nullable = false, insertable = true, updatable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "confirmedTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getConfirmedTime() {
        return confirmedTime;
    }

    public void setConfirmedTime(Timestamp confirmedTime) {
        this.confirmedTime = confirmedTime;
    }

    @Basic
    @Column(name = "completedTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(Timestamp completedTime) {
        this.completedTime = completedTime;
    }

    @Basic
    @Column(name = "pickedupTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getPickedupTime() {
        return pickedupTime;
    }

    public void setPickedupTime(Timestamp pickedupTime) {
        this.pickedupTime = pickedupTime;
    }

    @Basic
    @Column(name = "paymentRef", nullable = true, insertable = true, updatable = true, length = 500)
    public String getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

    @Basic
    @Column(name = "paymentType", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "paymentTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Txnhistory that = (Txnhistory) o;

        if (cheffieId != that.cheffieId) return false;
        if (foodieId != that.foodieId) return false;
        if (listId != that.listId) return false;
        if (txnId != that.txnId) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (completedTime != null ? !completedTime.equals(that.completedTime) : that.completedTime != null)
            return false;
        if (confirmedTime != null ? !confirmedTime.equals(that.confirmedTime) : that.confirmedTime != null)
            return false;
        if (paymentRef != null ? !paymentRef.equals(that.paymentRef) : that.paymentRef != null) return false;
        if (paymentTime != null ? !paymentTime.equals(that.paymentTime) : that.paymentTime != null) return false;
        if (paymentType != null ? !paymentType.equals(that.paymentType) : that.paymentType != null) return false;
        if (pickedupTime != null ? !pickedupTime.equals(that.pickedupTime) : that.pickedupTime != null) return false;
        if (servings != null ? !servings.equals(that.servings) : that.servings != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = txnId;
        result = 31 * result + (int) listId;
        result = 31 * result + cheffieId;
        result = 31 * result + foodieId;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (servings != null ? servings.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (confirmedTime != null ? confirmedTime.hashCode() : 0);
        result = 31 * result + (completedTime != null ? completedTime.hashCode() : 0);
        result = 31 * result + (pickedupTime != null ? pickedupTime.hashCode() : 0);
        result = 31 * result + (paymentRef != null ? paymentRef.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        return result;
    }
}
