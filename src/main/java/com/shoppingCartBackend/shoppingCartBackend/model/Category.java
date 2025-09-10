package com.shoppingCartBackend.shoppingCartBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //Marks this class as a database table (Category)
public class Category {
    @Id //ID will be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //One category can have many products
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
