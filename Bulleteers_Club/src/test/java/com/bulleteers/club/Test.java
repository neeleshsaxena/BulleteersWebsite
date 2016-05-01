package com.bulleteers.club;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bulleteers.club.dao.DAO;
import com.bulleteers.club.pojo.Club;
import com.bulleteers.club.pojo.Member;
import com.bulleteers.club.pojo.Ride;
import com.bulleteers.club.pojo.Role;
import com.bulleteers.club.pojo.UserAccount;


public class Test {
	
	
	
	public static void main(String args[]) throws ParseException{
		
		DAO dao = new DAO();
		
		Transaction t = dao.getSession().beginTransaction();
		
		
		
		
		//***************create Members*****************
		Member m1 = new Member();
		m1.setBike("Enfield");
		m1.setDob(new Date());
		m1.setEmail("saxena.neelesh@yahoo.com");
		m1.setFirstName("Neelesh");
		m1.setGender("Male");
		m1.setLastName("Saxena");
		
		
		Member m2 = new Member();
		m2.setBike("Enfield");
		m2.setDob(new Date());
		m2.setEmail("kandi.singh@yahoo.com");
		m2.setFirstName("kandi");
		m2.setGender("Male");
		m2.setLastName("Punj");
		
		Member m3 = new Member();
		m3.setBike("Enfield");
		m3.setDob(new Date());
		m3.setEmail("kunal.singh@yahoo.com");
		m3.setFirstName("Kunal");
		m3.setGender("Male");
		m3.setLastName("Deora");
		
		Member m4 = new Member();
		m4.setBike("Enfield");
		m4.setDob(new Date());
		m4.setEmail("manasi.singh@yahoo.com");
		m4.setFirstName("Manasi");
		m4.setGender("Female");
		m4.setLastName("Laddha");
		
		//*******************create user role*************************
		//Set<Role> rList1 = new HashSet<Role>();
		Role role1 = new Role();
		role1.setRole("member");
//		Role role12 = new Role();
//		role12.setRole("admin");
//		rList1.add(role1);
//		rList1.add(role12);

		//Set<Role> rList2 = new HashSet<Role>();
		Role role2 = new Role();
		role2.setRole("member");
		//rList2.add(role2);

		//Set<Role> rList3 = new HashSet<Role>();
		Role role3 = new Role();
		role3.setRole("member");
		//rList3.add(role3);

		//Set<Role> rList4 = new HashSet<Role>();
		Role role4 = new Role();
		role4.setRole("member");
		//rList4.add(role4);
		
		//*********************create useraccount and associate members
		UserAccount ua1 = new UserAccount();
		ua1.setUsername("Neel");
		ua1.setPassword("pass");
		ua1.setRole(role1);
		m1.setUserAccount(ua1);
		ua1.setPerson(m1);
		

		UserAccount ua2 = new UserAccount();
		ua2.setUsername("kandi");
		ua2.setPassword("pass");
		ua2.setRole(role2);
		m2.setUserAccount(ua2);
		ua2.setPerson(m2);
		
		
		UserAccount ua3 = new UserAccount();
		ua3.setUsername("kunal");
		ua3.setPassword("pass");
		ua3.setRole(role3);
		m3.setUserAccount(ua3);
		ua3.setPerson(m3);
		
		
		UserAccount ua4 = new UserAccount();
		ua4.setUsername("manasi");
		ua4.setPassword("pass");
		ua4.setRole(role4);
		m4.setUserAccount(ua4);
		ua4.setPerson(m4);
		
		
		//********start date for rides****************
		String input1 = "2015-02-24";
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date st1 = dateFormat1.parse(input1);
		
		String input2 = "2015-06-24";
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date st2 = dateFormat2.parse(input2);
		String input3 = "2015-07-24";
		DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
		Date st3 = dateFormat3.parse(input3);
		String input4 = "2015-02-12";
		DateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
		Date st4 = dateFormat4.parse(input4);
		
		//********end date for rides****************
		String input5 = "2015-02-26";
		DateFormat dateFormat5 = new SimpleDateFormat("yyyy-MM-dd");
		Date st5 = dateFormat5.parse(input5);
		String input6 = "2015-06-28";
		DateFormat dateFormat6 = new SimpleDateFormat("yyyy-MM-dd");
		Date st6 = dateFormat6.parse(input6);
		String input7 = "2015-07-29";
		DateFormat dateFormat7 = new SimpleDateFormat("yyyy-MM-dd");
		Date st7 = dateFormat7.parse(input7);
		String input8 = "2015-02-20";
		DateFormat dateFormat8 = new SimpleDateFormat("yyyy-MM-dd");
		Date st8 = dateFormat8.parse(input8);
		
		//*****************create list of members for a ride*************************
		
		
		Set<Member> members1 = new HashSet<Member>();
		
		members1.add(m1);
		members1.add(m2);
		
		
		Set<Member> members2 = new HashSet<Member>();
		members2.add(m3);
		members2.add(m4);
		
		
		
		//*****************create rides*************************
		Set<Ride> rides1 = new HashSet<Ride>();
		Ride r1 = new Ride();
		r1.setDays(3);
		r1.setDescription("Ride To Dallas");
		r1.setRoadcaptain("Neelesh");
		r1.setStartdate(st1);
		r1.setEnddate(st5);
		r1.setMember(members1);
		
		
		Ride r2 = new Ride();
		r2.setDays(4);
		r2.setDescription("Ride To Rhode Island");
		r2.setRoadcaptain("Neelesh");
		r2.setStartdate(st2);
		r2.setEnddate(st6);
		
		Set<Ride> rides2 = new HashSet<Ride>();
		
		Ride r3 = new Ride();
		r3.setDays(4);
		r3.setDescription("Ride To Vegas");
		r3.setRoadcaptain("Neelesh");
		r3.setStartdate(st3);
		r3.setEnddate(st7);
		r3.setMember(members2);
		
		
		Ride r4 = new Ride();
		r4.setDays(4);
		r4.setDescription("Ride To New York");
		r4.setRoadcaptain("Neelesh");
		r4.setStartdate(st4);
		r4.setEnddate(st8);
		
		rides1.add(r1);
		rides1.add(r2);
		rides2.add(r3);
		rides2.add(r4);
		m1.setRide(rides1);
		m4.setRide(rides2);
		
		//*******************create clubs*********************
		Club c1 = new Club();
		c1.setClubName("Mavericks");
		c1.setPresident("Neelesh");
		//c1.setRules("A Patchholder will not discuss any club business whether it's about membership numbers, club goings on, or any member's personal information with anyone outside of the club. They understand that they are a Patchholder 24 hours a day whether or not they are wearing their colors. Everything they say or do in public can affect the club. They also understand that if they get out of line, that they are subject to be counseled for their own good and for that of the club. Wearing a patch is more than getting together for good times. It also means getting together for the other times, too. It constitutes a lot of work. It's committing themselves to a lifestyle in which they do not look for how their brothers or sisters can help them, but for ways that they can be of help to their brothers and sisters. They always look to give rather than to receive. All of this may seem very idealistic, and in some cases it's just that. But it is an ideal that all clubs profess and are always striving for in principle and practice.");
		//c1.setTradition("A serious MC club commands respect for one reason. Those who are correctly informed recognize the deep level of personal commitment and self discipline that a man has to demonstrate and sustain in order to wear a patch. They realize that a club's+ "+"Colors"+"+ are closely guarded and the membership process is long and difficult. Other factors notwithstanding, they respect Patchholders for what they have accomplished by being able to earn and keep the patch they wear. This is respect born out of recognition of dedication and accomplishment. The MC Club strives for respect for this reason. ");
		c1.setTreasurer("Kandi");
		c1.setRide(rides1);
		r1.setClubId(c1);
		r2.setClubId(c1);
		Set<Member> mem1 = new HashSet<Member>();
		mem1.add(m1);
		mem1.add(m2);
		c1.setMember(mem1);
		m1.setClubId(c1);
		m2.setClubId(c1);
		
		
		Club c2 = new Club();
		c2.setClubName("Apache");
		c2.setPresident("Kunal");
		//c2.setRules("A Patchholder will not discuss any club business whether it's about membership numbers, club goings on, or any member's personal information with anyone outside of the club. They understand that they are a Patchholder 24 hours a day whether or not they are wearing their colors. Everything they say or do in public can affect the club. They also understand that if they get out of line, that they are subject to be counseled for their own good and for that of the club. Wearing a patch is more than getting together for good times. It also means getting together for the other times, too. It constitutes a lot of work. It's committing themselves to a lifestyle in which they do not look for how their brothers or sisters can help them, but for ways that they can be of help to their brothers and sisters. They always look to give rather than to receive. All of this may seem very idealistic, and in some cases it's just that. But it is an ideal that all clubs profess and are always striving for in principle and practice.");
		//c2.setTradition("A serious MC club commands respect for one reason. Those who are correctly informed recognize the deep level of personal commitment and self discipline that a man has to demonstrate and sustain in order to wear a patch. They realize that a club's+ "+"Colors"+"+ are closely guarded and the membership process is long and difficult. Other factors notwithstanding, they respect Patchholders for what they have accomplished by being able to earn and keep the patch they wear. This is respect born out of recognition of dedication and accomplishment. The MC Club strives for respect for this reason. ");
		c2.setTreasurer("Kandi");
		c2.setRide(rides2);
		r3.setClubId(c2);
		r4.setClubId(c2);
		Set<Member> mem2 = new HashSet<Member>();
		mem2.add(m3);
		mem2.add(m4);
		c2.setMember(mem2);
		m3.setClubId(c2);
		m4.setClubId(c2);
		
		System.out.println("test");
		dao.getSession().save(m1);
		dao.getSession().save(m2);
		dao.getSession().save(m3);
		dao.getSession().save(m4);
		System.out.println("test1");
		
		dao.getSession().save(c1);
		dao.getSession().save(c2);
		
		t.commit();
	dao.getSession().close();
		
	System.out.println("test2");
		
		
		
		
	}
	
	
	

}
