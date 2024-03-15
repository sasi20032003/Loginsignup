package com.klef.jfsd.exam.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.exam.model.User;
import com.klef.jfsd.exam.service.UserService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class ClientController {
  
  @Autowired
  
  private UserService userService;
  
  @GetMapping("/")
  public String main()
  {
    return "index";
    
  }
  @GetMapping("empreg")
  public ModelAndView empregistration()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("empreg");
    return mv;
  }
  @GetMapping("emplogin")
  public ModelAndView emplogin()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("emplogin");
    return mv;
  }
  
  @PostMapping("checkemplogin")
  public ModelAndView checkemplogin(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");
    
    User emp = userService.checkemplogin(email, pwd);
    
    if(emp!=null)
    {
    	//session
    HttpSession session = request.getSession();
    session.setAttribute("eid", emp.getId());//eid and ename is session variable
    session.setAttribute("ename", emp.getName());
 mv.setViewName("emphome");
    }
    else {
      mv.setViewName("emplogin");
      mv.addObject("message", "Login failed");
    }
    return mv;
  }
  
  @GetMapping("emphome")
  public ModelAndView emphome(HttpServletRequest request)
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("emphome");
    HttpSession session = request.getSession();
    int eid =(int)session.getAttribute("eid");//eid and ename is session variable
    String ename = (String)session.getAttribute("ename");
    
    mv.addObject("eis", eid);
    mv.addObject("ename", ename);
    
    return mv;
  }
  
  
  
  @GetMapping("adminlogin") 
  public ModelAndView adminlogin()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("adminlogin");
    return mv;
  }
  
 
  
  
 
  
  
  @PostMapping("insertemp")
  public ModelAndView insertaction(HttpServletRequest request)
  {
	  ModelAndView mv = new ModelAndView();
	 String msg= null;
	 try
	 {
		 String name = request.getParameter("name");
		 String gender = request.getParameter("gender");
		 
		 String email = request.getParameter("email");
		 String pwd = request.getParameter("pwd");
	
		 String contact = request.getParameter("contact");
		 
		 User emp = new User();
	       emp.setName(name);
	       emp.setGender(gender);
	       emp.setEmail(email);
	       emp.setPassword(pwd);
	     
	       emp.setContact(contact);
	       
	       
	       
	       
	       msg=userService.addemployee(emp);
	       mv.setViewName("displaymsg");
	       mv.addObject("message", msg);
	 }
	 catch (Exception e)
	 {
		mv.setViewName("displayerror");
		
		msg=e.getMessage();
		
		mv.addObject("message", msg);
	 }
	 
	  return mv;
  
  }


@GetMapping("emplogout")
public ModelAndView emplogout()
{
  ModelAndView mv = new ModelAndView();
mv.setViewName("emplogin");
mv.addObject("message", "logout Successfully");
return mv;   
}


  
  
  
}