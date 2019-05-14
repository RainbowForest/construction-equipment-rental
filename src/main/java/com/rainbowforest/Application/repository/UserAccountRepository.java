package com.rainbowforest.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowforest.Application.model.user.UserAccount;

@Repository
@Transactional
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
	public UserAccount findOneByUserName(String userName);
	
	@Modifying
	@Query("UPDATE UserAccount ua "
			+ "SET "
			+ "ua.userPassword = :newUserPassword, "
			+ "ua.userEnabled = :newUserEnabled, "
			+ "ua.role.id = :newRoleId "
			+ "WHERE ua.id = :id")
	public void securityUpdate(
			@Param("newUserPassword") String newUserPassword, 
			@Param("newUserEnabled") Integer newUserEnabled, 
			@Param("newRoleId") Integer newRoleId, 
			@Param("id") Integer id);	
}
