package code.with.vanilson.cucumber.space.alien;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/**
 * AlienType
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@Getter
@RequiredArgsConstructor
public enum AlienType {
    WOOKIE("Wookie"),
    MARTIAN("Martian"),
    EWOK("Ewok");
    private final String type;
}