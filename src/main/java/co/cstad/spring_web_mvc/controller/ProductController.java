package co.cstad.spring_web_mvc.controller;

import co.cstad.spring_web_mvc.dto.ProductEditRequest;
import co.cstad.spring_web_mvc.dto.ProductRequest;
import co.cstad.spring_web_mvc.dto.ProductResponse;
import co.cstad.spring_web_mvc.model.Product;
import co.cstad.spring_web_mvc.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
//declare the base path
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;
    @Operation(summary = "Get all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Products",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Products not found",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewProduct(@Valid @RequestBody ProductRequest request) {
        productServiceImpl.createNewProduct(request);
    }
    @GetMapping
    List<ProductResponse>findProducts(){
        return productServiceImpl.findProducts();
    }
    @GetMapping("{id}")
    public ResponseEntity<?> findCategoryById (@PathVariable Integer id){
        return ResponseEntity.ok(productServiceImpl.findProductById(id));
    }
    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<?> findUuidByUuId (@PathVariable String uuid){
        return ResponseEntity.ok(productServiceImpl.findProductByUuid(uuid));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    void deleteProductByUuid(@PathVariable String uuid) {
        productServiceImpl.deleteProductByUuid(uuid);
    }
    @PutMapping("/{uuid}")
    void editProductByUuid(@PathVariable String uuid,
                           @RequestBody ProductEditRequest request) {
        productServiceImpl.editProductByUuid(uuid, request);
    }
}
