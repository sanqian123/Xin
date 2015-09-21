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
	
	//�û���½
	
	/*1.����0Ϊ���Ŵ���
	 * 2.����1Ϊ��½�ɹ�
	 * 3.����2Ϊ������ȷ����½�������
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
			System.out.println("��¼ʧ�ܣ����Ŵ���");
			return "{\"login\":[{\"state\":\"0\"}]}";
		}else{
			System.out.println("������ȷ����֤��½����");
			if(user.getUpwd().equals(upwd)){
				System.out.println("������ȷ��");
				System.out.println("��½�ɹ���"+"���ţ�"+ucard+"��½���룺"+upwd);
				return "{\"login\":[{\"state\":\"1\"}]}";
			}else{
				System.out.println("��¼�������");
				return "{\"login\":[{\"state\":\"2\"}]}";
			}
		}

	}
	
	//֧��
	/*
	 * 1.����0Ϊ���Ŵ���
	 * 2.����1Ϊ֧���������
	 * 3.����2Ϊ����
	 * 4.����3Ϊ֧���ɹ�
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
			System.out.println("֧��ʧ�ܣ����Ŵ���");
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
					System.out.println("֧���ɹ���");
					String newdetail=detail.getUdetail()+"ת��"+money;
					detail.setUdetail(newdetail);
					session.update(detail);
					System.out.println("��ϸ�����ɹ���");
					t.commit();
					return "{\"pay\":[{\"state\":\"3\"}]}";
				}else{
					System.out.println("���㣡���ֵ");
					return "{\"pay\":[{\"state\":\"2\"}]}";
				}
			}else{
				System.out.println("֧��ʧ�ܣ�֧���������");
				return "{\"login\":[{\"state\":\"1\"}]}";
			}
		}
	}
	//�˿�
	@GET
	@Path("backmoney/{ucard},{money}")
	@Produces(MediaType.APPLICATION_JSON)
	public String backmoney(@PathParam("ucard") String ucard,@PathParam("money") float money){
		
		return "";
	}
	
}
