package N3Gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import N3Gallery.DB;
import N3Gallery.model.Brand;

public class BrandDao {
  private Connection connection;

  public BrandDao() {
    connection = DB.getConnection();
  }

  public int create(Brand brand) throws SQLException {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO brands (id,name) VALUES (?,?);");

      statement.setString(1, brand.getId());
      statement.setString(2, brand.getName());

      return statement.executeUpdate();
    } catch (SQLException e) {
      throw e;
    }
  }
}
