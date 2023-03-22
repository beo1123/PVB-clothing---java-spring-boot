package PVBClothing.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUser implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User users = new User();
		users.setId_User(rs.getLong("id_user"));
		users.setEmail(rs.getString("email"));
		users.setPasword(rs.getString("pasword"));
		users.setFirst_name(rs.getString("first_name"));
		users.setLast_name(rs.getString("last_name"));
		users.setAddress(rs.getString("address"));
		users.setPhone(rs.getString("phone"));
		return users;
	}
}
