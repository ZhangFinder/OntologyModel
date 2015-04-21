<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户密码</title>
</head>
<body>
    <s:form action="updateUser">
         <table border="0">
             <tr><s:textfield  label="用户名" name="u.username"></s:textfield></tr>
             <tr><s:textfield  label="新密码" name="u.password"></s:textfield></tr>
             <tr><td colspan="2"><s:submit value="修改用户密码" align="center"></s:submit></td></tr>
         </table>
   </s:form>
</body>
</html>