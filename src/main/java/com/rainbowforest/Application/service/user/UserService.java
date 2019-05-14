package com.rainbowforest.Application.service.user;

import java.util.List;
import com.rainbowforest.Application.model.user.UserAccount;
import com.rainbowforest.Application.model.user.UserAccountDetails;

public interface UserService {
	
	/**
	 * Returns the current list of all users account details
	 * 
	 * @return list of objects of type UsersAccountDetails
	 */
	public List<UserAccountDetails> findAllUsers();
	
	/**
	 * Returns the current list of all users account
	 * 
	 * @return list of objects of type UsersAccount
	 */
	public List<UserAccount> findAllAccount();
	
	/**
	 * Adds a single user account
	 * 
	 * @param user, an object of type UserAccount to add
	 */
	public void addUser(UserAccount user);
	
	
	/**
	 * Finds a user account for the given user name
	 * 
	 * @param userName, name of the searched user account
	 * @return  user's account by user name
	 */
	public UserAccount findOneByUserName(String userName);
	
	/**
	 * Deletes the user's account and user's details based on its identifier
	 * 
	 * @param id, user's details id
	 */
	public void deleteUser(int id);
	
	/**
	 * Finds a user's details for the given user's details id
	 * 
	 * @param id, user's details id
	 * @return user's details
	 */
	public UserAccountDetails findOneById(int id);
	
	/**
	 * Finds a user's account for the given user's account id
	 * 
	 * @param id, user's account id
	 * @return an object of type UserAccount
	 */
	public UserAccount findOneAccountById(int id);
	
	/**
	 * Returns the user account currently logged in
	 * 
	 * @param userName, name of the searched user's account details
	 * @return an object of type UserAccountDetails
	 */
	public UserAccountDetails getLoggedUser(String userName);
	
	/**
	 * Updates the user's password based on the entered new password and user ID
	 * 
	 * @param newPassword
	 * @param id, user's account details id
	 */
	public void updatePassword(String newPassword, int id);
	
	/**
	 * Adds a single user account details
	 * 
	 * @param userDetails, an object of type UserAccountDetails
	 */
	public void addUserDetails(UserAccountDetails userDetails);
	
	/**
	 * Updates the user account information based on user account details ID
	 * 
	 * @param newFirstName
	 * @param newLastName
	 * @param newEmail
	 * @param newPhoneNumber
	 * @param newPosition
	 * @param newConstructionSitesId
	 * @param id, user account details ID
	 */
	public void updateUserDetails(
			String newFirstName,
			String newLastName,
			String newEmail,
			String newPhoneNumber,
			String newPosition,
			Integer newConstructionSitesId,
			Integer id);

	/**
	 * Updates the user account security data based on user account id
	 * 
	 * @param newUserPassword
	 * @param newUserEnabled
	 * @param newRoleId
	 * @param id, user account id
	 */
	public void securityUpdate(
			String newUserPassword, 
			Integer newUserEnabled, 
			Integer newRoleId, 
			Integer id);
}
