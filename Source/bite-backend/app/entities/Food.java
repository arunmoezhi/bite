package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Daniel on 6/27/2015.
 */
@Entity
public class Food {
    private int foodId;
    private int userId;
    private String title;
    private String description;
    private int cuisineId;
    private int foodTypeId;

    @Id
    @Column(name = "foodId", nullable = false, insertable = true, updatable = true)
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "userId", nullable = false, insertable = true, updatable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cuisineId", nullable = false, insertable = true, updatable = true)
    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    @Basic
    @Column(name = "foodTypeId", nullable = false, insertable = true, updatable = true)
    public int getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(int foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (cuisineId != food.cuisineId) return false;
        if (foodId != food.foodId) return false;
        if (foodTypeId != food.foodTypeId) return false;
        if (userId != food.userId) return false;
        if (description != null ? !description.equals(food.description) : food.description != null) return false;
        if (title != null ? !title.equals(food.title) : food.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = foodId;
        result = 31 * result + userId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + cuisineId;
        result = 31 * result + foodTypeId;
        return result;
    }
}
