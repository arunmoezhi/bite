package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Daniel on 6/27/2015.
 */
@Entity
public class Cuisine {
    private int cuisineId;
    private String cuisineType;

    @Id
    @Column(name = "cuisineId", nullable = false, insertable = true, updatable = true)
    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    @Basic
    @Column(name = "cuisineType", nullable = false, insertable = true, updatable = true, length = 150)
    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cuisine cuisine = (Cuisine) o;

        if (cuisineId != cuisine.cuisineId) return false;
        if (cuisineType != null ? !cuisineType.equals(cuisine.cuisineType) : cuisine.cuisineType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cuisineId;
        result = 31 * result + (cuisineType != null ? cuisineType.hashCode() : 0);
        return result;
    }
}
