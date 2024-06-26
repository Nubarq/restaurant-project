package com.alas.ms_admin.model.branch;

import com.alas.ms_admin.model.menu.Menu;
import com.alas.ms_admin.model.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_seq")
    @SequenceGenerator(name = "branch_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    //@JsonBackReference

    //@JsonIgnoreProperties("branches")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private boolean active;

    public Branch() {
        active = true;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "branch")
    private Menu menu;
}
