import java.sql.*;
public class TestStudent{

    public static void main(String[] args) {
        Connection c =null;
        Statement stmt= null;
        String url="jdbc:postgresql://localhost:5432/JAVA";
        String usr="postgres";
        String pwd="0000";
        try{
            c=DriverManager.getConnection(url, usr, pwd);
            stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM STUDENTS; ");
            while (rs.next()) {
                int id=rs.getInt("id");
                String nom=rs.getString("nom");
                int age=rs.getInt("age");
                System.out.println("id ="+id+" nom= "+nom+" age= "+age);

            }
            rs.close();
            stmt.close();
            c.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName()+""+e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }  
}

