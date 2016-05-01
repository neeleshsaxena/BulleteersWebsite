package com.bulleteers.club;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bulleteers.club.dao.DealerDao;
import com.bulleteers.club.exception.AdException;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Dealer;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Ride;

@Controller
public class AddDealerController {
	
	
	@Autowired
	DealerDao dealerDao;
	
	
	@RequestMapping(value = "/addDealer", method = RequestMethod.GET)
	public String home(@ModelAttribute("dealer") Dealer dealer,BindingResult result, HttpServletRequest request) {
		
		
		
		System.out.println("Welcome Dealer!");
		
		return "addDealer";
	}
	
	@RequestMapping(value = "/addDealerDetails", method = RequestMethod.POST)
	public String addMember(@ModelAttribute("dealer") Dealer dealer, BindingResult result,HttpServletRequest request) throws AdException {
		
		
		
		HttpSession session = request.getSession();
		
		//add dealer and direct towards the home page
		Dealer d = dealerDao.saveDealer(dealer);
		
		if(d!=null){
		session.setAttribute("dealer", d);
		session.setAttribute("items", d.getItems());
		
			return "dealerhome";
		}
		else{
			return "addDealer";
		}
		
	}
	
	
	

}
