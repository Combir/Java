package com.example.lab3.model;

import java.util.List;

public interface Figure {
    String getDescription();
    String getCategory();
    List<String> getTags();
    void setTags(List<String> tags);
    boolean isAvailable();
    void setAvailable(boolean available);
}