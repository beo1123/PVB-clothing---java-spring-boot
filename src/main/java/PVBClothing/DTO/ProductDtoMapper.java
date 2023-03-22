package PVBClothing.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductDtoMapper implements RowMapper<ProductDto> {

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto productDto = new ProductDto();
		// TODO Auto-generated method stub
		productDto.setId_Product(rs.getLong("id_product"));
		productDto.setId_Cat(rs.getInt("id_cat"));
		productDto.setSize(rs.getString("size"));
		productDto.setName(rs.getString("name"));
		productDto.setPrice(rs.getDouble("price"));
		productDto.setSale(rs.getInt("sale"));
		productDto.setHightlight(rs.getBoolean("hightlight"));
		productDto.setNew_product(rs.getBoolean("new_product"));
		productDto.setDescription(rs.getString("description"));
		productDto.setId_Color(rs.getInt("id_color"));
		productDto.setName_color(rs.getString("name_color"));
		productDto.setCode_color(rs.getString("code_color"));
		productDto.setImg(rs.getString("img"));
		productDto.setCreate_at(rs.getDate("create_at"));
		productDto.setUpdate_at(rs.getDate("update_at"));
		return productDto;
	}

}
