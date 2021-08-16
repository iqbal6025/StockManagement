package com.ros.inventory.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ros.inventory.entities.Invoice;
import com.ros.inventory.entities.OpeningStock;

@Repository
public interface OpeningStockRepository extends JpaRepository<OpeningStock, Long>{

	@Query(value="select * from opening_stock where product_code =:product_code and product_name =:product_name",nativeQuery=true)
	public OpeningStock getData(@Param("product_code") Long product_code,@Param("product_name") String product_name);

}
