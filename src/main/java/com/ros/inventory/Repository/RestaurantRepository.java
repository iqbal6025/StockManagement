package com.ros.inventory.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ros.inventory.entities.Invoice;
import com.ros.inventory.entities.Restaurant;

@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant, UUID>{
	

	@Query(value = "SELECT * FROM restaurant r LEFT JOIN purchase_order p on r.restaurant_id=p.restaurant_fk WHERE p.purchase_id=:purchase_id", nativeQuery = true)
	Restaurant getById(@Param("purchase_id") UUID Id);
}
