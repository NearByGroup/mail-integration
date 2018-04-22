package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserServiceDao;
import com.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserServiceDao userdao;
	@Autowired
	private MailSender mailSender;
	
	public boolean  RegisterUser(User users) {
		
		return userdao.saveorupdate(users);
	}

	/*public List<User> LoginUser(User users) {
		

		return userdao.LoginUser(users);

	}*/
public List<User> LoginUser(User users) {
		

		 return userdao.LoginUser(users);
}


public User sendMail(String from, User users, String subject, String msg) {
	SimpleMailMessage message = new SimpleMailMessage();
	
	message.setFrom(from);
	message.setTo(users.getEmail());
	message.setSubject(subject);
	message.setText(msg);
	mailSender.send(message);
	return null;	
}

}
