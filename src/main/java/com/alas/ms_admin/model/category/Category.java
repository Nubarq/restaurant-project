package com.alas.ms_admin.model.category;

import com.alas.ms_admin.model.menu.Menu;
import com.alas.ms_admin.model.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "type")
    private String name;

    @Column(name ="active")
    private boolean active;

    public Category(){this.active=true;}

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> productList;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Menu> menuList;
}
