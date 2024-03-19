package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	private String[] args;

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

			 createStudent(studentDAO);

			 // readStudent(studentDAO);

			 // queryForStudents(studentDAO);

			 // queryForStudentsByLastName(studentDAO);

			 // updateStudent(studentDAO);

			 // deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;

		System.out.println("Deleting student id: " + studentId);

		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: Primary key
        int studentId = 1;
		System.out.println("Getting student id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student . . .");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);


		// display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students

		List<Student> theStudents = studentDAO.findByLastName("Duck");

		// display list of students

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students

		List<Student> theStudents =  studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {

			System.out.println(tempStudent);

		}
		}



	private void readStudent(StudentDAO studentDAO) {

		// create student object

		System.out.println("Creating new student object...");
		Student tempStudent= new Student("Daffy", "Duck", "Daffy@love2cud.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		// display id of the saved student

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated ID: " + theId);

		// retrieve the student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		// display student
		System.out.println("Found the student:" + myStudent);

	}

	private void createStudent(StudentDAO studentDAO){

		// create student object

		System.out.println("Creating new student object...");
		Student tempStudent= new Student("Paul", "Weasley", "paul@love2cud.com");




		// save the student object

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student

		System.out.println("Saved student. Generated Id: " + tempStudent.getId());
	}
}
