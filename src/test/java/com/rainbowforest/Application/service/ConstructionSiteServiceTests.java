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

import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.repository.ConstructionSiteRepository;
import com.rainbowforest.Application.service.constructionsite.ConstructionSiteServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ConstructionSiteServiceTests {

	@Mock
	private ConstructionSiteRepository constructionSiteRepository;
	
	@InjectMocks
	private ConstructionSiteServiceImpl constructionSiteServiceImpl;
	
	@Before
	public void createConstructionSiteList() {
		List<ConstructionSite> csList = new ArrayList<ConstructionSite>();
		ConstructionSite cs01 = new ConstructionSite();
		ConstructionSite cs02 = new ConstructionSite();
		cs01.setBuildingName("test01");
		cs02.setBuildingName("test02");
		csList.add(cs01);
		csList.add(cs02);
		
		Mockito.when(constructionSiteRepository.findAll()).thenReturn(csList);
	}
	
	@Test
	public void find_All_Construction_Site() {
		
		List<ConstructionSite> foundCsList = constructionSiteServiceImpl.findAllConstructionSite();
		
		assertThat(foundCsList.get(0).getBuildingName()).isEqualTo("test01");
		assertThat(foundCsList.get(1).getBuildingName()).isEqualTo("test02");
		
	}
	
	@Before
	public void setCsId() {
		ConstructionSite cs = new ConstructionSite();
		cs.setId(1);
		cs.setBuildingName("test");
		
		Mockito.when(constructionSiteRepository.getOne(cs.getId())).thenReturn(cs);
		
	}
	
	@Test
	public void find_One_Cs_By_Id() {
		int id = 1;
		ConstructionSite cs = constructionSiteServiceImpl.findOneCsById(id);
		assertThat(cs.getId()).isEqualTo(id);
		assertThat(cs.getBuildingName()).isEqualTo("test");
		
	}
	
}
