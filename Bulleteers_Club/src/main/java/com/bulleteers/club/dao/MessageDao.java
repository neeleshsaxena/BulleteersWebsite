package com.bulleteers.club.dao;

import java.util.List;

import org.hibernate.Query;

import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Message;

public class MessageDao extends DAO{
	
	
	public boolean sendMessage(String text, String p,Member fromMember){
		try{
			
			String toPerson = p.trim();
			
		begin();
		//search toPerson
		Query q = getSession().createQuery("from Person where firstName=:name");
		q.setParameter("name", toPerson);
		Member toMember = (Member)q.uniqueResult();
		
		
		Message mess = new Message();
		mess.setFromPerson(fromMember);
		mess.setToPerson(toMember);
		mess.setIsseen(false);
		mess.setText(text);
		
		getSession().save(mess);
		
		commit();
		
		System.out.println("Message is saved in hibernate");
		
		
		
		
		
		}
		catch(Exception e ){
			System.out.println("Error is: "+ e.getMessage());
			
		}
		
		
		return true;
		
		
	}
	
	public List<Message> getNotification(Member member){
		try{
		begin();
		
		Query q = getSession().createQuery("from Message where toPerson=:mem and isseen=0");
		q.setParameter("mem", member);
		List<Message> messages = q.list();
		
		
		System.out.println("fetched messages");
		
		return messages;
		
		}
		catch(Exception e){
			System.out.println("Error:" +e.getMessage());
		}
		return null;
		
	}
	
	public void setNotifyCount(List<Message> messages){
		try{
		begin();
		for(Message mess: messages){
			
			mess.setIsseen(true);
			getSession().update(mess);
			
		}
		commit();
		
		}
		catch(Exception e){
			System.out.println("Error : " +e.getMessage());
		}
		
	}
	

}
