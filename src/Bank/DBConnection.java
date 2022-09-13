package Bank;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String[] args)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
			String user="scott";
			String pwd="tiger";
			//class.forname(mysqlJDBCDriver);
			Connection con=DriverManager.getConnection(url,user,pwd);
			Statement stmt=con.createStatement();
			stmt.executeQuery("select * from BANKING");
			stmt.executeUpdate("insert into BANKING values('Vinay','19564','1000')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


}
