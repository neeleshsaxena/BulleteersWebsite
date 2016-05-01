package com.bulleteers.club.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;

import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Item;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Ride;

public class RideDao extends DAO{
	
	
	public Ride addRide(Ride ride,Club club,Member member){
		
		begin();
		
		//fetch club rides
		Set<Ride> rides = club.getRide();
		
	
		
		//add new ride to the club ride list
		rides.add(ride);
		ride.setClubId(club);
		
		//create members for the ride
		Set<Member> members = new HashSet<Member>();
		members.add(member);   //add the member to the new ride
		ride.setMember(members);
		
		//fetch the members ride list
		Set<Ride> rides1 = member.getRide();
		if(rides1!=null){
			
			rides1.add(ride);      //add the ride to the members rides
			
		}
		else{
			rides1 = new HashSet<Ride>();
			rides1.add(ride);
		}
		
	
		
		
		//put logic to send invites
		
		getSession().merge(member);
		//getSession().merge(ride);
		
		
		
	
		commit();
		
		return ride;
		
		
	}
	
	public Ride getRide(Long id){
		try{
			begin();
			
			Query q = getSession().createQuery("from Ride where rideId=:id");
			
			q.setParameter("id", id);
			Ride ride = (Ride)q.uniqueResult();		
			
			
			
			return ride;
			
			
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
			return null;
		}
		
		
		
		
	}
	
	
	public void updateRide(Ride ride){
		try{
			
		
		begin();
		
		getSession().merge(ride);
		
		commit();
		
		System.out.println("image saved in database");
		
		}
		catch(Exception e ){
			System.out.println("Error in saving image"+ e.getMessage());
		}
		
	}
	
	
	

}
