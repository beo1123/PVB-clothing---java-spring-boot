package PVBClothing.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import PVBClothing.Entity.MapperUser;
import PVBClothing.Entity.User;


@Repository
public class UserDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int AddAccount(User user) {
		// TODO Auto-generated method stub
		
		
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("user ");
		sql.append("( email, ");
		sql.append(" pasword, ");
		sql.append(" first_name, ");
		sql.append(" last_name, ");
		sql.append(" address, ");
		sql.append(" phone) ");
		sql.append("  ");
		sql.append("VALUES ");
		sql.append(" ");
		sql.append("('"+user.getEmail()+"', ");
		sql.append(" '"+user.getPasword()+"', ");
		sql.append(" '"+user.getFirst_name()+"', ");
		sql.append(" '"+user.getLast_name()+"', ");
		sql.append(" '"+user.getAddress()+"', ");
		sql.append(" '"+user.getPhone()+"')");
		int rowInsert = _jdbcTemplate.update(sql.toString());
		return rowInsert;
	}
	
	public User GetAccountUser(User user) {
		// TODO Auto-generated method stub
				
		String sql = "SELECT * FROM user WHERE email = '" + user.getEmail() + "'";
		
		User result = _jdbcTemplate.queryForObject(sql, new MapperUser());
	
		return result;
	}
	
	

}
