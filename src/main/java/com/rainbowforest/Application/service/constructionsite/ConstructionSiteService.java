package com.rainbowforest.Application.service.constructionsite;

import java.util.List;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;

public interface ConstructionSiteService {
	public ConstructionSite findOneCsById(int id);
	public List<ConstructionSite> findAllConstructionSite();
	public void addConstructionSite(ConstructionSite constructionSite);
	public void updateConstructionSiteAdress(
			 String newStreet,			  	
			 String newStreetNumber,
			 String newLocality,
			 String newZipCode,
			 String newCountry,
			 Integer id);
	
	 public void updateConstructionSite(
			 String newBuildingName,
			 String newBuildingCode,
			 Integer newStatus,
			 Integer id);
	 
	 public List<ConstructionSite> getAllConstructionSiteByUserName(String userName);
}
