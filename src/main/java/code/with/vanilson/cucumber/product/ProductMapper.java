package code.with.vanilson.cucumber.product;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ProductMapper
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
@Component
public class ProductMapper {



    public ProductDTO mapToProductDto(Product product) {
        if (product == null) {
            throw new ProductCannotBeNullException("product is null");
        }
        return new ProductDTO(
                product.getId(), product.getName(), product.getQuantity(), product.getPrice()
        );

    }

    public List<ProductDTO> mapToProductDTOList(List<Product> product) {
        if (product.isEmpty()) {
            throw new ProductCannotBeNullException("product is null");
        }
        return product.stream()
                .map(this::mapToProductDto)
                .toList();

    }

}