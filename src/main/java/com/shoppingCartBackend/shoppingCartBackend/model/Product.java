package com.shoppingCartBackend.shoppingCartBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // This class represents a table in the database
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;

    private BigDecimal price;
    private int inventory; //Stock quantity
    private String description;

    //Many products can belong to one Category
    @ManyToOne(cascade = CascadeType.ALL) //Many products to one category,
    // cascadeTypeAll==relationship goes away when product is deleted but the category is not deleted


    @JoinColumn(name = "category_id") //this creates the foreign key in the product table.
    private Category category;

    // One product can have many images
    //If a product is deleted, its associated images are deleted too (orphanRemoval = true).
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;


}
