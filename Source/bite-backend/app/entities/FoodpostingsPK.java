package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Daniel on 6/27/2015.
 */
public class FoodpostingsPK implements Serializable {
    private int postId;
    private int foodId;

    @Column(name = "postId", nullable = false, insertable = true, updatable = true)
    @Id
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Column(name = "foodId", nullable = false, insertable = true, updatable = true)
    @Id
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodpostingsPK that = (FoodpostingsPK) o;

        if (foodId != that.foodId) return false;
        if (postId != that.postId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + foodId;
        return result;
    }
}
