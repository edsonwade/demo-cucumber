package code.with.vanilson.cucumber.space.alien;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * AlienException
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@RequiredArgsConstructor
@Getter
@ToString
public class AlienException extends RuntimeException {
    private final String message;
}
