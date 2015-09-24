package com.sk.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sk.pojo.Flow;
import com.sk.pojo.Qingjia;

public class LeaveService {
	private final static String  URL = "jdbc:mysql://localhost:3306/flow";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "123456";
	
	private Connection cn=null;
	private Statement st = null;
	private ResultSet rs = null;
	
	private String dao;
	private String zhu;
	
	public void close(){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}if(cn!=null){
				cn.close();
				cn=null;
			}if(st!=null){
				st.close();
				st=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public boolean addGoods(int uid,String name,String reason,String starttime,String endtime ){
		boolean b=false;
		try {
			String daoyuan="未审批";
			String director="未审批";
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			int a=st.executeUpdate("insert into qingjia values(NULL,"+uid+",'"+name+"','"+reason+"','"+starttime+"','"+endtime+"','"+daoyuan+"','"+director+"')");
			if(a==1){
				b=true;	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	public ArrayList getOneJiantiaoall(int uid){
		ArrayList al=new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();	 
			//查询记录
			rs=st.executeQuery("select *from qingjia where uid="+uid+"");
			//将rs封装到集合
			while(rs.next()){	
				Qingjia dt=new Qingjia();
				dt.setLid(rs.getInt(1));
				dt.setUid(rs.getInt(2));
				dt.setName(rs.getString(3));
				dt.setReason(rs.getString(4));
				dt.setStarttime(rs.getString(5));
				dt.setEndtime(rs.getString(6));
				al.add(dt);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		
		return al;
		
	}

	
	public ArrayList getJiantiaoall(){
		ArrayList al=new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();	 
			String daoyuan="未审批";
			//查询记录
			rs=st.executeQuery("select *from qingjia where daoyuan='"+daoyuan+"'");
			//将rs封装到集合
			while(rs.next()){	
				Qingjia dt=new Qingjia();
				dt.setLid(rs.getInt(1));
				dt.setUid(rs.getInt(2));
				dt.setName(rs.getString(3));
				dt.setReason(rs.getString(4));
				dt.setStarttime(rs.getString(5));
				dt.setEndtime(rs.getString(6));
				al.add(dt);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		
		return al;
		
	}

	public ArrayList getZhurenJiantiaoall(){
		ArrayList al=new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();	 
			String daoyuan="导员同意";
			//查询记录
			rs=st.executeQuery("select *from qingjia where daoyuan='"+daoyuan+"'");
			//将rs封装到集合
			while(rs.next()){	
				Qingjia dt=new Qingjia();
				dt.setLid(rs.getInt(1));
				dt.setUid(rs.getInt(2));
				dt.setName(rs.getString(3));
				dt.setReason(rs.getString(4));
				dt.setStarttime(rs.getString(5));
				dt.setEndtime(rs.getString(6));
				al.add(dt);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		
		return al;
		
	}


	public boolean DaoPower(int uid){
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			rs=st.executeQuery("select identity from uesr where uid="+uid+"");
			if(rs.next()){	
				dao=rs.getString(1);
			}
			if(dao.equals("导员")){
				b=true;
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	}
	
	public boolean ZhuPower(int uid){
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			rs=st.executeQuery("select identity from uesr where uid="+uid+"");
			if(rs.next()){	
				dao=rs.getString(1);
			}
			if(dao.equals("主任")){
				b=true;
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	}
	
	public boolean Daoyuanshenpity(int lid,int uid){
		boolean b=false;
		try {
			String reply="导员同意";
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			int c=st.executeUpdate("insert into flow values(NULL,"+uid+","+lid+",'"+reply+"')");
			int a=st.executeUpdate("update qingjia set daoyuan='"+reply+"'where lid="+lid+"");
			if(a==1&&c==1){
				b=true;}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	}
	public boolean DaoyuanshenpiNo(int lid,int uid){
		boolean b=false;
		try {
			String reply="导员不同意";
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			int c=st.executeUpdate("insert into flow values(NULL,"+uid+","+lid+",'"+reply+"')");
			int a=st.executeUpdate("update qingjia set daoyuan='"+reply+"'where lid="+lid+"");
			if(a==1&&c==1){
				b=true;}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	}
	
	public boolean ZhurenshenpiYes(int lid,int uid){
		boolean b=false;
		try {
			String reply="主任同意";
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			int c=st.executeUpdate("insert into flow values(NULL,"+uid+","+lid+",'"+reply+"')");
			int a=st.executeUpdate("update qingjia set daoyuan='"+reply+"'where lid="+lid+"");
			if(a==1&&c==1){
				b=true;}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	}
	public boolean ZhurenshenpiNo(int lid,int uid){
		boolean b=false;
		try {
			String reply="主任不同意";
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			int c=st.executeUpdate("insert into flow values(NULL,"+uid+","+lid+",'"+reply+"')");
			int a=st.executeUpdate("update qingjia set daoyuan='"+reply+"'where lid="+lid+"");
			if(a==1&&c==1){
				b=true;}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	}
	
	public ArrayList getFlow(int lid){
		ArrayList al=new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();	 
			//查询记录
			rs=st.executeQuery("select *from flow where lid="+lid+"");
			//将rs封装到集合
			while(rs.next()){	
				Flow dt=new Flow();
				dt.setUid(rs.getInt(2));
				dt.setLid(rs.getInt(3));
				dt.setReply(rs.getString(4));
				al.add(dt);		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		
		return al;
		
	}

}
