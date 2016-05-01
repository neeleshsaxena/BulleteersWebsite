package com.bulleteers.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bulleteers.club.dao.MessageDao;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Message;

@Controller
public class AddMessageController {
	
	@Autowired
	MessageDao messageDao;
	
	//ajax call to send a message
			@RequestMapping(value="/sendMessage", method = RequestMethod.POST)
			public @ResponseBody String join(@RequestParam("toPerson") String toPerson,@RequestParam("text") String text,HttpServletRequest request){
				
				try{
					
					String returnData;
					
				HttpSession session = request.getSession();
				
				Member member = (Member)session.getAttribute("member");
				
				 
				
				if (messageDao.sendMessage(text, toPerson, member)){
					
					return returnData="sort";
				}
				else
				return	returnData= "not added";
					
				
					
				
				}
				catch(Exception e){
					System.out.println("Error:" +e.getMessage() );
					return "null";
				}
				
			}
			
			
			//ajax call to set notification count
			@RequestMapping(value="/readNotification", method = RequestMethod.POST)
			public @ResponseBody String notify(@RequestParam("msg") String msg,HttpServletRequest request){
				
				try{
					
					String returnData;
					
				HttpSession session = request.getSession();
				
				Member member = (Member)session.getAttribute("member");
				List<Message> messages = messageDao.getNotification(member);
				messageDao.setNotifyCount(messages);
				
				
				return returnData="sort"; 
					
				
				}
				catch(Exception e){
					System.out.println("Error:" +e.getMessage() );
					return "null";
				}
				
			}

}
