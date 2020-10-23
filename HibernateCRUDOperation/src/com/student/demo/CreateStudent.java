package com.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.hibernate.entity.Student;



public class CreateStudent {
	
	
	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
		//create session
				Session session = factory.getCurrentSession();
				try {
					//use the session object to save the java object
					System.out.println("Creating new student object..");
					Student student = new Student("Henry","Ford","henry.ford@ford.com");
					
					//create a student object
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the student...");
					session.save(student);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Create Student Done!!");
				}
				finally {
					factory.close();
				}
	}

}
