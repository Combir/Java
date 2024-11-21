package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreCLI {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store;
    private static ArrayList<Store.Product> products = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Store Management System");

        while (true) {
            printMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    createStore();
                    break;
                case 2:
                    createSupermarket();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    if (store != null) {
                        System.out.println(store.toString());
                        System.out.println("Store Efficiency: " +
                                String.format("%.2f", store.calculateEfficiency()));
                    } else {
                        System.out.println("Please create a store first!");
                    }
                    break;
                case 5:
                    listProducts();
                    break;
                case 0:
                    System.out.println("Thank you for using Store Management System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Create Regular Store");
        System.out.println("2. Create Supermarket");
        System.out.println("3. Add Product");
        System.out.println("4. Display Store Information");
        System.out.println("5. List All Products");
        System.out.println("0. Exit");
    }

    private static void createStore() {
        System.out.println("\n=== Creating Regular Store ===");
        int registers = getIntInput("Enter number of registers: ");
        int salespersons = getIntInput("Enter number of salespersons: ");

        store = new Store(registers,
                products.toArray(new Store.Product[0]),
                salespersons);

        System.out.println("Store created successfully!");
    }

    private static void createSupermarket() {
        System.out.println("\n=== Creating Supermarket ===");
        int registers = getIntInput("Enter number of registers: ");
        int salespersons = getIntInput("Enter number of salespersons: ");
        double area = getDoubleInput("Enter store area (in square meters): ");

        System.out.println("Enter product categories (comma-separated): ");
        String categoriesInput = scanner.nextLine();
        String[] categories = categoriesInput.split(",");
        // Trim whitespace from categories
        for (int i = 0; i < categories.length; i++) {
            categories[i] = categories[i].trim();
        }

        store = new Supermarket(registers,
                products.toArray(new Store.Product[0]),
                salespersons,
                area,
                categories);

        System.out.println("Supermarket created successfully!");
    }

    private static void addProduct() {
        System.out.println("\n=== Adding New Product ===");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();

        double weight = getDoubleInput("Enter product weight: ");
        double price = getDoubleInput("Enter product price: ");

        Store.Product product = new Store.Product(weight, price, name, id);
        products.add(product);

        // Update store's product list if store exists
        if (store != null) {
            store.setProducts(products.toArray(new Store.Product[0]));
        }

        System.out.println("Product added successfully!");
    }

    private static void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n=== Product List ===");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).toString());
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}