package anchit.bhushan.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import anchit.bhushan.api.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

	@Override
	public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

		List<Student> students = new ArrayList<>();
		while (resultSet.next()) {

			Student student = new Student();

			student.setRoll_no(resultSet.getInt("roll_no"));
			student.setName(resultSet.getString("name"));
			student.setAddress(resultSet.getString("address"));
			students.add(student);
		}
		return students;

	}

}
