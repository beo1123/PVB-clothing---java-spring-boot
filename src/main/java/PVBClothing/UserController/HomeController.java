package PVBClothing.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import PVBClothing.Service.User.HomeServiceImp;

@Controller
public class HomeController {
	@Autowired
	HomeServiceImp homeService;

	@RequestMapping(value = { "/", "/Home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("user/index");
		mv.addObject("slides", homeService.GetDataSlide());
		mv.addObject("category", homeService.GetDatacategory());
		mv.addObject("productHightLight", homeService.GetDataHightLightProduct());
		mv.addObject("productSale", homeService.GetDataSaleProduct());
		mv.setViewName("user/index");
		return mv;

	}

	

}
