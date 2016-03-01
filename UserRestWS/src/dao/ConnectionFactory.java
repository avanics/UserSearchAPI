package dao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionFactory {
	
	Connection connection = null;
	BasicDataSource bdSource = new BasicDataSource();
	
	
	public String FilePath = "System.properties";
	
	public Properties loadProperties() throws IOException
	{
		Properties props = new Properties();
		InputStream input = null;
		input = getClass().getClassLoader().getResourceAsStream(FilePath);
			if(input!= null)
			{
				props.load(input);
			}
			return props;
	}
	
	public Connection createConnectionPool() throws Exception
	{
		ConnectionFactory conn = new ConnectionFactory();
		Properties props = conn.loadProperties();
		bdSource.setDriverClassName(props.getProperty("db.driverName"));
		bdSource.setUrl(props.getProperty("db.url"));
		bdSource.setUsername(props.getProperty("db.username"));
		bdSource.setPassword(props.getProperty("db.password"));
		Connection con = bdSource.getConnection();
		return con;
	}
	
}



