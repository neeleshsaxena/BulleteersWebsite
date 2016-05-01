package com.bulleteers.club;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bulleteers.club.dao.MemberDao;
import com.bulleteers.club.dao.MessageDao;
import com.bulleteers.club.dao.RideDao;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Message;
import com.bulleteers.club.pojo.Ride;

@Controller
public class AddRideController {
	
	@Autowired
	RideDao rideDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MessageDao messageDao;
	
	
	
	//Request to create a new ride
	@RequestMapping(value = "/rideRegister", method = RequestMethod.POST)
	public String addRide(@ModelAttribute("ride") Ride ride,HttpServletRequest request) throws ParseException
	{
		HttpSession session = request.getSession();
		
		
		
		
	
		
		Club club = (Club)session.getAttribute("club");
		Member member = (Member)session.getAttribute("member");//send invitations to all except this member
		
		Ride newRide = rideDao.addRide(ride, club,member);
		
		
		Club club1 = memberDao.getClub(member);
		Set<Ride> rides = memberDao.getRide(club);
		List<Message> messages = messageDao.getNotification(member);
		int count = messages.size();
		

		session.setAttribute("member", member);
		session.setAttribute("club", club);
		session.setAttribute("rides", rides);
		session.setAttribute("notification", messages);
		session.setAttribute("count", count);

		
		
		return "memberhome";
		
	}
	
	//ajax call to check if user exists
//		@RequestMapping(value="/addridebe", method = RequestMethod.POST)
//		public @ResponseBody String sendclub(@RequestParam("description") String description,@RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate,@RequestParam("days") int days,@RequestParam("captain") String captain,HttpServletRequest request){
//			
//			try{
//			
//				HttpSession session = request.getSession();
//				
//				
//				Club club = (Club)session.getAttribute("club");
//				Member member = (Member)session.getAttribute("member");
//				
//				Ride ride = new Ride();
//				ride.setDays(days);
//				ride.setDescription(description);
//				//ride.setEnddate(enddate);
//				ride.setRoadcaptain(captain);
//				//ride.setStartdate(startdate);
//				
//				StringBuffer result = new StringBuffer("");
//				
//				rideDao.addRide(ride, club,member);
//				
//				Set<Ride> rides = club.getRide();
//				
//				for(Ride ride1:rides){
//					
//					
//				result = result.append("<div class='row'><div class='purplebox'><div class='col-lg-12'><hr><h2 class='intro-text text-center'><strong>${ride.description}</strong>"+
//		                "</h2><hr><div class='row'><div class='col-lg-6'><label>Ride Road Captain</label><br/><p>${ride.roadcaptain }</p></div>"+
//		     			"<div class='col-lg-6'><label>Ride Duration</label><p>${ride.days }</p></div></div><div class='row'><div class='col-lg-6'>"+
//		               	"<label>Ride StartDate</label><br/><p>${ride.startdate }</p></div><div class='col-lg-6'><label>Ride EndDate</label>"+
//		     			"<p>${ride.enddate }</p></div></div></div></div></div>");	
//					
//					
//				}
//				
//				return result.toString();
//				
//				
//			}
//			catch(Exception e){
//				System.out.println("Error:" +e.getMessage() );
//				return "null";
//			}
//			
//		}
		
		
		//ajax call to join a ride
		@RequestMapping(value="/joinRide", method = RequestMethod.POST)
		public @ResponseBody String join(@RequestParam("rideId") String rideId,HttpServletRequest request){
			
			try{
			HttpSession session = request.getSession();
			
			Member member = (Member)session.getAttribute("member");
			
			String returnData = memberDao.addMemberToRide(rideId, member);
			
			if (returnData.equalsIgnoreCase("added") || returnData.equalsIgnoreCase("alreadyadded")){
				
				return returnData;
			}
			else
			return	"not added";
				
				
				
			
			}
			catch(Exception e){
				System.out.println("Error:" +e.getMessage() );
				return "null";
			}
			
		}

	
	

}
