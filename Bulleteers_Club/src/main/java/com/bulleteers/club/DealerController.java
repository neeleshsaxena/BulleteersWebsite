package com.bulleteers.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bulleteers.club.dao.DealerDao;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Dealer;
import com.bulleteers.club.pojo.Item;
import com.bulleteers.club.pojo.Member;

@Controller
public class DealerController {
	
	@Autowired
	DealerDao dealerDao;
	
	
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item item,BindingResult result, HttpServletRequest request) {
		
		try{
			
			HttpSession session = request.getSession();
			
			Dealer dealer = (Dealer) session.getAttribute("dealer");
			 dealer = dealerDao.addItem(item, dealer);
			
			
			session.setAttribute("items", dealer.getItems());
			session.setAttribute("dealer", dealer);
			
			System.out.println("Item added to the session list");
			
		
		return "dealerhome";
		
		
		}catch(Exception e){
			System.out.println("Error in adding product:" +e.getMessage());
		}
		
		return "dealerhome";
		
		
	}
	
	@RequestMapping(value = "/editItem", method = RequestMethod.POST)
	public String editItem(@ModelAttribute("item") Item item,BindingResult result, HttpServletRequest request) {
		
		try{
			
			HttpSession session = request.getSession();
			
			Dealer dealer = (Dealer) session.getAttribute("dealer");
			dealer = dealerDao.editItem(item, dealer);
			List<Item> items = dealer.getItems();
			
			session.setAttribute("items", items);
			session.setAttribute("dealer", dealer);
			
			System.out.println("Item updated to the session list");
			
		
		return "dealerhome";
		
		
		}catch(Exception e){
			System.out.println("Error in adding product:" +e.getMessage());
		}
		
		return "dealerhome";
		
		
	}
	
	
	
	
	
	

}
