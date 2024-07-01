package code.with.vanilson.cucumber.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * Product
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer quantity;
    private Double price;
}