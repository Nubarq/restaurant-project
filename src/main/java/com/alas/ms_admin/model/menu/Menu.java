package com.alas.ms_admin.model.menu;

import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.model.branch.Branch;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    @SequenceGenerator(name = "menu_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;


    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToMany
    @JoinTable(
            name = "menus_categories",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")

    )
    private List<Category> categories;

    @Column(name ="active")
    private boolean active;

    public Menu(){this.active=true;}
}
