package PVBClothing.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import PVBClothing.Entity.Category;
import PVBClothing.Entity.MapperCategory;

@Repository
public class CategoryDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	String sql = "SELECT * FROM category";

	public List<Category> GetDataCategory(){
		List<Category> lst = new ArrayList<Category>();
		lst = _jdbcTemplate.query(sql, new MapperCategory());
		return lst;
	}
}
