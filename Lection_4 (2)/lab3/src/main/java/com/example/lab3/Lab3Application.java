package com.example.lab3;

import com.example.lab3.display.BookIndicator;
import com.example.lab3.model.Figure;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab3Application {
    public static void main(String[] args) {
        // Load the Spring XML configuration
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookIndicator bean
        BookIndicator bookIndicator = context.getBean("bookIndicator", BookIndicator.class);

        // Display the book details
        bookIndicator.displayBook();

        // Display all available books
        bookIndicator.displayAllBooks();

        // Get a prototype bean twice to demonstrate scope
        Figure sciFi1 = context.getBean("scienceFictionBook", Figure.class);
        Figure sciFi2 = context.getBean("scienceFictionBook", Figure.class);

        System.out.println("Are prototype beans the same instance? " + (sciFi1 == sciFi2));

        // Get a singleton bean twice to demonstrate scope
        BookIndicator indicator1 = context.getBean("bookIndicator", BookIndicator.class);
        BookIndicator indicator2 = context.getBean("bookIndicator", BookIndicator.class);

        System.out.println("Are singleton beans the same instance? " + (indicator1 == indicator2));

        // Close the application context
        context.close();
    }
}