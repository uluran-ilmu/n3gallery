package N3Gallery.utils;

import java.sql.SQLException;
import java.util.ArrayList;

import N3Gallery.dao.BrandDao;
import N3Gallery.dao.ProductDao;
import N3Gallery.model.Brand;
import N3Gallery.model.Product;

public class Seeder {
  private ArrayList<Brand> brands;
  private ArrayList<Product> products;
  private BrandDao brandDao;
  private ProductDao productDao;

  public Seeder() {
    brands = new ArrayList<>();
    products = new ArrayList<>();
    brandDao = new BrandDao();
    productDao = new ProductDao();
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
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    products.add(new Product("Samsung Galaxy Z Fold4 12/256GB - Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/g/a/galaxy_z_fold4_phantom_black_1.jpg", 22499000));
    products.add(new Product("Samsung Galaxy Z Fold3 5G 12/256GB - Phantom Black", true, brands.get(0), "https://cdn.eraspace.com/media/catalog/product/s/a/samsung-galaxy-fold3-black-new-1_1_1.jpg", 19999000));
    
    products.forEach(product -> {
      try {
        productDao.create(product);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    });
  }

  public void run() {
    seedBrands();
    seedProducts();
  }
}
