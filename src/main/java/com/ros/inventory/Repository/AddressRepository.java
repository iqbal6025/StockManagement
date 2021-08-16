package com.ros.inventory.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ros.inventory.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address ,UUID>
{
//	@Query(value="SELECT * FROM address a LEFT JOIN supplier sp on  a.address_id =sp.supplieraddress_id "
//			+ " WHERE sp.supplier_id =:supplier_id",nativeQuery=true)
//	  Address getByAddress(@Param("supplier_id") long Id);
//	
}
