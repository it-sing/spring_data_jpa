package co.cstad.spring_web_mvc.service.impl;

import co.cstad.spring_web_mvc.dto.ProductEditRequest;
import co.cstad.spring_web_mvc.dto.ProductRequest;
import co.cstad.spring_web_mvc.dto.ProductResponse;
import co.cstad.spring_web_mvc.model.Product;
import co.cstad.spring_web_mvc.repository.ProductRepository;
import co.cstad.spring_web_mvc.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public void createNewProduct(ProductRequest request ) {
        //        check exit
        if (productRepository.existsByName(request.name())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category already exists"
            );
        }

        Product  product = new Product();
        product.setUuid(UUID.randomUUID().toString());
        product.setStatus(true);
        product.setImportedDate(LocalDateTime.now());
        product.setName(request.name());
        product.setPrice(request.price());
        product.setQty(request.qty());

        productRepository.save(product);
    }

    @Override
    public List<ProductResponse> findProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product ->
                new ProductResponse(product.getUuid() , product.getName(),
                        product.getPrice(),product.getQty()))
                .toList();
    }

    @Override
    public ProductResponse findProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Category has not been found"
                ));
        return  new ProductResponse(product.getUuid() , product.getName(), product.getPrice() , product.getQty());
    }

    @Override
    public ProductResponse findProductByUuid(String uuid) {
        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Category has not been found"
                ));
        return  new ProductResponse(product.getUuid() , product.getName(), product.getPrice() , product.getQty());
    }
    @Override
    public void deleteProductByUuid(String uuid) {
        if (!productRepository.existsByUuid(uuid)){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category already exists"
            );
        }
        productRepository.deleteByUuid(uuid);
    }

    @Override
    public void editProductByUuid(String uuid, ProductEditRequest request) {
        Product product = productRepository.findByUuid(uuid)
              .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Category has not been found"
                ));
        product.setName(request.name());
        product.setPrice(request.price());
        productRepository.save(product);
    }

}
