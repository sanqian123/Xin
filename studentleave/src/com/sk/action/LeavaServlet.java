package com.sk.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sk.service.LeaveService;
import com.sk.service.LoginService;
import com.sk.tools.Tool;

public class LeavaServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("login")){
			 int u=Integer.parseInt(request.getParameter("uid"));
			 String p=request.getParameter("password");
			 LoginService use=new LoginService();
			 boolean b=use.checkUser(u, p);
			 if(b){
				//合法 
				 //将用户名放入session
				 request.getSession().setAttribute("u", u);
				// response.sendRedirect("index.jsp");
				 request.getRequestDispatcher("index.jsp").forward(request, response);
			 }else{
				//不合法 
				 String type="用户名或密码错误，请重新登入，谢谢！";
				 request.getSession().setAttribute("type",type );
				 request.getRequestDispatcher("login.jsp").forward(request, response);
			 }
			
		}else if(flag.equals("add")){
			int uid=Integer.parseInt(request.getParameter("uid"));
			String name=Tool.getNewString(request.getParameter("name"));
			String reason=Tool.getNewString(request.getParameter("reason"));
			String starttime=Tool.getNewString(request.getParameter("starttime"));
			String endtime=Tool.getNewString(request.getParameter("endtime"));
			LeaveService ls=new LeaveService();
			if(ls.addGoods(uid, name, reason, starttime, endtime)){
				 request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else if(flag.equals("select")){
			int uid=Integer.parseInt(request.getParameter("uid"));
			LeaveService ls=new LeaveService();
			ArrayList al=ls.getOneJiantiaoall(uid);
			 request.setAttribute("result",al);
			 request.getRequestDispatcher("myleave.jsp").forward(request, response);
		}else if(flag.equals("daoyuan")){
			int uid=Integer.parseInt(request.getParameter("uid"));
			LeaveService ls=new LeaveService();
			if(ls.DaoPower(uid)){
				ArrayList al=ls.getJiantiaoall();
				 request.setAttribute("result",al);
				 request.getRequestDispatcher("manager.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("power.jsp").forward(request, response);
			}
		}else if(flag.equals("director")){
			int uid=Integer.parseInt(request.getParameter("uid"));
			LeaveService ls=new LeaveService();
			if(ls.ZhuPower(uid)){
				ArrayList al=ls.getZhurenJiantiaoall();
				 request.setAttribute("result",al);
				 request.getRequestDispatcher("manager2.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("power.jsp").forward(request, response);
			}
		}else if(flag.equals("daoty")){
			int lid=Integer.parseInt(request.getParameter("lid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			LeaveService ls=new LeaveService();
			boolean b=ls.Daoyuanshenpity(lid, uid);
			if(b=true){
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else if(flag.equals("daono")){
			int lid=Integer.parseInt(request.getParameter("lid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			LeaveService ls=new LeaveService();
			boolean b=ls.DaoyuanshenpiNo(lid, uid);
			if(b=true){
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else if(flag.equals("zhuty")){
			int lid=Integer.parseInt(request.getParameter("lid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			LeaveService ls=new LeaveService();
			boolean b=ls.ZhurenshenpiYes(lid, uid);
			if(b=true){
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else if(flag.equals("zhuno")){
			int lid=Integer.parseInt(request.getParameter("lid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			LeaveService ls=new LeaveService();
			boolean b=ls.ZhurenshenpiNo(lid, uid);
			if(b=true){
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else if(flag.equals("flow")){
			int lid=Integer.parseInt(request.getParameter("lid"));
			LeaveService ls=new LeaveService();
			ArrayList al=ls.getFlow(lid);
			 request.setAttribute("result",al);
			 request.getRequestDispatcher("flow.jsp").forward(request, response);
			
		}else if(flag.equals("")){
			
		}else if(flag.equals("")){
			
		}
		 
	}

}
