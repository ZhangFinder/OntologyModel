package com.ssh.web;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import com.ssh.model.Users;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ssh.service.IUsersService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport {
	   private static final Logger log=LoggerFactory.getLogger(UsersAction.class);
	    private Users u=new Users();
	    private List<Users> userList=new ArrayList<Users>();
	    private static IUsersService usersService =null;
	    private String name;
	    public IUsersService getUsersService(){
	    	if(usersService ==null){
	    		ServletContext sc=ServletActionContext.getServletContext();
	    		ApplicationContext ac=WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
	    		usersService =(IUsersService)ac.getBean("UsersService");
	    		if(usersService==null)
	    			System.out.println("error");
	    	}
	    	return usersService;
	    }
	    /****增加用户******/
	    public String addUser()throws Exception{
	    	try{
	    		getUsersService().addUsers(u);
	    	}catch(Exception e){
	    		log.error("保存用户错误",e);
	    		e.printStackTrace();
	    		return ERROR;
	    	}
	    	return SUCCESS;
	    }
	    /******编辑用户************/
	    public String editUser() throws Exception {
	    	if(u==null){
	    		System.out.println("null");
	    	}
	    	System.out.println(u.getUsername());
	    	System.out.println(u.getPassword());
	    	System.out.println(name);
	    	try{
	    		
	    		getUsersService().updateUsers(u);
	    	}catch(Exception e){
	    		System.out.println("错误了");
	    		log.error("编辑用户错误",e);
	    		return ERROR;
	    	}
	    	return SUCCESS;
	    }
	    /*********用户列表***********/
	    public String listUser() throws Exception {
	    	userList= getUsersService().findAll();
	    	Iterator<Users> iter=userList.iterator();
	    	while(iter.hasNext()){
	    		Users u=iter.next();
	    		System.out.println(u.getId()+":"+u.getPassword()+":"+u.getUsername());
	    	}
	    	return SUCCESS;
	    	
	    }
	    /***修改用户密码功能****/
	    public String updateUser() throws Exception{
	    	
	    	try{
	    		
	    		Users loginUser=getUsersService().findByName(u.getUsername());
	    		loginUser.setPassword(u.getPassword());
	    		getUsersService().updateUsers(loginUser);
	    	}catch(Exception e){
	    		System.out.println("错误了");
	    		log.error("编辑用户错误",e);
	    		e.printStackTrace();
	    		return ERROR;
	    	}
	    	return SUCCESS;
	    }
	    /****删除用户功能***/
	    public String delUser() throws Exception{
	    	System.out.println(u.getUsername()+" "+u.getPassword());
	    	try{
	    		Users loginUser=getUsersService().login(u.getUsername(), u.getPassword());
	    		getUsersService().delUsers(loginUser);
	    	}catch(Exception e ){
	    		log.error("登录查询错误",e);
	    		e.printStackTrace();
	    		return ERROR;
	    	}
	    	return SUCCESS;
	    }
	    /****登录功能***/
	    public String login() throws Exception{
	    	System.out.println(u.getUsername()+" "+u.getPassword());
	    	try{
	    		Users loginUser=getUsersService().login(u.getUsername(), u.getPassword());
	    		if(null!=loginUser){
	    			ActionContext context=ActionContext.getContext();
	    			context.getSession().put("LOGINUSER", loginUser);
	    			return SUCCESS;
	    		}
	    	}catch(Exception e ){
	    		log.error("登录查询错误",e);
	    	    e.printStackTrace();
	    		return ERROR;
	    	}
	    	return INPUT;
	    }
	    /**
	     * 用户登录
	     * @author ZJQ
	     **/
	    public String register()throws Exception{
	    	System.out.println(u.getUsername()+" "+u.getPassword());
	    	System.out.println("我在注册");
	    	try{
	    		getUsersService().addUsers(u);
	    	}catch(Exception e){
	    		log.error("保存用户错误",e);
	    		e.printStackTrace();
	    		return ERROR;
	    	}
	    	return SUCCESS;
	    }
	    public void setUsersService(IUsersService usersService){
	    	this.usersService=usersService;
	    }
	    public Users getU(){
	    	return u;
	    }
	    public void setU(Users u){
	    	this.u=u;
	    }
		public List<Users> getUserList() {
			return userList;
		}

		public void setUserList(List<Users> userList) {
			this.userList = userList;
		}
	    public void setName(String name){
	    	this.name=name;
	    }
	    public String getName(){
	    	return this.name;
	    }
}
