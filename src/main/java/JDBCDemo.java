import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class JDBCDemo {
    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM albums");

//            while (rs.next()) {
//                System.out.println("Here is an album: ");
//                System.out.println(" id: " + rs.getLong("id"));
//                System.out.println("  artist: " + rs.getString("artist"));
//                System.out.println("  name: " + rs.getString("name"));
//            }

//            String query = "INSERT INTO albums (artist, name, release_date, genre, sales) VALUES('Nelly Furtado', 'Loose', 2006, 'Pop, Urban, R&B', 12.5)";
//            stmt = connection.createStatement();
//            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
//             rs = stmt.getGeneratedKeys();
//            if (rs.next()) {
//                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
//            }

            String query = "SELECT * FROM albums WHERE id = 31";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("artist"));
                System.out.println(rs.getString(5));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
