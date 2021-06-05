package anchit.bhushan.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anchit.bhushan.api.Student;
import anchit.bhushan.dao.StudentDAOImpl;
import anchit.bhushan.service.StudentDAOHelper;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Context loaded Successfully");

		StudentDAOHelper studentDAOHelper = context.getBean("studentDAOHelper", StudentDAOHelper.class);
//		studentDAOHelper.setupStudentTable();

		StudentDAOImpl studentDAOImpl = context.getBean("studentDAO", StudentDAOImpl.class);
//		List<Student> students =  studentDAOImpl.findAllStudents();
//		Student studentByRoll = studentDAOImpl.findStudentByRollNo(2);

//		List<Student> studentsByname =  studentDAOImpl.findStudentByName("Anchit");

//		System.out.println("All Students");
//		studentDAOHelper.printStudents(students);
//		System.out.println();
//		
//		System.out.println("Students with Roll no 2");
//		studentDAOHelper.printStudent(studentByRoll);
//		System.out.println();
//		
//		
//		System.out.println("Students with name Anchit");
//		studentDAOHelper.printStudents(studentsByname);
//		System.out.println();

//		Map<String, List<String>> groupByAddressMap = studentDAOImpl.groupStudentByAdress();
//		studentDAOHelper.printGroupedStudentsByAddress(groupByAddressMap);

		Student student  = new Student();
		student.setAddress("BLR");
		student.setRoll_no(1);
//		studentDAOImpl.updateStudent(student);

		
		Student student1  = new Student();
		student1.setAddress("BLR");
		student1.setRoll_no(2);
//		studentDAOImpl.updateStudent(student1);
		
		Student student2  = new Student();
		student2.setAddress("BLR");
		student2.setRoll_no(3);
//		studentDAOImpl.updateStudent(student2);
		
		List<Student> students = new ArrayList<>();
		students.add(student);
		students.add(student1);
		students.add(student2);
		int n = studentDAOImpl.updateStudent(students);
		
//		studentDAOImpl.cleanUp();

	}

}
