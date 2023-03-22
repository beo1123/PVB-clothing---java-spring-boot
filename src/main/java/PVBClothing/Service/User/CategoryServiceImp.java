package PVBClothing.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PVBClothing.DAO.ProductDao;
import PVBClothing.DTO.ProductDto;

@Service
public class CategoryServiceImp implements ICategorySercive {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<ProductDto> GetProductbyId(int id) {
		// TODO Auto-generated method stub
		return productDao.GetProductById(id);
	}
	@Override
	public List<ProductDto> GetProductbyIdPage(int id, int start, int end) {
		// TODO Auto-generated method stub
		return productDao.GetProductByIdPage(id, start, end);
	}
	
}
