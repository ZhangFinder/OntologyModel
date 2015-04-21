<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>注册页面</title>



	</head>

	<body>
	  
		    <s:form action="register">
         <table border="0">
             <tr><td colspan="2" align="center">欢迎注册</td></tr>
             <tr><s:textfield  label="用户名" name="u.username"></s:textfield></tr>
             <tr><s:textfield  label="密码" name="u.password"></s:textfield></tr>
             <tr><td colspan="2"><s:submit value="注册" align="center"></s:submit></td></tr>
         </table>
       
      </s:form>
	</body>
</html>
