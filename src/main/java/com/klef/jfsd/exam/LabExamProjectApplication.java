package com.klef.jfsd.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.klef.jfsd.exam"})
public class LabExamProjectApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(LabExamProjectApplication.class, args);
		System.out.println("JFSD END SEM LAB EXAM ...");
	}

}
