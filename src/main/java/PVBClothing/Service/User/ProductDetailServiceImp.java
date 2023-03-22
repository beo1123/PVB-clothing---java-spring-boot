package PVBClothing.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PVBClothing.DAO.ProductDao;
import PVBClothing.DTO.ProductDto;

@Service
public class ProductDetailServiceImp implements IProductDetailSevice {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public ProductDto GetProductDetailById(long id) {
		// TODO Auto-generated method stub
		List<ProductDto> list = productDao.GetProductDetailById(id);
		return list.get(0);
	}

	@Override
	public List<ProductDto> GetProductByCategory(int id) {
		// TODO Auto-generated method stub
		return productDao.GetProductById(id);
	}
	
	
}
