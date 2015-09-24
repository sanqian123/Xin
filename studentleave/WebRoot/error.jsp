<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
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
    <table bgcolor="#D9EDF7">
     <tr width="800" height="150">
     <td width="800"><center> <font color="#6489AF"><h1>学生请假系统</h1></font></center></td>
     </tr>
     </table>
     <br>
     <table bgcolor="#D9EDF7">
     <tr width="800" height="10">
     <td width="800"><center> 
     <a href="index.jsp"><font color="#6489AF"><strong>首页</strong></font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="LeavaServlet?flag=select&uid=<%=(Integer)session.getAttribute("u") %>"><font color="#6489AF"><strong>我的假条</strong></font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="LeavaServlet?flag=daoyuan&uid=<%=(Integer)session.getAttribute("u") %>"><font color="#6489AF"><strong>导员审批</strong></font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="LeavaServlet?flag=director&uid=<%=(Integer)session.getAttribute("u") %>"><font color="#6489AF"><strong>主任审批</strong></font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <font color="#6489AF">欢迎您,<%=(Integer)session.getAttribute("u") %></font> 
     </center></td>
     </tr>
     </table>
     <br>
    <font color="#6489AF">  <h1>操作失败</h1></font>
			<br>
			<table bgcolor="#D9EDF7">
     <tr width="800" height="100">
     <td width="800"><center> <font color="#6489AF"><h2>山东科技大学</h2></font>
     </center></td>
     </tr>
     </table>
     </center>
    
  </body></html>
