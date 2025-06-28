package com.student.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.student.dao.StudentDao;
import com.student.entity.Student;

@SpringBootApplication
@ComponentScan(basePackages = { "com.student.controller", "com.student.service", "com.student.dao" })
@EntityScan("com.student.entity")
public class StudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return args -> {

			createStudent(studentDao);
//			findById(studentDao);
//			findAll(studentDao);
//			queryForFindByLastName(studentDao);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
			
			
		};

	}
	
	private void findAll(StudentDao studentDao) {
		List<Student> list=studentDao.findAll();
		for(Student student:list) {
			System.out.println(student);
		}
		
	}

	private void deleteStudent(StudentDao studentDao) {
		studentDao.delete(5L);
		System.out.println("deleted the student with id : 5");
		
	}

	private void updateStudent(StudentDao studentDao) {
		//find the student with id
		Student student=studentDao.find(2L);
		System.out.println("found the student with id :"+student.getId());
		
		//set the lastName
		System.out.println("Updating the student last name to stupendous...");
		student.setLastName("Stupendous");
		
		//execute update
		studentDao.update(student);
		
		//print the updated student
		System.out.println("Updated student :"+student);
		
	}

	private Student findById(StudentDao studentDao) {
		return studentDao.find(2L);
	}
	
	private void queryForFindByLastName(StudentDao studentDao){
		List<Student>list= studentDao.findByLastName("Nadakuditi");
		for(Student student:list) {
			System.out.println(student);
		}
	}
	
	private void queryForStudents(StudentDao studentDao) {
		List<Student> studentList=studentDao.findAll();
		for(Student student:studentList) {
			System.out.println(student);
		}
	}
	public void createStudent(StudentDao studentDao) {

		System.out.println("Creating new student object...");

		Student student1 = new Student();
		student1.setFirstName("Sudheer");
		student1.setLastName("Nadakuditi");
		student1.setAge(25);
		student1.setResult(true);
		student1.setEmail("sudheer@example.com");
		student1.setGender("Male");
		
		studentDao.save(student1);
		
		Student student2 = new Student();
		student2.setFirstName("Anjali");
		student2.setLastName("Sharma");
		student2.setAge(22);
		student2.setResult(false);
		student2.setEmail("anjali.sharma@example.com");
		student2.setGender("Female");
		studentDao.save(student2);

		Student student3 = new Student();
		student3.setFirstName("Ravi");
		student3.setLastName("Teja");
		student3.setAge(24);
		student3.setResult(true);
		student3.setEmail("ravi.teja@example.com");
		student3.setGender("Male");
		studentDao.save(student3);
		
		Student student4 = new Student();
		student4.setFirstName("Sneha");
		student4.setLastName("Reddy");
		student4.setAge(21);
		student4.setResult(true);
		student4.setEmail("sneha.reddy@example.com");
		student4.setGender("Female");
		studentDao.save(student4);

		Student student5 = new Student();
		student5.setFirstName("Priya");
		student5.setLastName("Verma");
		student5.setAge(22);
		student5.setResult(false);
		student5.setEmail("priya.verma@example.com");
		student5.setGender("Female");
		studentDao.save(student5	);
	}
}
