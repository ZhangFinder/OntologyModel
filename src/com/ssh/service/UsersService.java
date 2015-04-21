package com.ssh.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssh.dao.IUsersDAO;
import com.ssh.model.Users;

public class UsersService implements IUsersService {
	private static final Logger log = LoggerFactory
			.getLogger(UsersService.class);
	private IUsersDAO usersDAO = null;

	@Override
	public void addUsers(Users u) {
		usersDAO.save(u);
	}

	@Override
	public void delUsers(Users u) {
		usersDAO.delete(u);
	}

	@Override
	public List<Users> findAll() {
		return usersDAO.findAll();
	}

	@Override
	public Users findByName(String uname) {
		List<Users> list = usersDAO.findByUsername(uname);
		if(list==null){
		    System.out.println("listÎª¿Õ");
			return null;
		}
		return list.get(0);

	}

	@Override
	public Users login(String uname, String upass) {
		Users u = findByName(uname);
		if (null == u) {
			return null;
		}
		if (uname.equals(u.getUsername()) && upass.equals(u.getPassword())) {
			return u;
		}
		return null;
	}

	@Override
	public void updateUsers(Users u) {
		usersDAO.attachDirty(u);

	}

	public void setUsersDAO(IUsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public IUsersDAO getUsersDAO() {
		return usersDAO;
	}
}
