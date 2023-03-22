package PVBClothing.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import PVBClothing.Entity.Invoice;
import PVBClothing.Entity.InvoiceDetail;

@Repository
public class InvoiceDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public int addInvoice(Invoice invoice) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `invoice` ");
		sql.append(" ");
		sql.append("( `totalPrice`, `totalQuanty`, `email`, `full_Name`, `phone`, `address`) ");
		sql.append(" ");
		sql.append("VALUES ('"+invoice.getTotalPrice()+"' ");
		sql.append("        ,'"+invoice.getTotalQuanty()+"' ");
		sql.append("        ,'"+invoice.getEmail()+"', ");
		sql.append("        '"+invoice.getFull_Name()+"', ");
		sql.append("        '"+invoice.getPhone()+"', ");
		sql.append("        '"+invoice.getAddress()+"')");
		
		int insertRow = _jdbcTemplate.update(sql.toString());
		return insertRow;
	}
	
	public long getLastIdInvoice() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT MAX(id_Invoice) FROM invoice");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}
	
	public int addInvoiceDetails(InvoiceDetail invoiceDetail) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("`invoicedetail` ");
		sql.append("( `id_Product`, `id_Invoice`, `quanty`, `total`) ");
		sql.append("VALUES ('"+invoiceDetail.getId_Product()+"', ");
		sql.append("        '"+invoiceDetail.getId_Invoice()+"', ");
		sql.append("        '"+invoiceDetail.getQuanty()+"', ");
		sql.append("        '"+invoiceDetail.getTotal()+"')");
		
		int insertRow = _jdbcTemplate.update(sql.toString());
		return insertRow;
	}
}
