package N3Gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import N3Gallery.DB;
import N3Gallery.model.User;

public class UserDao {
  private Connection connection;

  public UserDao() {
    connection = DB.getConnection();
  }

  public User getUserByEmail(String email) throws SQLException {
    try {
      PreparedStatement statement = connection.prepareStatement(
        "SELECT * FROM users WHERE email=?"
      );

      statement.setString(1, email);

      ResultSet rs = statement.executeQuery();

      User user = null;

      while (rs.next()) {
        user = new User(
          rs.getString("id"),
          rs.getString("name"),
          rs.getString("email"),
          rs.getString("password"),
          rs.getString("createdAt"),
          rs.getString("updatedAt")
        );
      }

      return user;
    } catch (SQLException e) {
      throw e;
    }
  }

  public int create(User user) throws SQLException {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO users (id,name,email,password) VALUES (?,?,?,?);");

      statement.setString(1, user.getId());
      statement.setString(2, user.getName());
      statement.setString(3, user.getEmail());
      statement.setString(4, user.getPassword());

      return statement.executeUpdate();
    } catch (SQLException e) {
      throw e;
    }
  }
}
