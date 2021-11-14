package com.fatou.demoJpa24.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fatou.demoJpa24.entity.Course;

@Repository
@Transactional

public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long Id) {
		return em.find(Course.class, Id);
	}
	
	public void deletedById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		}
		return course;
	}

}
