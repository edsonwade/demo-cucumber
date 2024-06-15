package code.with.vanilson.cucumber.space.alien;

import lombok.RequiredArgsConstructor;

/**
 * WookieLogic
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@RequiredArgsConstructor
public class WookieLogic {
    private final Alien alien;
    private static final String WOOKIE_TYPE = "wookie";

    public boolean isWookie() {
        if (alien == null) {return false;}
        return WOOKIE_TYPE.equalsIgnoreCase(alien.getType());
    }
}