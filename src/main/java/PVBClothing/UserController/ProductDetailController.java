package PVBClothing.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import PVBClothing.Service.User.HomeServiceImp;
import PVBClothing.Service.User.ProductDetailServiceImp;
import PVBClothing.Service.User.ProductServiceImp;

@Controller
public class ProductDetailController {

	@Autowired
	private ProductDetailServiceImp productDetailService;
	@Autowired
	private HomeServiceImp homeService;


	@RequestMapping(value = {  "ProductDetail/{id}" })
	public ModelAndView ProductDetail(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("user/product/ProductDetail");
		mv.addObject("productDetail", productDetailService.GetProductDetailById(id));
		mv.addObject("productSale", homeService.GetDataSaleProduct());
		mv.addObject("dataCategory", homeService.GetDatacategory());
		int id_Cat = productDetailService.GetProductDetailById(id).getId_Cat();
		mv.addObject("productByCat", productDetailService.GetProductByCategory(id_Cat));
		return mv;

	}

}
