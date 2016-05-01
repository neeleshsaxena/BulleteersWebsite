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

import com.bulleteers.club.dao.ProductDao;
import com.bulleteers.club.pojo.Dealer;
import com.bulleteers.club.pojo.Item;
import com.bulleteers.club.pojo.Member;

@Controller
public class AccessoriesController {
	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping(value = "/displayAccessories", method = RequestMethod.GET)
	public String display(@ModelAttribute("item") Item item,BindingResult result, HttpServletRequest request) {
		
		try{
			///////////////chec session and move him to home if no user is present
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("member")!=null){
			
			Member member = (Member) session.getAttribute("member");
			
			List<Item> items = productDao.getItems();
			
			
			session.setAttribute("items", items);
			
			System.out.println("Item added to the session list");
			
		
		return "accessories";
			}
			else{
				return "home";
			}
		
		
		}catch(Exception e){
			System.out.println("Error in adding product:" +e.getMessage());
		}
		
		return "memberhome";
		
		
	}
	
	@RequestMapping(value = "/buyItem", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item item,BindingResult result, HttpServletRequest request) {
		
		try{
			
			HttpSession session = request.getSession();
			
			Member member = (Member) session.getAttribute("member");
			
			member = productDao.buyItem(item, member);
				
				List<Item> items = productDao.getItems();
				session.setAttribute("items", items);
				session.setAttribute("member", member);
				
				System.out.println("List updated");
				
				return "accessories";
				
			
			
			
		
		
		
		}catch(Exception e){
			System.out.println("Error in adding product:" +e.getMessage());
		}
		
		return "memberhome";
		
		
	}
	
	@RequestMapping(value = "/buyItem", method = RequestMethod.GET)
	public String addItem(){
		
		return"home";
		
		
	}
	

}
