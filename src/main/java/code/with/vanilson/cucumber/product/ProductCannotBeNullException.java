package code.with.vanilson.cucumber.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ProductCannotBeNullException
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductCannotBeNullException extends RuntimeException {
    public ProductCannotBeNullException(String message) {
        super(message);
    }
}