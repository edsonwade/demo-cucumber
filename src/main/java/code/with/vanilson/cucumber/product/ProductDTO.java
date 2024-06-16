package code.with.vanilson.cucumber.product;

import lombok.*;
import org.aspectj.bridge.IMessage;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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