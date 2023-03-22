package PVBClothing.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import PVBClothing.DTO.PaginateDto;
import PVBClothing.Service.User.CategoryServiceImp;
import PVBClothing.Service.User.HomeServiceImp;
import PVBClothing.Service.User.PaginateServiceImp;

@Controller
public class CategoryController {
	@Autowired
	private CategoryServiceImp categoryService;
	@Autowired
	private PaginateServiceImp paginateService;
	@Autowired
	private HomeServiceImp homeService;

	@RequestMapping(value = { "/product/{id_Cat}" })
	public ModelAndView product(@PathVariable String id_Cat) {

		int limitProductInPage = 9;
		ModelAndView mv = new ModelAndView("user/product/category");
		int totalData = categoryService.GetProductbyId(Integer.parseInt(id_Cat)).size();
		PaginateDto paginateInfo = paginateService.GetInfoPage(totalData, limitProductInPage, 1);
		mv.addObject("idCategory", id_Cat);
		mv.addObject("dataCategory", homeService.GetDatacategory());
		mv.addObject("productSale", homeService.GetDataSaleProduct());
		mv.addObject("paginateInfo", paginateInfo);
		mv.addObject("allProductById", categoryService.GetProductbyIdPage(Integer.parseInt(id_Cat),
				paginateInfo.getStart() - 1, limitProductInPage));

		return mv;
	}

	@RequestMapping(value = { "/product/{id_Cat}/{currrentPage}" })
	public ModelAndView product(@PathVariable String id_Cat, @PathVariable int currrentPage) {

		int limitProductInPage = 9;
		ModelAndView mv = new ModelAndView("user/product/category");
		int totalData = categoryService.GetProductbyId(Integer.parseInt(id_Cat)).size();
		PaginateDto paginateInfo = paginateService.GetInfoPage(totalData, limitProductInPage, currrentPage);
		mv.addObject("idCategory", id_Cat);
		mv.addObject("paginateInfo", paginateInfo);
		mv.addObject("allProductById", categoryService.GetProductbyIdPage(Integer.parseInt(id_Cat),
				paginateInfo.getStart() - 1, limitProductInPage));

		return mv;
	}
}
