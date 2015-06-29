package entities;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Daniel on 6/27/2015.
 */
@Entity
@IdClass(FoodpostingsPK.class)
public class Foodpostings {
    private int postId;
    private int foodId;
    private double price;
    private Time readyBy;
    private byte makeOnDemand;
    private int deliveryType;
    private Integer servings;
    private byte isOpen;
    private Timestamp postTimeStamp;

    @Id
    @Column(name = "postId", nullable = false, insertable = true, updatable = true)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Id
    @Column(name = "foodId", nullable = false, insertable = true, updatable = true)
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "readyBy", nullable = true, insertable = true, updatable = true)
    public Time getReadyBy() {
        return readyBy;
    }

    public void setReadyBy(Time readyBy) {
        this.readyBy = readyBy;
    }

    @Basic
    @Column(name = "makeOnDemand", nullable = false, insertable = true, updatable = true)
    public byte getMakeOnDemand() {
        return makeOnDemand;
    }

    public void setMakeOnDemand(byte makeOnDemand) {
        this.makeOnDemand = makeOnDemand;
    }

    @Basic
    @Column(name = "deliveryType", nullable = false, insertable = true, updatable = true)
    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
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
    @Column(name = "isOpen", nullable = false, insertable = true, updatable = true)
    public byte getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(byte isOpen) {
        this.isOpen = isOpen;
    }

    @Basic
    @Column(name = "postTimeStamp", nullable = false, insertable = true, updatable = true)
    public Timestamp getPostTimeStamp() {
        return postTimeStamp;
    }

    public void setPostTimeStamp(Timestamp postTimeStamp) {
        this.postTimeStamp = postTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foodpostings that = (Foodpostings) o;

        if (deliveryType != that.deliveryType) return false;
        if (foodId != that.foodId) return false;
        if (isOpen != that.isOpen) return false;
        if (makeOnDemand != that.makeOnDemand) return false;
        if (postId != that.postId) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (postTimeStamp != null ? !postTimeStamp.equals(that.postTimeStamp) : that.postTimeStamp != null)
            return false;
        if (readyBy != null ? !readyBy.equals(that.readyBy) : that.readyBy != null) return false;
        if (servings != null ? !servings.equals(that.servings) : that.servings != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = postId;
        result = 31 * result + foodId;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (readyBy != null ? readyBy.hashCode() : 0);
        result = 31 * result + (int) makeOnDemand;
        result = 31 * result + deliveryType;
        result = 31 * result + (servings != null ? servings.hashCode() : 0);
        result = 31 * result + (int) isOpen;
        result = 31 * result + (postTimeStamp != null ? postTimeStamp.hashCode() : 0);
        return result;
    }
}
