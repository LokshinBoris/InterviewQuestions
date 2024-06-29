package bbl.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionPool 
{
 
LinkedHashMap<Long, Connection> map;

@SuppressWarnings({ "serial", "unchecked" })
public ConnectionPool(int size)
{
	map= new LinkedHashMap<>(size,0.75f,true)
	{		
		@Override
		protected boolean removeEldestEntry(Map.Entry<Long,Connection> entry)
		{
			return map.size()>3;
		}
	};
	
}
public Connection getConnection(Connection connection)
{
	Connection result=null;
	result=map.get(connection.id());
	if(result==null)
	{
		result = new Connection(connection.id());
		map.put(result.id(), result);
	}
	return result;
}

public boolean isInPool(long id)
{
	
	return map.containsKey(id);
}

}
