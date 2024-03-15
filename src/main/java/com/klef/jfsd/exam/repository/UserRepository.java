package com.klef.jfsd.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.exam.model.User;

public interface UserRepository extends JpaRepository<User, Integer>

{
	@Query("select e from User e where e.email=?1 and e.password=?2")
public User checkemplogin(String email,String pwd);
}
