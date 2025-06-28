package com.student.dao;

import java.util.List;

import com.student.entity.Student;

public interface StudentDao {
	
	public void save(Student student);
	public Student find(Long id);
	public List<Student> findAll();
	public List<Student> findByLastName(String lastName);
	public void update(Student student);
	public void delete(Long id);

}
