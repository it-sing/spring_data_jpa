package co.cstad.spring_web_mvc.service.impl;

import co.cstad.spring_web_mvc.dto.CategoryRequest;
import co.cstad.spring_web_mvc.dto.CategoryResponse;
import co.cstad.spring_web_mvc.model.Category;
import co.cstad.spring_web_mvc.repository.CategoryRepository;
import co.cstad.spring_web_mvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {
    private  final CategoryRepository categoryRepository;
    @Override
    public void createNewCategory(CategoryRequest request) {
//        check exit
        if (categoryRepository.existsByName(request.name())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category already exists"
            );
        }
        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());
        categoryRepository.save(category);
    }

    @Override
    public CategoryResponse findCategoryByName(String name) {

        return null;
    }


    @Override
    public List<CategoryResponse> findCategories() {
        List<Category> categories = categoryRepository.findAll();
        return  categories.stream()
                .map(category ->
                        new CategoryResponse(category.getName(),
                                category.getDescription()))
                .toList();
    }
    @Override
    public CategoryResponse findCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Category has not been found"
                ));
        return new CategoryResponse(category.getName() , category.getDescription());

    }
    @Override
    public void editCategoryById(Integer id , CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category has not been found!"
                ));
        category.setName(request.name());
        category.setDescription(request.description());

        categoryRepository.save(category);
        this.findCategoryById(id);
    }
    @Override
    public void deleteCategoryById( Integer id) {
        //        check exit
        if (!categoryRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Category has not been found!"
            );
        }
        categoryRepository.deleteById(id);
    }



}
