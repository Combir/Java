package com.example.lab3.model.impl;

import com.example.lab3.model.Figure;

public class StoryBook extends AbstractBook {
    private String ageGroup;

    @Override
    public String getDescription() {
        return "A story book titled '" + getTitle() + "' by " + getAuthor()
                + ", suitable for " + ageGroup + " readers. Pages: " + getPages()
                + ", Published: " + getPublishDate();
    }

    @Override
    public String getCategory() {
        return "Story";
    }

    // Custom initialization
    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Story book initialized with age group: " + ageGroup);
    }

    // Getters and setters
    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
