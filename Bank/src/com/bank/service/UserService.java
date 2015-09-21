package com.bank.service;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.factory.HibernateSessionFactory;
import com.bank.pojo.Detail;
import com.bank.pojo.User;

@Path("userservice")
public class UserService {
	
	//ÓÃ»§µÇÂ½
	
	/*1.·µ»Ø0Îª¿¨ºÅ´íÎó
	 * 2.·µ»Ø1ÎªµÇÂ½³É¹¦
	 * 3.·µ»Ø2Îª¿¨ºÅÕıÈ·£¬µÇÂ½ÃÜÂë´íÎó
	 * 
	 * */
	@GET
	@Path("login/{ucard},{upwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@PathParam("ucard") String ucard,@PathParam("upwd")String upwd){
		Session session=HibernateSessionFactory.getSession();
		String hql="from User u where u.ucard=?";
		Query query=session.createQuery(hql);
		query.setString(0, ucard);
		User user=(User)query.uniqueResult();
		if(user==null){
			System.out.println("µÇÂ¼Ê§°Ü£¡¿¨ºÅ´íÎó");
			return "{\"login\":[{\"state\":\"0\"}]}";
		}else{
			System.out.println("¿¨ºÅÕıÈ·£¡ÑéÖ¤µÇÂ½ÃÜÂë");
			if(user.getUpwd().equals(upwd)){
				System.out.println("ÃÜÂëÕıÈ·£¡");
				System.out.println("µÇÂ½³É¹¦£¡"+"¿¨ºÅ£º"+ucard+"µÇÂ½ÃÜÂë£º"+upwd);
				return "{\"login\":[{\"state\":\"1\"}]}";
			}else{
				System.out.println("µÇÂ¼ÃÜÂë´íÎó£¡");
				return "{\"login\":[{\"state\":\"2\"}]}";
			}
		}

	}
	
	//Ö§¸¶
	/*
	 * 1.·µ»Ø0Îª¿¨ºÅ´íÎó
	 * 2.·µ»Ø1ÎªÖ§¸¶ÃÜÂë´íÎó
	 * 3.·µ»Ø2ÎªÓà¶î²»×ã
	 * 4.·µ»Ø3ÎªÖ§¸¶³É¹¦
	 * */
	@GET
	@Path("pay/{ucard},{countpwd},{money}")
	@Produces(MediaType.APPLICATION_JSON)
	public String pay(String ucard,String countpwd,float money){
		Session session=HibernateSessionFactory.getSession();
		String hql="from User u where u.ucard=?";
		Query query=session.createQuery(hql);
		query.setString(0, ucard);
		User user=(User)query.uniqueResult();
		if(user==null){
			System.out.println("Ö§¸¶Ê§°Ü£¡¿¨ºÅ´íÎó");
			return "{\"pay\":[{\"state\":\"0\"}]}";
		}else{
			if(user.getCountpwd().equals(countpwd)){
				if(user.getUmoney()>=money){
					float newmoney=user.getUmoney()-money;
					Transaction t=session.beginTransaction();
					t.begin();
					user.setUmoney(newmoney);
					session.update(user);
					hql="from Detail d where d.uid=?";
					query=session.createQuery(hql);
					query.setInteger(0, user.getUid());
					Detail detail=(Detail)query.uniqueResult();
					System.out.println("Ö§¸¶³É¹¦£¡");
					String newdetail=detail.getUdetail()+"×ª³ö"+money;
					detail.setUdetail(newdetail);
					session.update(detail);
					System.out.println("Ã÷Ï¸²Ù×÷³É¹¦£¡");
					t.commit();
					return "{\"pay\":[{\"state\":\"3\"}]}";
				}else{
					System.out.println("Óà¶î²»×ã£¡Çë³äÖµ");
					return "{\"pay\":[{\"state\":\"2\"}]}";
				}
			}else{
				System.out.println("Ö§¸¶Ê§°Ü£¡Ö§¸¶ÃÜÂë´íÎó");
				return "{\"login\":[{\"state\":\"1\"}]}";
			}
		}
	}
	//ÍË¿î
	@GET
	@Path("backmoney/{ucard},{money}")
	@Produces(MediaType.APPLICATION_JSON)
	public String backmoney(@PathParam("ucard") String ucard,@PathParam("money") float money){
		
		return "";
	}
	
}
