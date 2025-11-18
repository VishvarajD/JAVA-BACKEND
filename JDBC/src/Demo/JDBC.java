package Demo;
import java.sql.*;
public class JDBC {

    public static void main(String[] args) throws SQLException {
        /*
        * import package
        * load and register
        * create connection
        * create statement
        * execute statement
        * process the results
        * close connection
        * */
        //Load and Register
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/Demo";
        String user = "postgres";
        String password = "rohan18";
        String sql = "select name from student where id = 5";
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to PostgreSQL database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement stmt = conn.createStatement();
        //Read
//        ResultSet rs=stmt.executeQuery(sql); //used when we want to get data from db
//        rs.next();
//        System.out.println(rs.getString("name"));
//        while(rs.next()){
//            System.out.println(rs.getString(1)+" "+rs.getString(2)+" ");
//        }
        //Insert
//        String query1 = "insert into student values(5,'randomass')";
//        boolean r = stmt.execute(query1);
//        /*
//        * Returns:
//          true if the first result is a ResultSet object;
//        * false if it is an update count or there are no result;
//        * */
//        System.out.println(r);//false because an update has occurred or no result

//        boolean r = stmt.execute(sql);
//        System.out.println(r);//true because returns a resultSet


//prepared Statement - blocks SQL injection , safe travel using question ,
        String query1 = "insert into student values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query1);
        pstmt.setInt(1,6);

        pstmt.setString(2,"rugboy");
        pstmt.execute();
        System.out.println("prepared statement executed");





        conn.close();
    }
}
