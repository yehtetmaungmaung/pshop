package dev.thoon.pshop.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.thoon.pshop.dto.EditProductForm;
import dev.thoon.pshop.dto.FilterProduct;
import dev.thoon.pshop.dto.NewProductForm;
import dev.thoon.pshop.entity.Category;
import dev.thoon.pshop.entity.Producer;
import dev.thoon.pshop.entity.Product;
import dev.thoon.pshop.entity.SpecCategory;
import dev.thoon.pshop.entity.Subcategory;

public interface ProductService {
    Product findProductById(Long id);

    List<Product> findByNameContaining(String name);

    Page<Product> findProductBySearch(String name, Pageable pageable);

    List<Subcategory> findAllSubCategory();

    List<Category> findAllCategory();

    List<Producer> findAllProducer();

    List<SpecCategory> findAllSpecCategory();

    Product editProduct(EditProductForm editProductForm);

    Product createProduct(NewProductForm productForm);

    List<Product> listAllProductsBySpecCategory(int id, Pageable pageable);

    Category findCategoryByUrl(String url);

    Page<Product> findAllProductBySubCategoryURL(String categoryURL, Pageable pageable);

    Map<String, BigDecimal> getMinMaxPriceProductBySubcategory(Subcategory subcategory);

    Map<String, BigDecimal> getMinMaxPriceProductBySearchName(String search);

    List<Producer> getProducersBySearchProductName(String search);

    Product createOrEditProduct(Product product, final NewProductForm productForm);

    List<Producer> getProducersByCategoryURL(String categoryURL);

    Subcategory findSubcategoryByURL(String categoryURl);

    Page<Product> getProductByFilter(FilterProduct filterProduct, Pageable pageable);

    Collection<Product> findAll();

    public Subcategory getSubcategoryById(Long id);
}
