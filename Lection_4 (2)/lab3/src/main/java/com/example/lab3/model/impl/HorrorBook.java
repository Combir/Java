package com.example.lab3.model.impl;

import com.example.lab3.model.Figure;

public class HorrorBook extends AbstractBook {
    private int scareRating;
    private boolean containsSupernaturalElements;

    @Override
    public String getDescription() {
        return "A horror book titled '" + getTitle() + "' by " + getAuthor()
                + ". Scare rating: " + scareRating + "/10"
                + (containsSupernaturalElements ? ", Contains supernatural elements" : "")
                + ". Pages: " + getPages() + ", Published: " + getPublishDate();
    }

    @Override
    public String getCategory() {
        return "Horror";
    }

    @Override
    public void cleanup() {
        super.cleanup();
        System.out.println("Extra cleanup for horror book with scare rating: " + scareRating);
    }

    // Getters and setters
    public int getScareRating() {
        return scareRating;
    }

    public void setScareRating(int scareRating) {
        this.scareRating = scareRating;
    }

    public boolean isContainsSupernaturalElements() {
        return containsSupernaturalElements;
    }

    public void setContainsSupernaturalElements(boolean containsSupernaturalElements) {
        this.containsSupernaturalElements = containsSupernaturalElements;
    }
}