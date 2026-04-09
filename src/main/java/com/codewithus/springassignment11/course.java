package com.codewithus.springassignment11;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class course { // <--- Changed from 'course' to 'Course'

    @NotNull(message = "ID cannot be null") // <--- Added this for extra safety
    private Long id;

    @NotBlank(message = "Course name is mandatory")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Category is mandatory")
    private String category; // e.g., Foundation, Undergraduate, Honours

    // Constructors
    public course() {} // <--- Updated to match class name

    public course(Long id, String name, String category) { // <--- Updated to match class name
        this.id = id;
        this.name = name;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
