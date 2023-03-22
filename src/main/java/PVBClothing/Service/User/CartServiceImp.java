package PVBClothing.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PVBClothing.DAO.CartDao;
import PVBClothing.DTO.CartDto;

@Service
public class CartServiceImp implements ICartService{
	@Autowired
	private CartDao cartDao;

	@Override
	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		return cartDao.AddCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) {
		return cartDao.EditCart(id, quanty, cart);
	}

	@Override
	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {
		return cartDao.DeleteCart(id, cart);
	}

	@Override
	public int TotalQuanty(HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.TotalQuanty(cart);
	}

	@Override
	public double TotalPrice(HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.TotalPrice(cart);
	}
}
