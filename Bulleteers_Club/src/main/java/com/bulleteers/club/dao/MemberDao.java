package com.bulleteers.club.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Person;
import com.bulleteers.club.pojo.Ride;
import com.bulleteers.club.pojo.UserAccount;
import com.bulleteers.club.pojo.Role;
import com.bulleteers.club.exception.AdException;

@Component
public class MemberDao extends DAO{
	
	
	
	public Member saveMember(Member mem) throws  AdException{
		//check again if username exists
		
		try{
			
			String username = StringEscapeUtils.escapeHtml(mem.getUsername());
			String firstName =  StringEscapeUtils.escapeHtml(mem.getFirstName());
			String lastName = StringEscapeUtils.escapeHtml(mem.getLastName());
			String gender = StringEscapeUtils.escapeHtml(mem.getGender());
			String bike = StringEscapeUtils.escapeHtml(mem.getBike());
			String clubName = StringEscapeUtils.escapeHtml(mem.getClub());
			
			mem.setUsername(username);
			mem.setFirstName(firstName);
			mem.setLastName(lastName);
			mem.setGender(gender);
			mem.setClub(clubName);
			mem.setBike(bike);
			
			
			
		if(findMember(mem.getUsername())){
			//member already exists
			return null;
		}
		else{
				begin();
			//fetch club from the club name
				Query q = getSession().createQuery("from Club where clubName =:c");
				q.setString("c", mem.getClub());
				Club club = (Club) q.uniqueResult();
				Set<Member> members = club.getMember();
				
				
			//make useraccount and save member;
			UserAccount ua = new UserAccount();
			//Person person = new Person();
			
			//Set<Role> roles = new HashSet<Role>();
			Role r1 = new Role("member");
			
			//roles.add(r1);
			
			ua.setUsername(mem.getUsername());
			ua.setPassword(mem.getPassword());
			ua.setRole(r1);
			
			
			mem.setUserAccount(ua);
			ua.setPerson(mem);
			
			mem.setClubId(club);
			members.add(mem);
			//ua.setPerson(person);
			//mem.setUserAccount(ua);
			
			
			getSession().save(mem);
			commit();
			
			return mem;
			
		}
		
		}catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save Member " + mem.getFirstName(), e);
        }
		
	}
	
	public boolean findMember(String username) throws AdException{
		
		try{
		
		Query q = getSession().createQuery("from UserAccount where username=:user");
		q.setString("user", username);
		UserAccount ua= (UserAccount) q.uniqueResult();
		
		
		if(ua!=null){
			//true means it exists in db
			return true;
		}
		else{
			return false;
		}
		}
		catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
		
	}
	
	public Club getClub(Member mem){
		try{
			begin();
			
			Query q = getSession().createQuery("select clubId from Member m where m.personID =:m");
			q.setParameter("m", mem.getPersonID());
			
			Club club = (Club) q.uniqueResult();
			
			return club;
			
			
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
			return null;
		}
		
		
		
		
	}
	
	public Set<Ride> getRide(Club club){
		try{
			begin();
			
			Set<Ride> rides = club.getRide();
			
			
			
			return rides;
			
			
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
			return null;
		}
		
		
		
		
	}
	
	public String addMemberToRide(String rideId, Member member){
		
		begin();
		
	Long rId = Long.parseLong(rideId, 10) ;
		
		Query q = getSession().createQuery("from Ride where rideId =:ri");
		q.setParameter("ri", rId);
		Ride ride = (Ride)q.uniqueResult();
		
		//fetch members of the ride and the new member
		Set<Member> members = ride.getMember();
		for(Member m: members){
			if(m.getPersonID()==(member.getPersonID())){
				return "alreadyadded";
			}
		}
		members.add(member);
		
		//fetch the member's rides and add new ride
		Set<Ride> rides = member.getRide();
		
		if(rides!=null){
			rides.add(ride);
		}else{
			rides = new HashSet<Ride>();
			rides.add(ride);
		}
		
		
		
		getSession().merge(member);
		
		commit();
		System.out.println("ride added to the member");
		
		return "added";
		
		
		
		
		
	}
	
	
}
