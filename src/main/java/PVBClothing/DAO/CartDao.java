package PVBClothing.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import PVBClothing.DTO.CartDto;
import PVBClothing.DTO.ProductDto;

@Repository
public class CartDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	@Autowired
	ProductDao productDao = new ProductDao();
	
	private double priceSaleItem = 0;
	private int sale = 0;
	private double price = 0;
	private final double PERCENT = 100.0;

	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductDto product = productDao.FindProductlById(id);
		if (product != null && cart.containsKey(id)) {
			
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty() + 1);
			if(product.getSale() != 0) {
				sale = itemCart.getProduct().getSale();
				price = itemCart.getProduct().getPrice();
				priceSaleItem =  price * (sale/PERCENT);
				double priceItem = product.getPrice() - priceSaleItem;
				itemCart.setTotalPrice(priceItem);
				itemCart.setTotalPrice(itemCart.getQuanty() * priceItem);
			}else {
				itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
			}
			
		} else {
			
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			if(product.getSale() != 0) {
				sale = product.getSale();
				price = product.getPrice();
				priceSaleItem =  price * (sale/PERCENT);
				double priceItem = product.getPrice() - priceSaleItem;
				itemCart.setTotalPrice(priceItem);
			}else {
				itemCart.setTotalPrice(product.getPrice());
			}
			
		}
		cart.put(id, itemCart);
		return cart;

	}

	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) {
		ProductDto product = productDao.FindProductlById(id);
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			if(product.getSale() != 0) {
				sale = itemCart.getProduct().getSale();
				price = itemCart.getProduct().getPrice();
				priceSaleItem =  price * (sale/PERCENT);
				double priceItem = product.getPrice() - priceSaleItem;
				itemCart.setTotalPrice(priceItem);
				itemCart.setTotalPrice(itemCart.getQuanty() * priceItem);
			}else {
				itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
			}
		}
		cart.put(id, itemCart);
		return cart;

	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id))

		{
			cart.remove(id);
		}
		return cart;

	}

	public int TotalQuanty(HashMap<Long, CartDto> cart) {
		int toltalQty = 0;
		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			toltalQty += itemCart.getValue().getQuanty();
		}

		return toltalQty;

	}

	public double TotalPrice(HashMap<Long, CartDto> cart) {
		int toltalPrice = 0;
		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			toltalPrice += itemCart.getValue().getTotalPrice();
		}

		return toltalPrice;
	}
}
