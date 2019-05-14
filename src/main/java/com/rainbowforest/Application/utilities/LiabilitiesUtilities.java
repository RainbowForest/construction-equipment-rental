package com.rainbowforest.Application.utilities;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.rainbowforest.Application.model.constructionSite.ConstructionSite;
import com.rainbowforest.Application.model.order.Order;

public class LiabilitiesUtilities {

	/**
	 * Sums all current financial liabilities for a given construction site 
	 * and saves the result to the map, where the key is the name of the construction site
	 * and the value is the sum of current liabilities
	 * 
	 * @param constructionSites, List of all construction site
	 * @param orders, List of all orders
	 * @return the map of current value of all liabilities for a given construction site
	 */
	public static Map<String, Double> getLiabilities(List<ConstructionSite> constructionSites, List<Order> orders){
		Map<String, Double> liabilitiesMap = new TreeMap<String, Double>();
		for(int i = 0; i < constructionSites.size() ; i++) {
			String csName = constructionSites.get(i).getBuildingName();
			double liabilities = 0;
			for(int j = 0; j < orders.size() ;j++) {
				String buildingName = orders.get(j).getConstructionSite().getBuildingName();
				if(csName == buildingName && orders.get(j).getStatus() == 0) {
					liabilities += orders.get(j).getTotalPrice();
				}
				liabilitiesMap.put(csName, liabilities);
			}
		}
		return liabilitiesMap;
	}
}
