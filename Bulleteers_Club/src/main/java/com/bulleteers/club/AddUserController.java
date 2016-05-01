package com.bulleteers.club;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hamcrest.core.IsNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindingResult;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Message;
import com.bulleteers.club.pojo.Ride;
import com.bulleteers.club.validators.MemberValidator;
import com.bulleteers.club.dao.MemberDao;
import com.bulleteers.club.dao.MessageDao;
import com.bulleteers.club.dao.RideDao;
import com.bulleteers.club.dao.UserDao;
import com.bulleteers.club.exception.AdException;


@Controller
public class AddUserController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberValidator memberValidator;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RideDao rideDao;
	
	@Autowired
	MessageDao messageDao;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(memberValidator);
	}
	
	private String errorMsg;
	
	private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);
	
	@RequestMapping(value = "/addMember", method = RequestMethod.GET)
	public String home(@ModelAttribute("member") Member member,BindingResult result, HttpServletRequest request) {
		
		List<Club> list = userDao.clubList();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		logger.info("Welcome Member!");
		
		return "addMember";
	}
	
	@RequestMapping(value = "/addMemberDetails", method = RequestMethod.POST)
	public String addMember(@ModelAttribute("member") Member member, BindingResult result,HttpServletRequest request) throws AdException {
		memberValidator.validate(member, result);
		if(result.hasErrors()){
			return "addMember";
		}
		
		
		logger.info("Add Member details!");
		HttpSession session = request.getSession();
		
		Member mem = memberDao.saveMember(member);
		Club club = memberDao.getClub(mem);
		Set<Ride> rides = memberDao.getRide(club);
		List<Message> messages = messageDao.getNotification(mem);
		int count = messages.size();
		
		if(mem!=null){
			System.out.println("Member saved in hibernate");
			//save in session object
			
			session.setAttribute("member", mem);
			session.setAttribute("club", club);
			session.setAttribute("rides", rides);
			session.setAttribute("notification", messages);
			session.setAttribute("count", count);
			
			return "memberhome";
		}
		else
			errorMsg = "Member already exists";
			request.setAttribute("error", errorMsg);
		
			return "addMember";
		
	}
	
	
	//ajax call to check if user exists
	@RequestMapping(value="/validateUser", method = RequestMethod.POST)
	public @ResponseBody String sendclub(@RequestParam("user") String user){
		
		try{
		
		boolean val = memberDao.findMember(user);
		
		if(val){
			 String returnData = "exists";
			 return returnData;
		}
		else{
			String returnData = "nonExists";
			return returnData;
		}
		}
		catch(Exception e){
			System.out.println("Error:" +e.getMessage() );
			return "null";
		}
		
	}
	
	@RequestMapping(value = "/redirectToHome", method = RequestMethod.GET)
	public String returnHome(@ModelAttribute("member") Member m,BindingResult result,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		if(session.getAttribute("member")!=null){
		
		Member member = (Member)session.getAttribute("member");
		Club club = memberDao.getClub(member);
		Set<Ride> rides = memberDao.getRide(club);
		List<Message> messages = messageDao.getNotification(member);
		int count = messages.size();
		
		session.setAttribute("member", member);
		session.setAttribute("club", club);
		session.setAttribute("rides", rides);
		session.setAttribute("notification", messages);
		session.setAttribute("count", count);
		
		
		return"memberhome";
		
		
		}
		else{
			return "home";
		}
	}
	
	@RequestMapping(value = "/addMemberDetails", method = RequestMethod.GET)
	public String addMember(){
		
		return"home";
		
		
		
		
		
	}
	

	
	
}
