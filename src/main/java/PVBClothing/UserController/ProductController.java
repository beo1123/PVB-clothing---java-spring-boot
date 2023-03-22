package PVBClothing.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import PVBClothing.DTO.PaginateDto;
import PVBClothing.Service.User.HomeServiceImp;
import PVBClothing.Service.User.PaginateServiceImp;
import PVBClothing.Service.User.ProductServiceImp;

@Controller
public class ProductController {
	@Autowired
	private ProductServiceImp productService;
	@Autowired
	private PaginateServiceImp paginateService;
	@Autowired
	private HomeServiceImp homeService;

	@RequestMapping(value = { "/Product" })
	public ModelAndView product() {

		int limitProductInPage = 9;
		ModelAndView mv = new ModelAndView("user/product/AllProduct");
		int totalData = productService.GetAllProduct().size();
		PaginateDto paginateInfo = paginateService.GetInfoPage(totalData, limitProductInPage, 1);
		mv.addObject("dataCategory", homeService.GetDatacategory());
		mv.addObject("productSale", homeService.GetDataSaleProduct());
		mv.addObject("paginateInfo", paginateInfo);
		mv.addObject("allProduct", productService.GetAllProductPaginate(
				paginateInfo.getStart() - 1, limitProductInPage));

		return mv;
	}
	
	@RequestMapping(value = { "/Product/{currrentPage}" })
	public ModelAndView product(@PathVariable int currrentPage) {

		int limitProductInPage = 9;
		ModelAndView mv = new ModelAndView("user/product/AllProduct");
		int totalData = productService.GetAllProduct().size();
		PaginateDto paginateInfo = paginateService.GetInfoPage(totalData, limitProductInPage, currrentPage);
		mv.addObject("dataCategory", homeService.GetDatacategory());
		mv.addObject("productSale", homeService.GetDataSaleProduct());
		mv.addObject("paginateInfo", paginateInfo);
		mv.addObject("allProduct", productService.GetAllProductPaginate(
				paginateInfo.getStart() - 1, limitProductInPage));

		return mv;
	}
}
