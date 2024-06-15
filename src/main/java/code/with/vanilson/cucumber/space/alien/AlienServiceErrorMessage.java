package code.with.vanilson.cucumber.space.alien;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/**
 * AlienServiceErrorMessage
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S6548")
public enum AlienServiceErrorMessage {
    ALIEN_NO_TYPE("No aliens where found with type %s");
    private final String message;

    public String oneArgument(String argument) {
        return String.format(message, argument);
    }
}