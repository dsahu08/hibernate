package com.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.student.hibernate.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory(); 
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Paul","Grey","paul.grey@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Saved student id:"+tempStudent.getId());
			
			//start a new session
			session = factory.getCurrentSession();
			//Begin the transaction
			session.beginTransaction();
			
			Student student = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete:"+student);
			
			session.getTransaction().commit();
			System.out.println("Reading the student done!");
			
			
		}
		finally{
			factory.close();
		}
	}

}
