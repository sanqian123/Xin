package com.sk.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginService {
	private final static String  URL = "jdbc:mysql://localhost:3306/flow";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "123456";
	
	private Connection cn=null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public boolean  checkUser(int u,String p){
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			st = cn.createStatement();
			rs=st.executeQuery("select password from uesr where uid="+u+"");
			//根据结果判断
			if(rs.next()){
				//用户存在 
				if(rs.getString(1).equals(p)){
					b=true;
				} 
			}		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	}
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

}
