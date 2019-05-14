package com.rainbowforest.Application.utilities;

import java.util.List;
import com.rainbowforest.Application.model.catalog.Item;

public class OrderUtilities {

	/**
	 * Sums the value of all items in the cart and returns the total value of the order
	 * 
	 * @param items, list of all items in cart
	 * @return double, returns the total value of the order
	 */
	public static double getTotalPrice(List<Item> items) {
		double totalPrice = 0;
		for(int i = 0; i < items.size(); i++) {
			int quantity = items.get(i).getQuantity();
			double productPrice = items.get(i).getProduct().getProductPrice();
			totalPrice += (productPrice * quantity);
		}
		return totalPrice;
	}
	
	/**
	 * Checks in the list of items if the product with the given 
	 * identifier is exist in the cart. 
	 * if the product already exists, the method returns the index number of the list, 
	 * where the product is saved, if it does not exist, the method returns the value -1
	 * 
	 * @param id, product id
	 * @param cart, the list of items in cart
	 * @return int, return value -1 if the product in the cart does not exist or the index number of the list, 
	 * where the product is saved
	 */
	public static int isExist(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}	
}
	