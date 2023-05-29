package N3Gallery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
  private static final String JDBC_DRIVER = "org.sqlite.JDBC";
  private static Connection connection = null;
  private static final String DATABASE_URL = "jdbc:sqlite:"
      + App.class.getResource("/database/database.db").toExternalForm();

  public static boolean checkDBDriver() {
    try {
      Class.forName(JDBC_DRIVER);
      DriverManager.registerDriver(new org.sqlite.JDBC());
      return true;
    } catch (ClassNotFoundException | SQLException classNotFoundException) {
      Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not start SQLite Drivers");
      return false;
    }
  }

  public static void connect() {
    try {
      System.out.println(DATABASE_URL);
      connection = DriverManager.getConnection(DATABASE_URL);
      Logger.getAnonymousLogger().log(Level.INFO, LocalDateTime.now() + ": Connection established");
    } catch (SQLException exception) {
      Logger.getAnonymousLogger().log(Level.SEVERE,
          LocalDateTime.now() + ": Could not connect to SQLite DB");
    }
  }

  public static void disconnect() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (Exception e) {
      Logger.getAnonymousLogger().log(Level.SEVERE,
          LocalDateTime.now() + ": Could not disconnect from SQLite DB");
    }
  }

  public static Connection getConnection() {
    return connection;
  }
}
