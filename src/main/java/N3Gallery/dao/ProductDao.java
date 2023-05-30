package N3Gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import N3Gallery.DB;
import N3Gallery.model.Product;

public class ProductDao {
  private Connection connection;

  public ProductDao() {
    connection = DB.getConnection();
  }

  public int create(Product product) throws SQLException {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO products (id,name,brandId,imageLink,isAvailable,price) VALUES (?,?,?,?,?,?);");

      statement.setString(1, product.getId());
      statement.setString(2, product.getName());
      statement.setString(3, product.getBrand().getId());
      statement.setString(4, product.getImageLink());
      statement.setInt(5, product.isAvailable() ? 1 : 0);
      statement.setString(6, String.valueOf(product.getPrice()));

      return statement.executeUpdate();
    } catch (SQLException e) {
      throw e;
    }
  }
}
