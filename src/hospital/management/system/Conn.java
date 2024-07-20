package hospital.management.system;
import java.sql.*;
public class Conn
{
    Connection con;
    Statement stmt;
    public Conn()
    {
        try
        {
            String url="jdbc:mysql://localhost:3306/hospital_management_system";
            String user="root";
            String pw="Akshay@4230";
            con=DriverManager.getConnection(url,user,pw);
            stmt=con.createStatement();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
