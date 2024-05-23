package edu.studying.mockito.presentation.c.stubvoidmethods;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car {

    private String brandName;
    private String modelName;
    private int power;
    private double price;
    private Condition condition;

    @Setter(lombok.AccessLevel.NONE)
    private Category category;

    public Car(String brandName, String modelName, int power) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.power = power;
    }

    // method under test
    // method assigns a category to Car object based on the power figure
    public void assignCategory() throws Exception {
        // path a -> throws exception when age is less than 50
        if (this.getPower() < 50) {
            throw new Exception("Car will not even move, check the power figure");
        }

        if (this.getPower() < 300) {
            // path b -> assigns "Regular" if power figure is under 300
            this.category = Category.REGULAR;
        } else if (this.getPower() < 600) {
            // path c -> assigns "Sport" if power is between 300 and 599
            this.category = Category.SPORT;
        } else {
            // path d -> assigns "Hypercar" if power is 600 and over
            this.category = Category.HYPERCAR;
        }
    }

    public void assignDefaultPriceAndCondition() {
        this.price = 12000;
        this.condition = Condition.NEW;
    }

    public enum Condition {
        NEW,
        USED
    }

    public enum Category {
        REGULAR,
        SPORT,
        HYPERCAR
    }
}
