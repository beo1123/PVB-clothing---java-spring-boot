package PVBClothing.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PVBClothing.DAO.ProductDao;
import PVBClothing.DTO.ProductDto;

@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	private ProductDao productDao;
	@Override
	public List<ProductDto> GetAllProduct() {
		// TODO Auto-generated method stub
		return productDao.GetAllProduct();
	}
	@Override
	public List<ProductDto> GetAllProductPaginate(int start, int end) {
		// TODO Auto-generated method stub
		return productDao.GetAllProductPaginate(start, end);
	}

}
