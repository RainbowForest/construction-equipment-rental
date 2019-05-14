package com.rainbowforest.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.user.UserAccountDetails;

@Repository
@Transactional
public interface UserAccountDetailsRepository extends JpaRepository<UserAccountDetails, Integer> {

	@Modifying
	@Query("UPDATE UserAccountDetails ud "
			+ "SET "
			+ "ud.firstName = :newFirstName, "
			+ "ud.lastName = :newLastName, "
			+ "ud.email = :newEmail, "
			+ "ud.phoneNumber = :newPhoneNumber, "
			+ "ud.position = :newPosition, "
			+ "ud.constructionSites.id = :newConstructionSitesId "
			+ "WHERE ud.id = :id")
	public void updateUserDetails(
			@Param("newFirstName") String newFirstName,
			@Param("newLastName") String newLastName,
			@Param("newEmail") String newEmail,
			@Param("newPhoneNumber") String newPhoneNumber,
			@Param("newPosition") String newPosition,
			@Param("newConstructionSitesId") Integer newConstructionSitesId,
			@Param("id") Integer id);
	
	@Query("SELECT ud FROM UserAccountDetails ud WHERE ud.userAccount.userName = :userName")
	public UserAccountDetails getLoggedUser(@Param("userName") String userName);

	@Modifying
	@Query("UPDATE UserAccountDetails ud SET ud.userAccount.userPassword = :newPassword WHERE ud.id = :id")
	public void updatePassword(@Param("newPassword") String newPassword, @Param("id") int id);
}
