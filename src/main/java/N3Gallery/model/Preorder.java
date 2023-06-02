package N3Gallery.model;

import java.util.UUID;

public class Preorder {
  private String id;
  private Product product;
  private User user;
  private String phoneNumber;
  private String province;
  private String city;
  private String address;
  private String createdAt;
  private String updatedAt;

  public Preorder(Product product, User user, String phoneNumber, String province, String city, String address) {
    this.id = UUID.randomUUID().toString();
    this.product = product;
    this.user = user;
    this.phoneNumber = phoneNumber;
    this.province = province;
    this.city = city;
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

}
