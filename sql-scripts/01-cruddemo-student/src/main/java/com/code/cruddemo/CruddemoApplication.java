package com.code.cruddemo;

import com.code.cruddemo.dao.StudentDAO;
import com.code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipeStudents(studentDAO);
		};
	}

	private void createMultipeStudents(StudentDAO studentDAO) {

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
