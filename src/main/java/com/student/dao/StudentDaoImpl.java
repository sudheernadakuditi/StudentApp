package com.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;

	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
		System.out.println("Saved the student with Id: " + student.getId());

	}

	@Override
	public Student find(Long id) {
		return entityManager.find(Student.class, id);

	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData", Student.class);
		theQuery.setParameter("theData", lastName);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}
}
