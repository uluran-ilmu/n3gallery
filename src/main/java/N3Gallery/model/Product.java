package N3Gallery.model;

import java.util.UUID;

public class Product {
  private String id;
  private String name;
  private boolean isAvailable;
  private Brand brand;
  private String imageLink;
  private double price;
  private String createdAt;
  private String updatedAt;

  public Product(String name, boolean isAvailable, Brand brand, String imageLink, double price) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.isAvailable = isAvailable;
    this.brand = brand;
    this.imageLink = imageLink;
    this.price = price;
  }

  public Product(String id, String name, boolean isAvailable, Brand brand, String imageLink, double price, String createdAt, String updatedAt) {
    this.id = id;
    this.name = name;
    this.isAvailable = isAvailable;
    this.brand = brand;
    this.imageLink = imageLink;
    this.price = price;
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

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public String getImageLink() {
    return imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }
}
