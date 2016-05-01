package com.bulleteers.club.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.bulleteers.club.exception.AdException;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Person;
import com.bulleteers.club.pojo.Role;
import com.bulleteers.club.pojo.UserAccount;

@Component
public class UserDao extends DAO {

	public UserDao() {
    }

	public UserAccount findByUserName(String username, String password) throws AdException {
		
		
		try{


		Query q = getSession().createQuery("from UserAccount where username=:user and password=:pass");
		q.setString("user", username);
		q.setString("pass", password);
		UserAccount ua= (UserAccount) q.uniqueResult();
		
		if(ua!=null){
			
		
		if(ua.getuId()!=0){
			System.out.println(ua.getuId());
			return ua;
		}
		
		return null;
		
		}
		return null;
		
		}
		catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
		
	}
	
    
	public List<Club> clubList(){
		begin();
		Query q = getSession().createQuery("select clubName from Club");
		List l = q.list();
		close();
		
		return l;
		
		
	}
    public Person create(String username, String password,String emailId, String firstName, String lastName)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
           
            Person person = new Person();
            
            person.setFirstName(firstName);
            person.setLastName(lastName);
            
            
         
            
            getSession().save(person);
            
            commit();
            return person;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

	
    public Member getMember(long id){
		try{
			begin();
			
			Query q = getSession().createQuery(" from Member where personID =:id");
			q.setParameter("id", id);
			
			Member member = (Member) q.uniqueResult();
			
			return member;
			
			
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
			return null;
		}
		
		
		
		
	}
	
}
