package PVBClothing.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperInvoice implements RowMapper<Invoice> {
	@Override
	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Invoice invoice = new Invoice();
		invoice.setId_Invoice(rs.getLong("id_invoice"));
		invoice.setTotalPrice(rs.getDouble("totalprice"));
		invoice.setTotalQuanty(rs.getInt("totalquanty"));
		invoice.setEmail(rs.getString("email"));
		invoice.setFull_Name(rs.getString("full_name"));
		invoice.setPhone(rs.getString("phone"));
		invoice.setAddress(rs.getString("address"));
		return invoice;
	}
}
