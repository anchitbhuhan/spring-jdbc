package anchit.bhushan.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import anchit.bhushan.api.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet res, int arg1) throws SQLException {

		Student student = new Student();

		student.setRoll_no(res.getInt("roll_no"));
		student.setName(res.getString("name"));
		student.setAddress(res.getString("address"));

		return student;
	}

}
