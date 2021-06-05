package anchit.bhushan.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import anchit.bhushan.api.Student;
import anchit.bhushan.resultSetExtractor.GroupByAddressResultSetExtractor;
import anchit.bhushan.resultSetExtractor.StudentResultSetExtractor;
import anchit.bhushan.rowMapper.StudentRowMapper;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Student student) {

		Object[] obj = { student.getRoll_no(), student.getName(), student.getAddress() };
		String sql = "INSERT INTO student VALUES(?,?,?)";

		int noofRows = jdbcTemplate.update(sql, obj);
		System.out.println("No of rows inserted = " + noofRows);
	}

	@Override
	public boolean deleteByRollNo(int roll_no) {

		String sqlString = "DELETE FROM student WHERE roll_no = ?";

		int deleted = jdbcTemplate.update(sqlString, roll_no);
		System.out.println("No of record deleted is " + deleted);
		return deleted == 1;

	}

	@Override
	public int deleteRecordByNameOrAddress(String name, String address) {

		Object[] argsObjects = { name, address };
		String sqlString = "DELETE FROM student WHERE name = ? OR address = ?";

		int deleted = jdbcTemplate.update(sqlString, argsObjects);
		System.out.println("No. of records deleted = " + deleted);
		return deleted;

	}

	public void cleanUp() {

		String sqlString = "TRUNCATE TABLE student";
//		jdbcTemplate.update(sqlString);
		jdbcTemplate.execute(sqlString);
		System.out.println("Table clean up Successfull");
	}

	@Override
	public void insert(List<Student> students) {

		String sqlString = "INSERT INTO student values (?, ?, ?)";

		List<Object[]> sqlArgs = new ArrayList<>();
		for (Student student : students) {
			Object[] stdata = { student.getRoll_no(), student.getName(), student.getAddress() };
			sqlArgs.add(stdata);
		}
		jdbcTemplate.batchUpdate(sqlString, sqlArgs);
		System.out.println("Batch update executed");

	}

	@Override
	public List<Student> findAllStudents() {

		String sqlString = "SELECT * FROM student";

		List<Student> students = jdbcTemplate.query(sqlString, new StudentRowMapper());

		return students;

	}

	@Override
	public Student findStudentByRollNo(int rollNo) {

		String sqlString = "SELECT roll_no as roll_no, name as name, address as address"
				+ " FROM student WHERE roll_no = ?";
//		Student student = jdbcTemplate.queryForObject(sqlString, new StudentRowMapper(), rollNo);
		Student student = jdbcTemplate.queryForObject(sqlString, new BeanPropertyRowMapper<Student>(Student.class),
				rollNo);
		return student;
	}

	@Override
	public List<Student> findStudentByName(String name) {

		String sqlString = "SELECT roll_no as roll_no, name as name, address as address"
				+ " FROM student WHERE name = ?";

		List<Student> students = jdbcTemplate.query(sqlString, new StudentResultSetExtractor(), name);
		return students;
	}

	@Override
	public Map<String, List<String>> groupStudentByAdress() {

		String sqlString = "SELECT * FROM student";

		Map<String, List<String>> result = jdbcTemplate.query(sqlString, new GroupByAddressResultSetExtractor());
		return result;
	}

	@Override
	public int updateStudent(Student student) {

		String sqlString = "UPDATE STUDENT SET address = ? WHERE roll_no = ?";
		int result = jdbcTemplate.update(sqlString, student.getAddress(), student.getRoll_no());
		System.out.println("1 row updated successfully");
		return result;
	}

	@Override
	@Transactional
	public int updateStudent(List<Student> students) {

		String sqlString = "UPDATE STUDENT SET address = ? WHERE roll_no = ?";
		int[] rows = jdbcTemplate.batchUpdate(sqlString, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {

				ps.setString(1, students.get(index).getAddress());
				ps.setInt(2, students.get(index).getRoll_no());

			}

			@Override
			public int getBatchSize() {
				return students.size();
			}
		});
		
		int rowsUpdate = 0;
		for(int i : rows)
		{
			if(i==1)
				rowsUpdate++;
		}
		
		System.out.println("Batch Update Performed on "+rowsUpdate+" rows Successfully");
		return 0;

	}

}
