package org.example;

public class Supermarket extends Store {
    private double storeArea;
    private String[] productCategories;

    // Default constructor
    public Supermarket() {
        super();
        this.storeArea = 0.0;
        this.productCategories = new String[0];
    }

    // Parameterized constructor
    public Supermarket(int numberOfRegisters, Product[] products, int numberOfSalespersons,
                       double storeArea, String[] productCategories) {
        super(numberOfRegisters, products, numberOfSalespersons);
        this.storeArea = storeArea;
        this.productCategories = productCategories;
    }

    // Getters and Setters
    public double getStoreArea() { return storeArea; }
    public void setStoreArea(double storeArea) { this.storeArea = storeArea; }

    public String[] getProductCategories() { return productCategories; }
    public void setProductCategories(String[] productCategories) {
        this.productCategories = productCategories;
    }

    // Override efficiency calculation
    @Override
    public double calculateEfficiency() {
        if (productCategories.length == 0) return 0;

        double registerEfficiency = calculateRegisterEfficiency();
        double areaEfficiency = storeArea / (productCategories.length * 100);

        // Combine both factors and normalize to ensure result is less than 1
        double efficiency = (areaEfficiency * registerEfficiency) / 2;
        return Math.min(efficiency, 0.99);
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "numberOfRegisters=" + numberOfRegisters +
                ", numberOfSalespersons=" + numberOfSalespersons +
                ", numberOfProducts=" + products.length +
                ", storeArea=" + storeArea +
                ", numberOfCategories=" + productCategories.length +
                ", efficiency=" + String.format("%.2f", calculateEfficiency()) +
                '}';
    }
}