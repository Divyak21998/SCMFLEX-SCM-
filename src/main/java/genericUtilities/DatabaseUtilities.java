package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtilities {
	Connection con=null;
	public void connectDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.DbURL,IPathConstants.DB_Username,IPathConstants.DB_Password);

	}
	public String executeAndGetdata(int colnum,String Expdata,String query) throws Throwable
	{

		Statement sta = con.createStatement();
		//String query="select * from Employee;";
		ResultSet result = sta.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actualdata = result.getString(colnum);
			if(actualdata.equals(Expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("project created successfully");
			return Expdata;
		}
		else
		{
			System.out.println("--project is not created--");
			return "";
		}
	}
	public void disconnectDB() throws Throwable
	{
		con.close();
	}
}
