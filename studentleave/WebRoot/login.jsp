<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <center>
       <table>
     <tr width="600" height="200">
     <td width="600"><center></font></center></td>
     </tr>
     </table>
    <table bgcolor="#D9EDF7">
     <tr width="600" height="10">
     <td width="600"><center> <font color="#6489AF"><h2>欢迎登录学生请假系统</h2></font></center></td>
     </tr>
     <tr width="600" height="150">
     <td width="600"><center>
     <form action="LeavaServlet?flag=login" method="post">
                                     账 号<input type="text" name="uid"><br>
                                     <br>
                                   密   码<input type="password" name="password">  <br>  <br>
             <input type="submit" value="登录"> &nbsp;
             <input type="reset" value="取消"> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             &nbsp;&nbsp;
             <font color="red"><%=(String)session.getAttribute("type") %></font>                                        
             
     </form>
     </center></td>
     </tr>
     </table>
     
     </center>
  </body>
</html>
