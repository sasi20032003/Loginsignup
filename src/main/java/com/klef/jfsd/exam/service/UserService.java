package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.User;

public interface UserService {

  public String addemployee(User emp);
 


public User checkemplogin(String email, String pwd);
}