package anchit.bhushan.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class GroupByAddressResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		
		Map<String, List<String>> resultMap = new HashMap<>();
		
		while(resultSet.next())
		{
			String addressString = resultSet.getString("address");
			String nameString = resultSet.getString("name");
			
			if(!resultMap.containsKey(addressString))
				resultMap.put(addressString, new ArrayList<String>(Arrays.asList(nameString)));
			else
				resultMap.get(addressString).add(nameString);
		}
		return resultMap;
	}
	
	

}
