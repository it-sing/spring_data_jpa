package co.cstad.spring_web_mvc.repository;

import co.cstad.spring_web_mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Integer> {
    boolean existsByName(String name);
    Optional<Product> findByUuid(String name);
    boolean existsByUuid(String uuid);
    void  deleteByUuid(String uuid);
}
