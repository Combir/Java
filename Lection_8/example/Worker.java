package org.example;

public interface Worker {
    default void work() {
        System.out.println("Working...");
    }

    void uniqueTask();
}
