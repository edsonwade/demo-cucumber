package code.with.vanilson.cucumber.space.alien;
import lombok.RequiredArgsConstructor;

import java.util.List;
/**
 * WookieInListLogic
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */

@RequiredArgsConstructor
public class WookieInListLogic {
    private final List<Alien> aliens;
    private static final String WOOKIE_TYPE = "wookie";

    public boolean containsWookiesOldFashion() {
        boolean wookie = false;
        for (Alien alien : aliens) {
            if (WOOKIE_TYPE.equalsIgnoreCase(alien.getType())) {
                wookie = true;
                break;
            }
        }
        return wookie;
    }

    public boolean containsWookie() {
        return aliens.stream()
                .map(WookieLogic::new)
                .anyMatch(WookieLogic::isWookie);
    }

}