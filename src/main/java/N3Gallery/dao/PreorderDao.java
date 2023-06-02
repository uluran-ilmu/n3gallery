package N3Gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import N3Gallery.DB;
import N3Gallery.model.Preorder;

public class PreorderDao {
    private Connection connection;

    public PreorderDao() {
      this.connection = DB.getConnection();
    }

    public int create(Preorder preorder) throws SQLException {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO preorder (id,productId,userId,phoneNumber,province,city,address) VALUES (?,?,?,?,?,?,?);");

      statement.setString(1, preorder.getId());
      statement.setString(2, preorder.getProduct().getId());
      statement.setString(3, preorder.getUser().getId());
      statement.setString(4, preorder.getPhoneNumber());
      statement.setString(5, preorder.getProvince());
      statement.setString(6, preorder.getCity());
      statement.setString(7, preorder.getAddress());

      return statement.executeUpdate();
    } catch (SQLException e) {
      throw e;
    }
  }
}
