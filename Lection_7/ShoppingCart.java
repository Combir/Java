package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ShoppingCart {
    static class Product {
        String name;
        double cost;
        double weight;

        Product(String name, double cost, double weight) {
            this.name = name;
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("Product{name='%s', cost=%.2f, weight=%.2f}", name, cost, weight);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Product product = (Product) obj;
            return name.equals(product.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    enum ProductName {
        LAPTOP, PHONE, TABLET, TV, HEADPHONES, WATCH, CAMERA, MONITOR;

        public static ProductName getRandomName() {
            ProductName[] values = ProductName.values();
            return values[new Random().nextInt(values.length)];
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Shopping Cart CLI!");
        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a random product to the cart");
            System.out.println("2. View cart");
            System.out.println("3. Remove products (weight > 5kg or cost > 10000)");
            System.out.println("4. Add your favorite product");
            System.out.println("5. View products with cost < 10 and weight > 2");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Product randomProduct = generateRandomProduct(random);
                    addProductToCart(cart, randomProduct);
                    System.out.println("Added product: " + randomProduct);
                    break;

                case 2:
                    if (cart.isEmpty()) {
                        System.out.println("The cart is empty.");
                    } else {
                        System.out.println("Cart contents:");
                        cart.forEach(System.out::println);
                    }
                    break;

                case 3:
                    cart.removeIf(product -> product.weight > 5 || product.cost > 10000);
                    System.out.println("Removed heavy or expensive products from the cart.");
                    break;

                case 4:
                    System.out.print("Enter the name of your favorite product: ");
                    String favoriteName = scanner.nextLine();
                    System.out.print("Enter the cost of your favorite product: ");
                    double favoriteCost = scanner.nextDouble();
                    System.out.print("Enter the weight of your favorite product: ");
                    double favoriteWeight = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Product favoriteProduct = new Product(favoriteName, favoriteCost, favoriteWeight);
                    cart.add(0, favoriteProduct);
                    System.out.println("Added your favorite product to the first position.");
                    break;

                case 5:
                    System.out.println("Products with cost < 10 and weight > 2:");
                    cart.stream()
                            .filter(product -> product.cost < 10 && product.weight > 2)
                            .forEach(System.out::println);
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting the Shopping Cart CLI. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static Product generateRandomProduct(Random random) {
        String randomName = ProductName.getRandomName().name();
        double randomCost = 500 + random.nextDouble() * 20000;
        double randomWeight = 1 + random.nextDouble() * 10;
        return new Product(randomName, randomCost, randomWeight);
    }

    private static void addProductToCart(ArrayList<Product> cart, Product product) {
        if (!cart.contains(product)) {
            cart.add(product);
        } else {
            System.out.println("Product is already in the cart: " + product.name);
        }
    }
}
