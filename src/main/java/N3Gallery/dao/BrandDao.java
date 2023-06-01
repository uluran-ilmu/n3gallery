package N3Gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import N3Gallery.DB;
import N3Gallery.model.Brand;

public class BrandDao {
  private Connection connection;

  public BrandDao() {
    connection = DB.getConnection();
  }

  public Brand getBrand(String id) throws SQLException {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM brands WHERE id=?");

      statement.setString(1, id);

      ResultSet rs = statement.executeQuery();

      Brand brand = null;

      while (rs.next()) {
        brand = new Brand(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("createdAt"),
            rs.getString("updatedAt"));
      }

      return brand;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
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
