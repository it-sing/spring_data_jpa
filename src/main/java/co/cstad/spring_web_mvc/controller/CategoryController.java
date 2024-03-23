package co.cstad.spring_web_mvc.controller;

import co.cstad.spring_web_mvc.dto.CategoryRequest;
import co.cstad.spring_web_mvc.dto.CategoryResponse;
import co.cstad.spring_web_mvc.model.Product;
import co.cstad.spring_web_mvc.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private  final CategoryServiceImpl categoryServiceImpl;

    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the categories",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Categories not found",
                    content = @Content)
    })

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewCategory (@Valid @RequestBody CategoryRequest request){
        categoryServiceImpl.createNewCategory(request);
    }
    @GetMapping
    List<CategoryResponse> findAllCategories(){
        return categoryServiceImpl.findCategories();
    }
    @GetMapping("{id}")
    public ResponseEntity <?> findCategoryById (@PathVariable Integer id){
        return ResponseEntity.ok(categoryServiceImpl.findCategoryById(id));
    }
    @PutMapping("{id}")
    void editCategoryById(@PathVariable Integer id,
                           @RequestBody CategoryRequest request){
        categoryServiceImpl.editCategoryById(id, request);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("{id}")
    void deleteCategoryById(@PathVariable Integer id){
        categoryServiceImpl.deleteCategoryById(id);
    }


}

