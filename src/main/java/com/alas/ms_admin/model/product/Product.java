package com.alas.ms_admin.model.product;

import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.model.ingredient.Ingredient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "products_ingredients",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")

    )
    private List<Ingredient> ingredients;

    @Column(name ="active")
    private boolean active;

    public Product(){this.active=true;}
}
