package PVBClothing.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PVBClothing.DAO.SlidesDao;
import PVBClothing.DTO.ProductDto;
import PVBClothing.DAO.CategoryDao;
import PVBClothing.DAO.ProductDao;
import PVBClothing.Entity.Category;
import PVBClothing.Entity.Slides;

@Service
public class HomeServiceImp implements IHomeService {

	@Autowired
	private SlidesDao slidesDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public List<Slides> GetDataSlide() {
		// TODO Auto-generated method stub
		return slidesDao.GetDataSlide();
	}
	
	@Override
	public List<Category> GetDatacategory() {
		// TODO Auto-generated method stub
		return categoryDao.GetDataCategory();
	}

	@Override
	public List<ProductDto> GetDataHightLightProduct() {
		// TODO Auto-generated method stub
		List<ProductDto> list = productDao.GetDataHightLightProduct();
		return list;
	}

	@Override
	public List<ProductDto> GetDataSaleProduct() {
		// TODO Auto-generated method stub
		List<ProductDto> list = productDao.GetDataSaleProduct();
		return list;
	}

}
