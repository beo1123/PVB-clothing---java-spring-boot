package PVBClothing.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import PVBClothing.DTO.ProductDto;
import PVBClothing.DTO.ProductDtoMapper;

@Repository
public class ProductDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;

	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    p.id_Product, ");
		sql.append("    p.id_Cat, ");
		sql.append("    p.size, ");
		sql.append("    p.name, ");
		sql.append("    p.price, ");
		sql.append("    p.sale, ");
		sql.append("    p.hightlight, ");
		sql.append("    p.new_product, ");
		sql.append("    p.description, ");
		sql.append("    c.id_Color, ");
		sql.append("    c.name AS name_color, ");
		sql.append("    c.code AS code_color, ");
		sql.append("    c.img, ");
		sql.append("    p.create_at, ");
		sql.append("    p.update_at ");
		sql.append(" ");
		sql.append(" ");
		sql.append("FROM product AS p ");
		sql.append("	INNER JOIN ");
		sql.append("	color AS c ");
		sql.append("    ON p.id_Product = c.id_Product ");

		return sql;
	}

	// Sql get hightlight product
	private String sqlHightLightString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    p.id_Product, ");
		sql.append("    p.id_Cat, ");
		sql.append("    p.size, ");
		sql.append("    p.name, ");
		sql.append("    p.price, ");
		sql.append("    p.sale, ");
		sql.append("    p.hightlight, ");
		sql.append("    p.new_product, ");
		sql.append("    p.description, ");
		sql.append("    c.id_Color, ");
		sql.append("    c.name AS name_color, ");
		sql.append("    c.code AS code_color, ");
		sql.append("    c.img, ");
		sql.append("    p.create_at, ");
		sql.append("    p.update_at ");
		sql.append(" ");
		sql.append(" ");
		sql.append("FROM product AS p ");
		sql.append("	INNER JOIN ");
		sql.append("	color AS c ");
		sql.append("    ON p.id_Product = c.id_Product ");
		sql.append("    WHERE 1 = 1 ");
		sql.append("    AND p.hightlight = true ");
		sql.append("    GROUP BY p.id_Product, c.id_Product");
		sql.append("    ORDER BY RAND() ");

		return sql.toString();
	}

	// exucute sql hightlight product
	public List<ProductDto> GetDataHightLightProduct() {
		String sql = sqlHightLightString();
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}

	// Sql get sale product
	private String sqlSaleString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    p.id_Product, ");
		sql.append("    p.id_Cat, ");
		sql.append("    p.size, ");
		sql.append("    p.name, ");
		sql.append("    p.price, ");
		sql.append("    p.sale, ");
		sql.append("    p.hightlight, ");
		sql.append("    p.new_product, ");
		sql.append("    p.description, ");
		sql.append("    c.id_Color, ");
		sql.append("    c.name AS name_color, ");
		sql.append("    c.code AS code_color, ");
		sql.append("    c.img, ");
		sql.append("    p.create_at, ");
		sql.append("    p.update_at ");
		sql.append(" ");
		sql.append(" ");
		sql.append("FROM product AS p ");
		sql.append("	INNER JOIN ");
		sql.append("	color AS c ");
		sql.append("    ON p.id_Product = c.id_Product ");
		sql.append("    WHERE 1 = 1 ");
		sql.append("    AND p.sale > 0 ");
		sql.append("    GROUP BY p.id_Product, c.id_Product");
		sql.append("    ORDER BY RAND() ");

		return sql.toString();
	}
	// exucute sql sale product

	public List<ProductDto> GetDataSaleProduct() {
		String sql = sqlSaleString();
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}

	// Sql get product by id
	private String sqlProductById(int id) {
		StringBuffer sql = sqlString();
		sql.append("    WHERE 1 = 1 ");
		sql.append("    AND p.id_Cat = " + id);

		return sql.toString();
	}

	// exucute sql get product by id
	public List<ProductDto> GetProductById(int id) {
		String sql = sqlProductById(id);
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}

	// Sql get product by id Paginate
	private String sqlProductByIdPage(int id, int start, int end) {
		StringBuffer sql = sqlString();
		sql.append("    WHERE 1 = 1 ");
		sql.append("    AND p.id_Cat = " + id);
		sql.append("    LIMIT " + start + "," + end);

		return sql.toString();
	}

	// exucute sql get product by id {Paginate
	public List<ProductDto> GetProductByIdPage(int id, int start, int end) {
		String sql = sqlProductByIdPage(id, start, end);
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}

	private String sqlAllProduct() {
		StringBuffer sql = sqlString();
		return sql.toString();
	}

	public List<ProductDto> GetAllProduct() {
		String sql = sqlAllProduct();
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}

	private String sqlAllProductPaginate(int start, int end) {
		StringBuffer sql = sqlString();
		sql.append("    WHERE 1 = 1 ");
		sql.append("    LIMIT " + start + "," + end);

		return sql.toString();
	}

	public List<ProductDto> GetAllProductPaginate(int start, int end) {
		String sql = sqlAllProductPaginate(start, end);
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
	}

	// Sql get product by id
	private String sqlProductDetailById(long id) {
		StringBuffer sql = sqlString();
		sql.append("    WHERE 1 = 1 ");
		sql.append("    AND p.id_Product  = " + id);
		sql.append("    LIMIT 1 ");

		return sql.toString();
	}

	public List<ProductDto> GetProductDetailById(long id) {
		// TODO Auto-generated method stub\
		String sql = sqlProductDetailById(id);
		List<ProductDto> list = _jdbcTemplate.query(sql, new ProductDtoMapper());
		return list;
		
	}
	
	public ProductDto FindProductlById(long id) {
		// TODO Auto-generated method stub\
		String sql = sqlProductDetailById(id);
		ProductDto product = _jdbcTemplate.queryForObject(sql, new ProductDtoMapper());
		return product;
		
	}

}
