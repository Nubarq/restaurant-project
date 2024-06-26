package com.alas.ms_admin.repository.restaurant;

import com.alas.ms_admin.model.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
