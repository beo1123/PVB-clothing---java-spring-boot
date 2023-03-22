
package PVBClothing.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import PVBClothing.DTO.ProductDto;

@Service
public interface IProductDetailSevice {
	public ProductDto GetProductDetailById(long id);
	public List<ProductDto> GetProductByCategory(int id);
}
