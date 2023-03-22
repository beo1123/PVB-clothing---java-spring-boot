package PVBClothing.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import PVBClothing.DTO.ProductDto;

@Service
public interface ICategorySercive {
	public List<ProductDto> GetProductbyId(int id);
	public List<ProductDto> GetProductbyIdPage(int id, int start, int end);
}
