package com.bulleteers.club.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.bulleteers.club.pojo.Item;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Order;
import com.bulleteers.club.pojo.Product;

public class ProductDao extends DAO{
	
	
	public Member buyItem(Item item, Member member){
		
		try{
			begin();
			
			//List<Item> items;
		
			Product product = new Product(item.getName(),item.getPrice(),item.getQuantity());
			
			//add to the order table
			
			
			Order order = new Order();
			
			order.setProduct(product);
			order.setMember(member);
			
			if(member.getOrder()!=null){
				member.getOrder().add(order);
				
			}else{
				List<Order> orders = new ArrayList<Order>();
				orders.add(order);
				member.setOrder(orders);
				
			}
			
			//////////////////////////
			
			
		
			//fetch quantity from the db
			Query q = getSession().createQuery("from Item where Id=:id ");
			q.setParameter("id", item.getId());
			Item originalItem = (Item)q.uniqueResult();
			
			int quantBought = item.getQuantity();
			int availQuant = originalItem.getQuantity();
			//
			//set new quantity
			originalItem.setQuantity(availQuant-quantBought);
			member.getRide();
			
			//save member, order and original item to hibernate
			
			/*getSession().update(originalItem);
			getSession().save(order);*/
			getSession().merge(member);
			getSession().update(originalItem);
			//getSession().merge(originalItem);
			
			commit();
			
			System.out.println("Member, order, and item stored in hibernate");
			
			return member;
			
		}
		catch(Exception e){
			
			System.out.println("Error in buying item" + e.getMessage());
		}
	return null;
		
		
	}
	
	
	public List<Item> getItems(){
		
		try{
			Query q = getSession().createQuery("from Item");
			List<Item> items = q.list();
			
			return items;
			
		}
		catch(Exception e){
			System.out.println("Error " + e.getMessage());
		}
		return null;
		
		
	}
	

}
