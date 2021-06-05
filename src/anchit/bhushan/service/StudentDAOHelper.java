package anchit.bhushan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anchit.bhushan.api.Student;
import anchit.bhushan.dao.StudentDAO;

@Service("studentDAOHelper")
public class StudentDAOHelper {

	@Autowired
	private StudentDAO studentDAOImpl;

	public void setupStudentTable() {

		Student student1 = new Student();
		student1.setRoll_no(1);
		student1.setName("Anchit");
		student1.setAddress("Hazaribagh");

		Student student2 = new Student();
		student2.setRoll_no(2);
		student2.setName("Aniket");
		student2.setAddress("Hazaribagh");

		Student student3 = new Student();
		student3.setRoll_no(3);
		student3.setName("Ankita");
		student3.setAddress("Tatanagar");
		
		Student student4 = new Student();
		student3.setRoll_no(4);
		student3.setName("Anchit");
		student3.setAddress("Ranchi");

		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);

		studentDAOImpl.insert(students);
	}

	public void printStudents(List<Student> students) {

		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void printStudent(Student student) {

		System.out.println(student);
	}
	
	public void printGroupedStudentsByAddress(Map<String, List<String>> groupByAddressMap)
	{
		for(String address : groupByAddressMap.keySet())
		{
			System.out.println(address+"->"+groupByAddressMap.get(address));
		}
		System.out.println();
	}
}
