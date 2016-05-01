package com.bulleteers.club;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bulleteers.club.dao.DAO;
import com.bulleteers.club.dao.DealerDao;
import com.bulleteers.club.dao.MemberDao;
import com.bulleteers.club.dao.MessageDao;
import com.bulleteers.club.dao.UserDao;
import com.bulleteers.club.exception.AdException;
import com.bulleteers.club.pojo.UserAccount;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Dealer;
import com.bulleteers.club.pojo.Item;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Message;
import com.bulleteers.club.pojo.Ride;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	DealerDao dealerDao;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("userAccount") UserAccount userAccount) {
		logger.info("Welcome home!");
		
		return "home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		logger.info("Logout!");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		
		return "home";
	}
	
	//check if username password exists
	@RequestMapping(value="/index", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("userAccount") UserAccount userAccount,HttpServletRequest request)throws Exception
	{
		
	try{
		
		HttpSession session = request.getSession();
		
		
		userAccount = userDao.findByUserName(userAccount.getUsername(), userAccount.getPassword());
		if(userAccount!=null){
		
		if(userAccount.getPerson()!=null && userAccount.getRole().getRole().equalsIgnoreCase("member")){
			
			
			
			//display his club, his rides,recommendations for products and rides,notifications
			Member mem = userDao.getMember(userAccount.getPerson().getPersonID());
			Club club = memberDao.getClub(mem);
			Set<Ride> rides = memberDao.getRide(club);
			List<Message> messages = messageDao.getNotification(mem);
			int count = messages.size();
			

			session.setAttribute("member", mem);
			session.setAttribute("club", club);
			session.setAttribute("rides", rides);
			session.setAttribute("notification", messages);
			session.setAttribute("count", count);
			
			
			
			return "memberhome";
			
			
			
			
		}
		else if(userAccount.getRole().getRole().equalsIgnoreCase("dealer")){
			
			Dealer dealer = dealerDao.getDealer(userAccount.getPerson().getPersonID());
			List<Item> items = dealer.getItems();
			
			session.setAttribute("dealer", dealer);
			session.setAttribute("items", items);
			
			return "dealerhome";
		}
			}
			else{
				
				System.out.println("Username Password is Invalid!");
				
				return "home";
				
			}
		
	}
	catch(Exception e){
		
		System.out.println("Exception:"+e.getMessage());
	}
		//else return to the login page
		return "home";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String loginCheck(){
		
		return"home";
		
		
	}
	
	
	
	
}
