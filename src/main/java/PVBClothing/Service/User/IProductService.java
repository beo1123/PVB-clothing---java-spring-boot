package PVBClothing.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import PVBClothing.DTO.ProductDto;

@Service
public interface IProductService {
	public List<ProductDto> GetAllProduct();
	public List<ProductDto> GetAllProductPaginate(int start, int end);
}
