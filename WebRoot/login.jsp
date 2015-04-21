<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
  </head>
  
  <body>
      <s:form action="login">
         <table border="0">
             <tr><s:textfield  label="用户名" name="u.username"></s:textfield></tr>
             <tr><s:textfield  label="密码" name="u.password"></s:textfield></tr>
             <tr><td colspan="2"><s:submit value="登录" align="center"></s:submit></td></tr>
         </table>
       
      </s:form>
      <a href="register.jsp">去注册</a>
  </body>
</html>
