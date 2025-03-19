package com.example.lab3;

import com.example.lab3.config.AppConfig;
import com.example.lab3.display.BookIndicator;
import com.example.lab3.model.Figure;
import com.example.lab3.model.impl.ScienceFictionBook;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab3Application {
    public static void main(String[] args) {
        // Load the Spring configuration using annotations
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the BookIndicator bean
        BookIndicator bookIndicator = context.getBean(BookIndicator.class);

        // Display the book details
        bookIndicator.displayBook();

        // Display science fiction book details
        bookIndicator.displaySciFiBook();

        // Display all available books
        bookIndicator.displayAllBooks();

        // Get a prototype bean twice to demonstrate scope
        ScienceFictionBook sciFi1 = context.getBean("scienceFictionBook", ScienceFictionBook.class);
        ScienceFictionBook sciFi2 = context.getBean("scienceFictionBook", ScienceFictionBook.class);

        System.out.println("Are prototype beans the same instance? " + (sciFi1 == sciFi2));

        // Get a singleton bean twice to demonstrate scope
        BookIndicator indicator1 = context.getBean(BookIndicator.class);
        BookIndicator indicator2 = context.getBean(BookIndicator.class);

        System.out.println("Are singleton beans the same instance? " + (indicator1 == indicator2));

        // Close the application context
        context.close();
    }
}