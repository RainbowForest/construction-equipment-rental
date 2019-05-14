package com.rainbowforest.Application.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.rainbowforest.Application.model.user.UserAccount;
import com.rainbowforest.Application.repository.UserAccountDetailsRepository;
import com.rainbowforest.Application.repository.UserAccountRepository;
import com.rainbowforest.Application.service.user.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Mock
	private UserAccountRepository userAccountRepository;
	
	@Mock
	private UserAccountDetailsRepository userAccountDetailsRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl ;
	
	@Before
	public void setUserName() {
		UserAccount user = new UserAccount();
		user.setUserName("test");
		Mockito.when(userAccountRepository.findOneByUserName(user.getUserName())).thenReturn(user);
	}
	
	@Test
	public void find_One_By_User_Name() {
		String name = "test";
		UserAccount foundUser = userServiceImpl.findOneByUserName(name);
		assertThat(foundUser.getUserName()).isEqualTo(name);
		
	}
	
	@Before
	public void createUserAccountList() {
		List<UserAccount> userAccountList = new ArrayList<UserAccount>();
		UserAccount user01 = new UserAccount();
		UserAccount user02 = new UserAccount();
		user01.setUserName("test01");
		user02.setUserName("test02");
		userAccountList.add(user01);
		userAccountList.add(user02);
		Mockito.when(userAccountRepository.findAll()).thenReturn(userAccountList);
	}
	
	@Test
	public void find_All_Account() {
		String userName01 = "test01";
		String userName02 = "test02";
		List<UserAccount> foundAccountList = userServiceImpl.findAllAccount();
		
		assertThat(foundAccountList.get(0).getUserName()).isEqualTo(userName01);
		assertThat(foundAccountList.get(1).getUserName()).isEqualTo(userName02);

	}
	
	@Before
	public void setUserAccountId(){
		UserAccount userAccount = new UserAccount();
		userAccount.setId(1);
		Mockito.when(userAccountRepository.getOne(userAccount.getId())).thenReturn(userAccount);
	}
	
	@Test
	public void find_One_Account_By_Id() {
		int id = 1;
		UserAccount foundUserAccound = userServiceImpl.findOneAccountById(id);
		assertThat(foundUserAccound.getId()).isEqualTo(id);
	}
	
	
}
