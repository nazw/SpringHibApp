package com.abc.springhib.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abc.springhib.entity.SystemUser;
import com.abc.springhib.service.SystemUserService;
import com.abc.springhib.util.ApplicationConstants;

@Controller
public class SystemUserController {
	
	@Autowired
	private SystemUserService systemUserService;
	
    @RequestMapping(value = "userSignUp", method = RequestMethod.GET)
    public ModelAndView userSignUp() {
    	SystemUser systemUser = new SystemUser();
        ModelMap map = new ModelMap();
        map.put("systemUser", systemUser);
        return new ModelAndView("signUp", map);
    }
	
	@RequestMapping(value = "saveSystemUser", method = RequestMethod.POST)
    public String saveSystemUser(@ModelAttribute("systemUser") SystemUser systemUser, HttpServletRequest request) {      
		systemUserService.saveSystemUser(systemUser);
		HttpSession session =  request.getSession();
		if ((SystemUser)session.getAttribute(ApplicationConstants.SYSTEM_USER) != null) {
			session.removeAttribute(ApplicationConstants.SYSTEM_USER);			
		}
		session.setAttribute(ApplicationConstants.SYSTEM_USER, systemUser);
		return "dashBoard";
    }
	
   @RequestMapping(value = "getUserLogin", method = RequestMethod.GET)
    public ModelAndView getUserLogin() {
    	SystemUser systemUser = new SystemUser();
        ModelMap map = new ModelMap();
        map.put("systemUser", systemUser);
        return new ModelAndView("login", map);
    }
   
	@RequestMapping(value = "userLogin", method = RequestMethod.POST)
    public ModelAndView userLogin(@ModelAttribute("systemUser") SystemUser systemUser, HttpServletRequest request) {      
		SystemUser user = systemUserService.findByUserNameAndPassword(systemUser.getUserName(), systemUser.getPassword());
		ModelMap map = new ModelMap();
		HttpSession session =  request.getSession();
		if(user != null ){
			if ((SystemUser)session.getAttribute(ApplicationConstants.SYSTEM_USER) != null) {
				session.removeAttribute(ApplicationConstants.SYSTEM_USER);			
			}
			session.setAttribute(ApplicationConstants.SYSTEM_USER, user);
			return new ModelAndView("dashBoard");
		}else{
			String errorMessage = "Invalid UserName or Password";
	        map.put("errorMessage", errorMessage);
			return new ModelAndView("error", map);
		}				
    }
	
    @RequestMapping(value = "userSignOut", method = RequestMethod.GET)
    public ModelAndView userSignOut(HttpSession session) {
    	session.removeAttribute(ApplicationConstants.SYSTEM_USER);
        return new ModelAndView("index");
    }
}
