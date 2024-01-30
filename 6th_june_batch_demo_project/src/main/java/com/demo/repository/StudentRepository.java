package com.demo.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {
	
Optional<Student>findByEmail(String email);

Optional<Student>findBymobile(String mobile);

Iterable<Student>findByName(String name);

Iterable<Student>findByEmailOrMobile(String email,String mobile);
Optional<Student>findByEmailAndMobile(String email,String mobile);
	

}
