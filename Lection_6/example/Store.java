package org.example;

public class Store {
    protected int numberOfRegisters;
    protected Product[] products;
    protected int numberOfSalespersons;

    // Nested Product class
    public static class Product {
        private double weight;
        private double price;
        private String name;
        private String id;

        // Default constructor
        public Product() {
            this.weight = 0.0;
            this.price = 0.0;
            this.name = "";
            this.id = "";
        }

        // Parameterized constructor
        public Product(double weight, double price, String name, String id) {
            this.weight = weight;
            this.price = price;
            this.name = name;
            this.id = id;
        }

        // Getters and Setters
        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }

    // Default constructor
    public Store() {
        this.numberOfRegisters = 0;
        this.products = new Product[0];
        this.numberOfSalespersons = 0;
    }

    // Parameterized constructor
    public Store(int numberOfRegisters, Product[] products, int numberOfSalespersons) {
        this.numberOfRegisters = numberOfRegisters;
        this.products = products;
        this.numberOfSalespersons = numberOfSalespersons;
    }

    // Getters and Setters
    public int getNumberOfRegisters() { return numberOfRegisters; }
    public void setNumberOfRegisters(int numberOfRegisters) {
        this.numberOfRegisters = numberOfRegisters;
    }

    public Product[] getProducts() { return products; }
    public void setProducts(Product[] products) { this.products = products; }

    public int getNumberOfSalespersons() { return numberOfSalespersons; }
    public void setNumberOfSalespersons(int numberOfSalespersons) {
        this.numberOfSalespersons = numberOfSalespersons;
    }

    // Calculate register efficiency
    protected double calculateRegisterEfficiency() {
        if (numberOfRegisters == 0) return 0;
        return (double) numberOfSalespersons / numberOfRegisters;
    }

    // Calculate average product weight
    protected double calculateAverageProductWeight() {
        if (products.length == 0) return 0;

        double totalWeight = 0;
        for (Product product : products) {
            totalWeight += product.getWeight();
        }
        return totalWeight / products.length;
    }

    // Calculate overall efficiency
    public double calculateEfficiency() {
        double registerEfficiency = calculateRegisterEfficiency();
        double avgWeight = calculateAverageProductWeight();

        if (registerEfficiency == 0) return 0;

        // Normalize the result to ensure it's less than 1
        double efficiency = avgWeight / (registerEfficiency * 100);
        return Math.min(efficiency, 0.99);
    }

    @Override
    public String toString() {
        return "Store{" +
                "numberOfRegisters=" + numberOfRegisters +
                ", numberOfSalespersons=" + numberOfSalespersons +
                ", numberOfProducts=" + products.length +
                ", efficiency=" + String.format("%.2f", calculateEfficiency()) +
                '}';
    }
}