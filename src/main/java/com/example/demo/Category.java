package com.example.demo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="category_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;

    @JsonIgnore
    @ManyToMany(mappedBy = "categoriesOfFilm")
    Set<Film> filmsForCategory;

    @Column(name = "name")
    private String name;

    public Set<Film> getFilmsForCategory() {
        return filmsForCategory;
    }

    public void setFilmsForCategory(Set<Film> filmsForCategory) {
        this.filmsForCategory = filmsForCategory;
    }

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

    public Category() {
    }

    public Category(int categoryID, Set<Film> filmsForCategory, String name) {
        this.categoryID = categoryID;
        this.filmsForCategory = filmsForCategory;
        this.name = name;
    }
}
