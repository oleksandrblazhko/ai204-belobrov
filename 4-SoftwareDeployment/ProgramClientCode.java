import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

  public static void main(String[] args) {

	System.out.println("OPEN CONNECTION, ARG[0] = " + args[0]);
    try {
      Class.forName("org.postgresql.Driver");
      Connection connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/belobrovdb",
          "postgres", args[0]);

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from genres");

      while (resultSet.next()) {
        System.out.println("| " + resultSet.getString(1)
            + " | " + resultSet.getString(2) + " |");
      }

      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
	System.out.println("CLOSE CONNECTION");
  }
}