package PVBClothing.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperInvoiceDetail implements RowMapper<InvoiceDetail> {
	@Override
	public InvoiceDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		invoiceDetail.setId_InvoiceDetail(rs.getLong("id_invoicedetail"));
		invoiceDetail.setId_Product(rs.getLong("id_product"));
		invoiceDetail.setId_Invoice(rs.getLong("id_invoice"));
		invoiceDetail.setQuanty(rs.getInt("quanty"));
		invoiceDetail.setTotal(rs.getDouble("total"));

		return invoiceDetail;
	}
}
