package com.rainbowforest.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.constructionSite.ConstructionSiteAdress;

@Repository
@Transactional
public interface ConstructionSiteAdressRepository extends JpaRepository<ConstructionSiteAdress, Integer> {
	
	 @Modifying
	 @Query("UPDATE ConstructionSiteAdress ca SET  ca.street = :newStreet, ca.streetNumber = :newStreetNumber, ca.locality = :newLocality, ca.zipCode = :newZipCode, ca.country = :newCountry WHERE ca.id = :id")
	 public void updateConstructionSiteAdress(
			 @Param("newStreet") String newStreet,			  	
			 @Param("newStreetNumber") String newStreetNumber,
			 @Param("newLocality") String newLocality,
			 @Param("newZipCode") String newZipCode,
			 @Param("newCountry") String newCountry,
			 @Param("id") Integer id);
}
