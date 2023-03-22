package PVBClothing.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import PVBClothing.DAO.UserDao;
import PVBClothing.Entity.User;
import PVBClothing.Service.User.AccountServiceImp;

@Controller
public class UserController {
	@Autowired
	AccountServiceImp accountSevice = new AccountServiceImp();
	@Autowired
	UserDao userDao = new UserDao();
	
	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView Register() {
		ModelAndView mv = new ModelAndView("user/account/register");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user")User user) {
		ModelAndView mv = new ModelAndView("user/account/register");		
		int rowCount = accountSevice.AddAccount(user);
	
		if(rowCount > 0) {
			mv.addObject("status", "Create an account successfully!!");
			
		}else {
			mv.addObject("status", "Failed to create an account!!");
		}
		mv.setViewName("user/account/register");
		return mv;
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session ,@ModelAttribute("user")User user) {
		ModelAndView mv = new ModelAndView("user/account/register");
		 user = accountSevice.CheckAccount(user);
		if(user != null) {
			mv.setViewName("redirect:Home");
			String fullName = user.getFirst_name()+ " " + user.getLast_name();
			session.setAttribute("fullName", fullName);
			session.setAttribute("loginInfo", user);
		}else {
			mv.addObject("statusLogin", "Failed to Login!!");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String Logout(HttpSession session , HttpServletRequest request) {
		session.removeAttribute("loginInfo");
		
		return "redirect:" + request.getHeader("Referer");
	}
}
