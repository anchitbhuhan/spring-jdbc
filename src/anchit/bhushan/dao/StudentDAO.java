package anchit.bhushan.dao;

import java.util.List;
import java.util.Map;

import anchit.bhushan.api.Student;

public interface StudentDAO {

	void insert(Student student);
	
	boolean deleteByRollNo(int roll_no);
	
	int deleteRecordByNameOrAddress(String roll_no, String address);
	
	void insert(List<Student> students);
	
	List<Student> findAllStudents();
	
	Student findStudentByRollNo(int rollNo);
	
	List<Student> findStudentByName(String name);
	
	Map<String, List<String>> groupStudentByAdress();
	
	int updateStudent(Student student);
	
	int updateStudent(List<Student> students);
}
