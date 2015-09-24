<%@ page language="java" import="java.util.*,com.sk.pojo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manager2.jsp' starting page</title>
    
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
     <form action="LeavaServlet?flag=daoyuan" name="formAdd" method="post">
			<% 
    ArrayList al=(ArrayList)request.getAttribute("result");
  %>
  <table width="800" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="15" background="<%=path %>/images/tbg.gif">&nbsp;我的请假条&nbsp;</td>
				</tr>
				 
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">假条ID</td>
					<td width="10%">请假学号</td>
					<td width="10%">请假人</td>
					<td width="15%">请假原因</td>
					<td width="20%">开始时间</td>
					<td width="20%">结束时间</td>
					<td width="10%">审批</td>
		        </tr>	
		        <%
		         for(int i=0;i<al.size();i++){
		         Qingjia ep=(Qingjia)al.get(i);
		         %>
		        
				<tr >
					 
					<td bgcolor="#FFFFFF" align="center">
					  <%=ep.getLid() %> 
					</td>
					 
					<td bgcolor="#FFFFFF" align="center">
				 <%=ep.getUid() %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
				 <%=ep.getName() %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
				 <%=ep.getReason() %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					 <%=ep.getStarttime() %>
					</td>
					<td bgcolor="#FFFFFF" align="center">
				    <%=ep.getEndtime() %>
					</td>
					 
					 
					<td bgcolor="#FFFFFF" align="center">
					<a href="LeavaServlet?flag=zhuty&lid=<%=ep.getLid() %>&uid=<%=ep.getUid() %>"/>同意</a><br>
					<a href="LeavaServlet?flag=zhuno&lid=<%=ep.getLid() %>&uid=<%=ep.getUid() %>"/>不同意</a>
					</td>
				</tr>

			<%} %>
			</table>	      
			</form>
			<br>
			<table bgcolor="#D9EDF7">
     <tr width="800" height="100">
     <td width="800"><center> <font color="#6489AF"><h2>山东科技大学</h2></font>
     </center></td>
     </tr>
     </table>
     </center>
    
  </body>
</html>
