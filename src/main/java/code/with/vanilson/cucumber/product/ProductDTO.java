package code.with.vanilson.cucumber.product;

import jakarta.validation.constraints.*;
import lombok.*;
import org.aspectj.bridge.IMessage;



/**
 * ProductDTO
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    @NotNull(message = " id should not be null")
    Integer id;
    @NotNull(message = " name should not be null")
    String name;
    @NotNull(message = " quantity should not be null")
    int quantity;
    @NotNull(message = " price should not be null")
    @NotEmpty()
    double price;
}