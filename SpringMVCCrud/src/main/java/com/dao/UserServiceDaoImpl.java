package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cache;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
@Repository
@Transactional
@EnableTransactionManagement
public class UserServiceDaoImpl implements UserServiceDao 
{
	

	@Autowired SessionFactory sessionFactory;

	public boolean saveorupdate(User users) {
		if(users.getAddress() != null&&users.getEmail() != null&&users.getMobile() != null&&users.getPassword() != null&&users.getUsername() != null){

            if(users.getAddress().length() != 0 && users.getEmail().length() != 0 && users.getMobile().length() != 0 && users.getPassword().length() != 0 && users.getUsername().length() != 0  )



                   sessionFactory.getCurrentSession().saveOrUpdate(users);

          }



         

         

          return true;
        

		

       }

 

	public List<User> LoginUser(User users) {
		
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username and u.password=:password");
			query.setParameter("username", users.getUsername());
			query.setParameter("password", users.getPassword());
			return (List<User>) query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
					
	}

	

}
