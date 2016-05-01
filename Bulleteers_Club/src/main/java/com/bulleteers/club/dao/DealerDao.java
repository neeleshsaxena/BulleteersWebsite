package com.bulleteers.club.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.bulleteers.club.exception.AdException;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Dealer;
import com.bulleteers.club.pojo.Item;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Role;
import com.bulleteers.club.pojo.UserAccount;

public class DealerDao extends DAO{
	
	
	public Dealer saveDealer(Dealer dealer){
		
		try{
			if(findMember(dealer.getUsername())){
				//member already exists
				return null;
			}
			else{
					begin();
				
				//make useraccount and save dealer;
				UserAccount ua = new UserAccount();
				//Person person = new Person();
				
				//Set<Role> roles = new HashSet<Role>();
				Role r1 = new Role("dealer");
				
				//roles.add(r1);
				
				ua.setUsername(dealer.getUsername());
				ua.setPassword(dealer.getPassword());
				ua.setRole(r1);
				
				
				dealer.setUserAccount(ua);
				ua.setPerson(dealer);
				
				
				
				
				getSession().save(dealer);
				commit();
				
				return dealer;
			
			
			}
		}catch(Exception e){
			
			System.out.println("Error in dealerDAO:" +e.getMessage());
		}
		
		return null;
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


	public Dealer addItem(Item item,Dealer dealer){
		
		try{
		begin();
		//List<Item> items;
		dealer = getDealer(dealer.getPersonID());
		
		if(dealer.getItems()!=null){
			dealer.getItems().add(item);
					
		}
		
		else{
			List<Item>	items = new ArrayList<Item>();
			items.add(item);
			dealer.setItems(items);
		}
		
		
		
		
		
		getSession().merge(dealer);
		
		
		commit();
		System.out.println("Item saved");
		
		dealer = getDealer(dealer.getPersonID());
		
		return dealer;
		
		}
		catch(Exception e){
			
			System.out.println("Error in saving item:" +e.getMessage());
		}
		
		return null;
		
		
	}
	
public Dealer editItem(Item item,Dealer dealer){
		
		try{
		begin();
		
		/*boolean flag=false;
		List<Item> items = dealer.getItems();
		Item item1 = new Item();
		
		for(Item i:items){
			if(i.equals(item)){
				item1=i;
				flag=true;
				break;
				
			}
		}*/
		
		
		
		if(item.getPrice()!=0 || item.getQuantity() != 0){
			getSession().update(item);
			
			System.out.println("Item saved");
		}
		 
		
		commit();
		
		
		dealer = getDealer(dealer.getPersonID());
		
		
		
		return dealer;
		
		}
		catch(Exception e){
			
			System.out.println("Error in saving item:" +e.getMessage());
		}
		
		
		return null;
		
	}
	
	public Dealer getDealer(long id){
		try{
			begin();
			
			Query q = getSession().createQuery(" from Dealer where personID =:id");
			q.setParameter("id", id);
			
			Dealer dealer= (Dealer) q.uniqueResult();
			
			return dealer;
			
			
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
			return null;
		}
		
		
		
		
	}
	
	
//	public List<Item> getItems(Dealer dealer){
//		
//		try{
//			
//			//Query q = getSession().createQuery("from Item")
//			
//			
//		}
//		
//		catch(Exception e){
//			System.out.println("Error " + e.getMessage());
//		}
//		
//		
//	}
	
	
	

}
