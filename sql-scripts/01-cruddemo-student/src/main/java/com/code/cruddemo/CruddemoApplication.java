package com.code.cruddemo;

import com.code.cruddemo.dao.StudentDAO;
import com.code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			//createMultipeStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> studentList = studentDAO.findByLastName("London");

		// display the list of students
		for(Student st : studentList) {
			System.out.println(st);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> studentList = studentDAO.findAll();

		// display the list of students
		for(Student st : studentList) {
			System.out.println(st);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ...");
		Student tStudent = new Student("Tommy", "London", "TLondon@hotmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tStudent);

		// display id of the student
		int id = tStudent.getId();
		System.out.println("Saved student. Generated id: " + id);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + id);
		Student myStudent = studentDAO.findById(id);

		// display student
		System.out.println("The student is: " + myStudent);
	}

	private void createMultipeStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating new students objects ...");
		Student tStudent = new Student("Jackson", "Frank", "JFrank@hotmail.com");
		Student tStudent1 = new Student("Mary", "Jolie", "MJolie@hotmail.com");

		// save the student objects
		System.out.println("Saving the student ...");
		studentDAO.save(tStudent);
		studentDAO.save(tStudent1);

		// display id of the saved students
		System.out.println("Saved student. Generated id: " + tStudent.getId());
		System.out.println("Saved student. Generated id: " + tStudent1.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tStudent = new Student("Jack", "Frank", "JFrank@hotmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tStudent.getId());
	}


}
