package com.klef.jfsd.exam.service;

import java.util.Optional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.User;
import com.klef.jfsd.exam.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService 
{

  @Autowired
  private UserRepository userRepository;
  
  @Override
  public String addemployee(User emp) {
    
    userRepository.save(emp);
    return "User Added Successfully";
    
  }

  
@Override
public User checkemplogin(String email, String pwd) {
	
	return userRepository.checkemplogin(email, pwd);
}

}