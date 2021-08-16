package com.ros.inventory.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ros.inventory.entities.SupplierBasicInfo;

@Repository
public interface SupplierBasicRepository extends JpaRepository<SupplierBasicInfo , UUID>
{
//	@Query(value="SELECT * FROM supplier_basic_info s LEFT JOIN supplier sp on  s.supplier_info_id =sp.supplierbasic_id "
//			+ " WHERE sp.supplier_id =:supplier_id",nativeQuery=true)
//	  SupplierBasicInfo getById(@Param("supplier_id") long Id);
//	  
//	@Query(value="SELECT image FROM supplier_basic_info s LEFT JOIN supplier sp on  s.supplier_info_id =sp.supplierbasic_id"
//			+ " WHERE sp.supplier_id =:supplier_id",nativeQuery=true)
//	  String getImage(@Param("supplier_id") long Id);
//	
}
