package N3Gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import N3Gallery.DB;
import N3Gallery.model.Brand;
import N3Gallery.model.Product;

public class ProductDao {
  private Connection connection;

  public ProductDao() {
    connection = DB.getConnection();
  }

  public ArrayList<Product> getProducts() throws SQLException {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM products;");

      ResultSet rs = statement.executeQuery();

      ArrayList<Product> products = new ArrayList<>();

      while (rs.next()) {
        Product product = new Product(
            rs.getString("id"),
            rs.getString("name"),
            rs.getInt("isAvailable") == 1,
            new Brand(""),
            rs.getString("imageLink"),
            Double.valueOf(rs.getString("price")),
            rs.getString("createdAt"),
            rs.getString("updatedAt"));

        products.add(product);
      }

      return products;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
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
