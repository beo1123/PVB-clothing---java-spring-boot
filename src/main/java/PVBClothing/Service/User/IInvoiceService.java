package PVBClothing.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import PVBClothing.DTO.CartDto;
import PVBClothing.Entity.Invoice;

@Service
public interface IInvoiceService {
	public int addInvoice(Invoice invoice);
	
	public void addInvoiceDetails(HashMap<Long, CartDto> cart);
}
