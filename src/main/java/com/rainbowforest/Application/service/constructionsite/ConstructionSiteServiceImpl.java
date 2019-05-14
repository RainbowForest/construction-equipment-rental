package com.rainbowforest.Application.service.constructionsite;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.repository.ConstructionSiteAdressRepository;
import com.rainbowforest.Application.repository.ConstructionSiteRepository;

@Service
@Transactional
public class ConstructionSiteServiceImpl implements ConstructionSiteService {

	@Autowired
	private ConstructionSiteRepository constructionSiteRepository;
	
	@Autowired
	private ConstructionSiteAdressRepository constructionSiteAdressRepository;
	
	@Override
	public void addConstructionSite(ConstructionSite constructionSite) {
		constructionSiteRepository.save(constructionSite);
	}

	@Override
	public List<ConstructionSite> findAllConstructionSite() {
		List<ConstructionSite> constructionsSiteList = constructionSiteRepository.findAll();
		return constructionsSiteList;
	}
	
	@Override
	public ConstructionSite findOneCsById(int id) {
		ConstructionSite cs = constructionSiteRepository.getOne(id);
		return cs;
	}

	@Override
	public void updateConstructionSiteAdress(String newStreet,
			String newStreetNumber, String newLocality, String newZipCode, String newCountry, Integer id) {
		constructionSiteAdressRepository.updateConstructionSiteAdress(newStreet, newStreetNumber, newLocality, newZipCode, newCountry, id);
	}

	@Override
	public void updateConstructionSite(String newBuildingName, String newBuildingCode, Integer newStatus, Integer id) {
		constructionSiteRepository.updateConstructionSite(newBuildingName, newBuildingCode, newStatus, id);
		
	}

	@Override
	public List<ConstructionSite> getAllConstructionSiteByUserName(String userName) {
		List<ConstructionSite> cs = constructionSiteRepository.getAllConstructionSiteByUserName(userName);
		return cs;
	}
}
