package com.demo;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student s=new Student();
		
		s.setName("Mike");
		s.setFee(300000);
		s.setEmail("mike@gmail.com");
		
		studentRepository.save(s);
		
	}
	@Test
	public void deleteStudent() {
		Student s=new Student();
		studentRepository.deleteById(3l);
		
	}
	@Test
	public void updateStudent() {
		Student s=new Student();
		s.setId(3);
		s.setName("Stallin");
		s.setFee(300000);
		s.setEmail("stallin@gmail.com");
		studentRepository.save(s);
		
	}
	//TARIKA 1
	@Test
	public void getstudentById() {
		Student s=new Student();
		Optional<Student> findById = studentRepository.findById(1l);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println(student.getFee());
		
		}
	//TARIKA 2
	@Test
	public void getstudentById2() {
		Student s=new Student();
		Optional<Student> findById = studentRepository.findById(10l);
		if(findById.isPresent()) {
			Student student = findById.get();
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getFee());
			
			
		}
		else {
			System.out.println("Record not found!!!!");
			
		}
		
		}
	
	@Test
	public void studentExistById() {
		Student s=new Student();
		boolean val = studentRepository.existsById(1l);
		System.out.println(val);
		
		}
	@Test
	public void readAllStudent() {
		Student s=new Student();
		Iterable<Student> findAll = studentRepository.findAll();
		for(Student student:findAll){
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getFee());
		}
		
		}
	@Test
	public void getStudentByEmail(){
		Optional<Student> findByEmail = studentRepository.findByEmail("mike@gmail.com");
		if(findByEmail.isPresent()) {
			Student student = findByEmail.get();
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getFee());
		}
		else {
			System.out.println("Email does not Found!!!");
		}
	}
	
	@Test
	public void getStudentByMobile(){
		Optional<Student> findByMobile = studentRepository.findBymobile("88996563451");
		if(findByMobile.isPresent()) {
			Student student = findByMobile.get();
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getFee());
		}
		else {
			System.out.println("mobile does not Found!!!");
		}
	}
	
	
	@Test
	public void getStudentByName(){
		Iterable<Student> findByName = studentRepository.findByName("Stallin");
		for(Student student:findByName){
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getFee());
			System.out.println(student.getMobile());
		}
		
	}
	
	@Test
	public void getStudentByEmailOrMobile(){
		 Iterable<Student> findByEmailOrMobile = studentRepository.findByEmailOrMobile("mike@gmail.com","8876566534");
		 for(Student student:findByEmailOrMobile ){
				System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getEmail());
				System.out.println(student.getFee());
				System.out.println(student.getMobile());
			}
		
	}
	
	@Test
	public void getStudentByEmailAndMobile(){
		 Optional<Student> findByEmailAndMobile = studentRepository.findByEmailAndMobile("mike@gmail.com","8876566534");
		 
		 if(findByEmailAndMobile.isPresent()) {
				Student student = findByEmailAndMobile.get();
				System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getEmail());
				System.out.println(student.getFee());
				System.out.println(student.getMobile());
			}
			else {
				System.out.println("mobile and email does not match and found!!!");
			}
		
			}
		
	}
		
		
		
	
	
	
	
	
	


