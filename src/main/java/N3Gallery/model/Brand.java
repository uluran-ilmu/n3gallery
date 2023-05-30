package N3Gallery.model;

import java.util.UUID;

public class Brand {
  private String id;
  private String name;
  private String createdAt;
  private String updatedAt;

  public Brand(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
  }

  public Brand(String id, String name, String createdAt, String updatedAt) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }
}
