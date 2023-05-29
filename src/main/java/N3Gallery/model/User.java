package N3Gallery.model;

import java.util.UUID;

public class User {
  private String id;
  private String name;
  private String email;
  private String password;
  private String createdAt;
  private String updatedAt;

  public User(String id, String name, String email, String password, String createdAt, String updatedAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public User(String name, String email, String password) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }
}
