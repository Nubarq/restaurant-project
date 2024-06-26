package com.alas.ms_admin.model.ingredient;

import com.alas.ms_admin.model.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredients_seq")
    @SequenceGenerator(name = "ingredients_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    private List<Product> products;

    @Column(name ="active")
    private boolean active;

    public Ingredient(){this.active=true;}
}
