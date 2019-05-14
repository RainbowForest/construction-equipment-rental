package com.rainbowforest.Application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;

@Repository
@Transactional
public interface ConstructionSiteRepository extends JpaRepository<ConstructionSite, Integer> {

	
	@Modifying
	@Query("UPDATE ConstructionSite cs SET cs.buildingName = :newBuildingName, cs.buildingCode = :newBuildingCode, cs.status = :newStatus WHERE cs.id = :id")
	public void updateConstructionSite(
			 @Param("newBuildingName") String newBuildingName,
			 @Param("newBuildingCode") String newBuildingCode,
			 @Param("newStatus") Integer newStatus,
			 @Param("id") Integer id);
	
	@Query("SELECT cs FROM ConstructionSite cs INNER JOIN UserAccountDetails ua ON cs.id = ua.id WHERE ua.userAccount.userName = :userName")
	public List<ConstructionSite> getAllConstructionSiteByUserName(@Param("userName") String userName);
}