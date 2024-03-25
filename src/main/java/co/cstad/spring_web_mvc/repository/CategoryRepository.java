package co.cstad.spring_web_mvc.repository;
import co.cstad.spring_web_mvc.model.Category;
import co.cstad.spring_web_mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category ,Integer> {
    boolean existsByName(String name);
    Optional<Category> findByName(String name);

}
