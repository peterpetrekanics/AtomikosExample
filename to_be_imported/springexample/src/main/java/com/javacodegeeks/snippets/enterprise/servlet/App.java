package com.javacodegeeks.snippets.enterprise.servlet;

import java.time.LocalDateTime;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javacodegeeks.snippets.enterprise.model.EmployeeA;
import com.javacodegeeks.snippets.enterprise.model.EmployeeB;
import com.javacodegeeks.snippets.enterprise.service.EmployeeService;

public class App {

	public static void main(String[] args) throws Exception {
		System.out.println("load context");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeA em1 = new EmployeeA();
		
		LocalDateTime now = LocalDateTime.now();
//		int year = now.getYear();
//		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();

		
		em1.setId(100*hour + minute);
		em1.setName("John");
		em1.setAge(35);
		EmployeeB em2 = new EmployeeB();
		em2.setId(100*hour + minute);
		em2.setName("Mary");
		em2.setAge(31);
		EmployeeService emService = (EmployeeService) context.getBean("employeeService");
		emService.persistEmployees(em1, em2);
		context.close();
	}

}

