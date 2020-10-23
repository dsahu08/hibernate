package com.student.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory(); 
				//create session
				Session session = factory.getCurrentSession();
			
				try {
					
					//Begin the transaction
					session.beginTransaction();
					
					int stdudentId=1;
					Student student = session.get(Student.class, stdudentId);
					//update the first name to Greg
					student.setFirstName("Greg");
					
					session.getTransaction().commit();
					System.out.println("Update student name:"+student);
				
					//start new session
					 session = factory.getCurrentSession();
					
					//Begin the transaction
					session.beginTransaction();
					Student updatedstudent = session.get(Student.class, student.getId());
					System.out.println("Get complete:"+updatedstudent);
					
					session.getTransaction().commit();
					System.out.println("Updating the student done!");
				}
				finally {
					factory.close();
				}

	}

}
