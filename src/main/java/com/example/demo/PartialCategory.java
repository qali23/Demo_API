package com.example.demo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="category")
public class PartialCategory {
    @Id
    @Column(name="category_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;

    @Column(name = "name")
    private String name;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PartialCategory() {
    }

    public PartialCategory(int categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
    }
}
