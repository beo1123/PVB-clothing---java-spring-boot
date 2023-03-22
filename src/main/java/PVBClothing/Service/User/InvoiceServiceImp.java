package PVBClothing.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PVBClothing.DAO.InvoiceDao;
import PVBClothing.DTO.CartDto;
import PVBClothing.Entity.Invoice;
import PVBClothing.Entity.InvoiceDetail;

@Service
public class InvoiceServiceImp implements IInvoiceService {

	@Autowired
	InvoiceDao InvoiceDao = new InvoiceDao();
	
	@Override
	public int addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return InvoiceDao.addInvoice(invoice);
	}

	@Override
	public void addInvoiceDetails(HashMap<Long, CartDto> cart) {
		// TODO Auto-generated method stub
		long id_Invoice = InvoiceDao.getLastIdInvoice();
		for(Map.Entry<Long, CartDto> itemCart: cart.entrySet()) {
			InvoiceDetail invoiceDetail = new InvoiceDetail();
			invoiceDetail.setId_Invoice(id_Invoice);
			invoiceDetail.setId_Product(itemCart.getValue().getProduct().getId_Product());
			invoiceDetail.setQuanty(itemCart.getValue().getQuanty());
			invoiceDetail.setTotal(itemCart.getValue().getTotalPrice());
			InvoiceDao.addInvoiceDetails(invoiceDetail);
		}
		
	}

}
