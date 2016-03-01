package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import bean.User;

public class UserDAO {
	ConnectionFactory conFactory = null;
	

	
public ArrayList<User> fetchListOfUsers(User user) throws Exception
{
	conFactory = new ConnectionFactory();
	Connection conn;
	PreparedStatement stmt = null;
	ArrayList lstUsers = new ArrayList();
	try {
		conn = conFactory.createConnectionPool();
		StringBuilder sql = new StringBuilder();
		sql.append( "select id , user_name , date_joined from users u " +
		"where (id = ? or ? is NULL) and" +
		"(user_name = ? or ? is NULL)" +
		"and (date_joined = ? or ? is NULL) ");
		stmt = conn.prepareStatement(sql.toString());
		if(user.getUserId()!= null)
		{
		stmt.setInt(1, user.getUserId());
		stmt.setInt(2, user.getUserId());
		}
		else
		
		{
			stmt.setNull(1, Types.INTEGER);
			stmt.setNull(2, Types.INTEGER);		
		}
		if(user.getUserName()!= null)
		{
		stmt.setString(3, user.getUserName());
		stmt.setString(4, user.getUserName());
		}
		else
		{
		stmt.setNull(3, Types.VARCHAR);
		stmt.setNull(4, Types.VARCHAR);	
		}
		if(user.getDateJoined()!= null)
		{
		stmt.setDate(5, new Date(user.getDateJoined().getTime()));
		stmt.setDate(6, new Date(user.getDateJoined().getTime()));
		}
		else
		{
			stmt.setNull(5, Types.DATE);
			stmt.setNull(6, Types.DATE);	
		}
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			User uTemp = new User();
			uTemp.setUserId(rs.getInt("id"));
			uTemp.setUserName(rs.getString("user_name"));
			uTemp.setDateJoined(rs.getDate("date_joined"));
			lstUsers.add(uTemp);
		}
		
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return lstUsers;
		
}
}
