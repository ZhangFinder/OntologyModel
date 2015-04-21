<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
</head>
<body>
     <table border="5" cellpadding="5">
      <tr><td>ID</td><td>用户名</td><td>密码</td><td>操作</td></tr>
      <s:iterator value="userList" >
      <tr>
       <td>${id}</td>
       <td>${username}</td> 
       <td>${password}</td>  
       <td>
          <a onclick="return confirm('确定要删除吗？');" href='<s:url action="delUser"> <s:param name="u.username" value="username"/><s:param name="u.password" value="password"/></s:url> ' >删除</a>
       
       
       </td>   
      </tr>
      </s:iterator>
    </table>
</body>
</html>