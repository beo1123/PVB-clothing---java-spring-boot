package PVBClothing.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import PVBClothing.Entity.MapperSlides;
import PVBClothing.Entity.Slides;

@Repository
public class SlidesDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	String sql = "SELECT * FROM slides";
	public List<Slides> GetDataSlide(){
		List<Slides> lst = new ArrayList<Slides>();
		lst = _jdbcTemplate.query(sql, new MapperSlides());
		return lst;
	}
}
