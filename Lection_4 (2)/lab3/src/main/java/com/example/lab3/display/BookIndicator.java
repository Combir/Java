package com.example.lab3.display;

import com.example.lab3.model.Figure;

import java.util.HashMap;
import java.util.Map;

public class BookIndicator {
    private Figure book;
    private String displayName;
    private Map<String, Figure> availableBooks = new HashMap<>();

    // Init method
    public void setup() {
        System.out.println("Setting up BookIndicator with display name: " + displayName);
        System.out.println("Number of available books: " + availableBooks.size());
    }

    // Destroy method
    public void teardown() {
        System.out.println("Tearing down BookIndicator");
        availableBooks.clear();
    }

    public void displayBook() {
        System.out.println("-----------------------------------");
        System.out.println("Display Name: " + displayName);
        System.out.println("Book Category: " + book.getCategory());
        System.out.println("Description: " + book.getDescription());
        System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
        System.out.println("Tags: " + String.join(", ", book.getTags()));
        System.out.println("-----------------------------------");
    }

    public void displayAllBooks() {
        System.out.println("===== Available Books =====");
        for (Map.Entry<String, Figure> entry : availableBooks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        }
        System.out.println("==========================");
    }

    // Getters and setters
    public Figure getBook() {
        return book;
    }

    public void setBook(Figure book) {
        this.book = book;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Map<String, Figure> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(Map<String, Figure> availableBooks) {
        this.availableBooks = availableBooks;
    }
}