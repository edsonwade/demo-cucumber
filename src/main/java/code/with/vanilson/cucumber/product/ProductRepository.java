package code.with.vanilson.cucumber.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
