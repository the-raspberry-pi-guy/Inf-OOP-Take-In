import java.util.Objects;

/**
 * Encapsulates information regarding a single 
 * car item in a sales catalog.
 */
public class CarItem {

    private final String brand;
    private final String model;
    protected final double price;

    /** indicates how often toString was called */
    private int toStringCount;

    /**
     * Create a new CarItem.
     * @param brand the Brand of the car, e.g. VW, Ford, etc.
     * @param model the Model of the car, e.g. Polo, Fiesta, etc.
     * @param price the price for the car
     */
    public CarItem(String brand, String model, double price) {
        Objects.requireNonNull(brand);
        Objects.requireNonNull(model);
        if (price <= 0) 
            throw new IllegalArgumentException("Given price must be larger than zero.");

        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    /**
     * Return the brand of this car item.
     * @return brand of the car item.
     */
    public String getBrand() { return brand; }

    /**
     * Return the model of this car item.
     * @return model of the car item.
     */
    public String getModel() { return model; }

    /**
     * Return the price of this car item.
     * @return price of the car item.
     */
    public double getPrice() { return price; }

    /**
     * Returns a human readable representation of this
     * car item's state
     * @return human readable representation of this car item's state.
     */
    @Override
    public String toString() {
        String result = String.format("%s %s - %.2f GBP", brand, model, price);
        toStringCount++;
        return result;
    }

}