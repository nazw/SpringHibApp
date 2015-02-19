package com.abc.springhib.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import com.abc.springhib.entity.Announcement;
import com.abc.springhib.entity.SystemUser;
import com.abc.springhib.service.AnnouncementService;
import com.abc.springhib.util.AccountStatus;
import com.abc.springhib.util.AnnouncementCategory;
import com.abc.springhib.util.AnnouncementType;
import com.abc.springhib.util.ApplicationConstants;

@Controller
public class MasterDataController {

	@Autowired
	private AnnouncementService announcementService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {		
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "dashBoard", method = RequestMethod.GET)
	public ModelAndView getDashBoard() {		
		return new ModelAndView("dashBoard");
	}
	
   @RequestMapping(value = "getAnnouncements", method = RequestMethod.GET)
    public ModelAndView getAllAnnouncements() {
	    List<Announcement> AnnouncementsList = announcementService.findAll();
        ModelMap map = new ModelMap();
        map.put("announcementsList", AnnouncementsList);
   
        return new ModelAndView("manageAnnouncements", map);
    }
   
   @RequestMapping(value = "viewAnnouncement", method = RequestMethod.GET)
   public ModelAndView viewAnnouncement(@RequestParam("id") long announcementId) {
	   Announcement Announcement = announcementService.findById(announcementId);
       ModelMap map = new ModelMap();
       map.put("announcement", Announcement);
  
       return new ModelAndView("viewAnnouncement", map);
   }
   
   @RequestMapping(value = "createAnnouncement", method = RequestMethod.GET)
   public ModelAndView createAnnouncement() {	  
       ModelMap map = new ModelMap();
       Announcement announcement = new Announcement();
       map.put("announcement", announcement);
       map.put("accountStatusList", Arrays.asList(AccountStatus.values()));
       map.put("categoryList", Arrays.asList(AnnouncementCategory.values()));
       map.put("typeList", Arrays.asList(AnnouncementType.values()));
       return new ModelAndView("addAnnouncement", map);
   }   
   
   @RequestMapping(value = "saveAnnouncement", method = RequestMethod.POST)
   public ModelAndView saveAnnouncement(@ModelAttribute("announcement") Announcement announcement, BindingResult bindingResult, HttpServletRequest request) {      
	   	SystemUser systemUser = (SystemUser)request.getSession().getAttribute(ApplicationConstants.SYSTEM_USER);
	   	if (systemUser != null) {
	   		announcement.setSystemUser(systemUser);
	   	}else{
	   		return new ModelAndView("error");
	   	}	   	
		announcement.setCreatedDate(new Date());
		announcementService.saveAnnouncement(announcement);
		return getAllAnnouncements();
   }
    
   @RequestMapping(value = "editAnnouncement", method = RequestMethod.GET)
   public ModelAndView editAnnouncement(@RequestParam("id") long announcementId) {
	   Announcement announcement = announcementService.findById(announcementId);
       ModelMap map = new ModelMap();
       map.put("announcement", announcement);
       map.put("accountStatusList", Arrays.asList(AccountStatus.values()));
       map.put("categoryList", Arrays.asList(AnnouncementCategory.values()));
       map.put("typeList", Arrays.asList(AnnouncementType.values()));
       return new ModelAndView("editAnnouncement", map);
   }
   
   @RequestMapping(value = "deleteAnnouncement", method = RequestMethod.GET)
   public String deleteAnnouncement(@RequestParam("id") long announcementId) {
	   announcementService.deleteAnnouncement(announcementId);        
	   return "redirect:/getAnnouncements";
   }
   
   @RequestMapping(value = "updateAnnouncement", method = RequestMethod.POST)
   public String updateAnnouncement(@ModelAttribute("announcement") Announcement announcement, BindingResult bindingResult) {	   	
		announcementService.updateAnnouncement(announcement);		
		return "redirect:/getAnnouncements";
   }
}
