
import java.sql.*;

public class dbconn {

    public static ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER LOADED SUCCESSFULLY");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/twitter", "root", "system");
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
