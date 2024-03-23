package co.cstad.spring_web_mvc.service;

import co.cstad.spring_web_mvc.dto.CategoryRequest;
import co.cstad.spring_web_mvc.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse>findCategories();
    void createNewCategory(CategoryRequest request);
    void editCategoryById(Integer id , CategoryRequest request);
    void deleteCategoryById(Integer id);
    CategoryResponse findCategoryById(Integer id);
    CategoryResponse findCategoryByName(String name);
}
