<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="easyui/themes/default/easyui.css" />
		<link rel="stylesheet" href="easyui/themes/icon.css"/>
		<script src="easyui/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js" ></script>
		<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
		<script>
			$(function (){
				$('#age').numberbox({
					'min':18,
					'max':60,
					'precision':0
				});
				$('#start').datetimebox({
					'required':true,
					'missingMessage':'开始日期必须有',
					'editable':false
				});
				$('#end').datetimebox({
					'required':true,
					'missingMessage':'结束日期必须有',
					'editable':false
				});
				 
				$('#sal').numberbox({
					'precision':2
				});
				$('#city').combobox({
					'url':'getCityList.do',
					'valueField':'id',
					'textField':'cname'
				});
				$("#btn_save").click(function (){
					$('#ff').form('submit', {
						'url':'save.do',
						onSubmit: function(){
							if($('#ff').form('validate')){
								return true;
							}else{
								$.messager.alert('提示','表单校验未通过');
								return false;
							}
						},
						success:function(data){
							var data = $.parseJSON(data);
							$.messager.alert(data.title,data.message);
						}
					});
				});
			})
		</script>
	
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
     <form action="LeavaServlet?flag=add" name="formAdd" method="post">
				     <table width="800" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title'><span>创建请假条</span></td>
					    </tr>
					    <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="right">
						       学号:
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						       <input type="text" name="uid" class="easyui-validatebox"  required=true missingMessage='学号必须填写'/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="right">
						        姓名:
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						      <input type="text" name="name" class="easyui-validatebox"  required=true missingMessage='姓名必须填写'/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="right">
						        原因:
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						      	 <textarea rows="4" cols="30" name="reason" class="easyui-validatebox"  required=true missingMessage='原因必须填写'></textarea>
						    </td>
						</tr>
						 
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="right">
						        开始日期:
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						       <input type="text" name="starttime" id="start"/> 
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="right">
						        结束日期:
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						      <input type="text" name="endtime" id="end"/>
						    </td>
						</tr>
						 
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="提交"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
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
