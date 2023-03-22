package PVBClothing.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import PVBClothing.DTO.CartDto;
import PVBClothing.Entity.Invoice;
import PVBClothing.Entity.User;
import PVBClothing.Service.User.CartServiceImp;
import PVBClothing.Service.User.InvoiceServiceImp;
import PVBClothing.Service.User.ProductServiceImp;

@Controller
public class CartController {

	@Autowired
	private CartServiceImp cartService = new CartServiceImp();
	
	@Autowired
	private ProductServiceImp productService = new ProductServiceImp();
	
	@Autowired
	private InvoiceServiceImp invoiceService = new InvoiceServiceImp();
	
	@RequestMapping(value = { "ListCart" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("user/cart/ListCart");
		mv.addObject("product", productService.GetAllProduct());
		mv.setViewName("user/cart/ListCart");
		return mv;
	}

	@RequestMapping(value = { "/AddCart/{id}" })
	public String AddCart(HttpServletRequest rq ,HttpSession session, @PathVariable long id) {
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			if(cart == null) {
				cart = new HashMap<Long, CartDto>();
			}
			cart = cartService.AddCart(id, cart);
			session.setAttribute("Cart", cart);
			session.setAttribute("TotalQuanty", cartService.TotalQuanty(cart));
			session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
			
		return "redirect:" + rq.getHeader("Referer");
		
		
		}
	
	@RequestMapping(value = { "EditCart/{id}/{quanty}" })
	public String EditCart(HttpServletRequest rq ,HttpSession session, @PathVariable long id, @PathVariable int quanty) {
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			if(cart == null) {
				cart = new HashMap<Long, CartDto>();
			}
			cart = cartService.EditCart(id, quanty, cart);
			session.setAttribute("Cart", cart);
			session.setAttribute("TotalQuanty", cartService.TotalQuanty(cart));
			session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
			
		return "redirect:" + rq.getHeader("Referer");
	}

	@RequestMapping(value = { "/DeleteCart/{id}" })
	public String DeleteCart(HttpServletRequest rq ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuanty", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPrice", cartService.TotalPrice(cart));
		return "redirect:" + rq.getHeader("Referer");
	}
	
	@RequestMapping(value = { "/Checkout"}, method = RequestMethod.GET )
	public ModelAndView Checkout(HttpServletRequest rq ,HttpSession session) {
		ModelAndView mv = new ModelAndView("user/bill/checkout");
		Invoice invoice = new Invoice();
		User loginInfo = (User)session.getAttribute("loginInfo");
		if(loginInfo != null) {
			invoice.setAddress(loginInfo.getAddress());
			invoice.setFull_Name((String)session.getAttribute("fullName"));
			invoice.setEmail(loginInfo.getEmail());
			invoice.setPhone(loginInfo.getPhone());
		}
		mv.addObject("invoice", invoice);
		
		return mv;
	}
	
	@RequestMapping(value = { "/Checkout"}, method = RequestMethod.POST )
	public String CheckoutInvoice(HttpServletRequest rq ,HttpSession session, @ModelAttribute("invoice")Invoice invoice) {
		
		invoice.setTotalQuanty((int)session.getAttribute("TotalQuanty"));
		invoice.setTotalPrice((double)session.getAttribute("TotalPrice"));
		
		if(invoiceService.addInvoice(invoice) > 0) {
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			invoiceService.addInvoiceDetails(cart);
			
		}
		session.removeAttribute("Cart");
		
		return "redirect:Checkout";
	}
}

