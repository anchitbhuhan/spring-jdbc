package anchit.bhushan.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

public class BatchUpdatePreparedStatementSetter implements BatchPreparedStatementSetter {

	@Override
	public int getBatchSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValues(PreparedStatement ps, int index) throws SQLException {
		
		
	}

}
