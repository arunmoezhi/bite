package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Daniel on 6/27/2015.
 */
@Entity
public class Foodtype {
    private int foodTypeId;
    private String foodType;

    @Id
    @Column(name = "foodTypeId", nullable = false, insertable = true, updatable = true)
    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    @Basic
    @Column(name = "foodType", nullable = false, insertable = true, updatable = true, length = 150)
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foodtype foodtype = (Foodtype) o;

        if (foodTypeId != foodtype.foodTypeId) return false;
        if (foodType != null ? !foodType.equals(foodtype.foodType) : foodtype.foodType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = foodTypeId;
        result = 31 * result + (foodType != null ? foodType.hashCode() : 0);
        return result;
    }
}
