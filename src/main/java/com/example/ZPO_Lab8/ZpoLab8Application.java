package com.example.ZPO_Lab8;

import com.example.ZPO_Lab8.Entity.Email;
import com.example.ZPO_Lab8.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@SpringBootApplication
public class ZpoLab8Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ZpoLab8Application.class, args);
	}


	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public void run(String... args){
		Student student = new Student();
		student.setFirstName("Jan");
		student.setLastName("Kowalski");

		Email email1 = new Email();
		email1.setEmail("jan.kowalski@example.com");
		email1.setStudent(student);

		Email email2 = new Email();
		email2.setEmail("janek@example.com");
		email2.setStudent(student);

		student.getEmails().add(email1);
		student.getEmails().add(email2);

		entityManager.persist(student);

// Pobieranie danych studenta za pomocą JPQL
		String jpql = "SELECT s FROM Student s JOIN FETCH s.emails WHERE s.firstName = 'Jan' AND s.lastName = 'Kowalski'";
		TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
		List<Student> students = query.getResultList();

// Wyświetlanie danych studenta w konsoli
		students.forEach(System.out::println);
	}
}

