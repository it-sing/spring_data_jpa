package co.cstad.spring_web_mvc.service;

import co.cstad.spring_web_mvc.dto.ProductRequest;
import co.cstad.spring_web_mvc.dto.ProductEditRequest;
import co.cstad.spring_web_mvc.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void  deleteProductByUuid(String uuid);
    void editProductByUuid(String uuid, ProductEditRequest request);
    void createNewProduct(ProductRequest request);
    List<ProductResponse> findProducts();
    ProductResponse findProductById(Integer id);
    ProductResponse findProductByUuid(String uuid);
}
