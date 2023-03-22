package PVBClothing.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategory implements RowMapper<Category> {
	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Category categories = new Category();
		categories.setId_Cat(rs.getInt("id_Cat"));
		categories.setName(rs.getString("name"));
		categories.setDescription(rs.getString("description"));
		return categories;
	}
}
