package N3Gallery.utils;

import java.sql.SQLException;
import java.util.ArrayList;

import N3Gallery.dao.BrandDao;
import N3Gallery.model.Brand;
import N3Gallery.model.Product;

public class Seeder {
  private ArrayList<Brand> brands;
  private ArrayList<Product> products;
  private BrandDao brandDao;

  public Seeder() {
    brands = new ArrayList<>();
    products = new ArrayList<>();
    brandDao = new BrandDao();
  }

  private void seedBrands() {
    brands.add(new Brand("Samsung"));
    brands.add(new Brand("Apple"));
    brands.add(new Brand("Xiaomi"));
    brands.add(new Brand("Realme"));
    brands.add(new Brand("Oppo"));

    brands.forEach(brand -> {
      try {
        brandDao.create(brand);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    });
  }

  private void seedProducts() {

  }

  public void run() {
    seedBrands();
  }
}
