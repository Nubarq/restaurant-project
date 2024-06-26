package com.alas.ms_admin.model.restaurant;

import com.alas.ms_admin.model.branch.Branch;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@Table(name = "restaurant")
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    @SequenceGenerator(name = "restaurant_seq", allocationSize = 1)
    @Column(name = "id", unique = true)
    private Integer id;


    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    //@JsonManagedReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Branch> BranchList;

    private boolean isActive;

    public Restaurant() {
        isActive = true;
    }
}
