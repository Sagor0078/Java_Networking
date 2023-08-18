import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT_DB {

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/teacherreg"; // ODBC Data Source Name
        String username = "main"; // Enter your username
        String password = "sagor0078"; // Enter your password

        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            String query = "INSERT INTO teacherinfo (name, email, phone) VALUES (?, ?, ?)";
            
            // Sample student data
            String name = "John Doe";
            String email = "john@example.com";
            String phone = "123-456-7890";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully.");
            }
            
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
