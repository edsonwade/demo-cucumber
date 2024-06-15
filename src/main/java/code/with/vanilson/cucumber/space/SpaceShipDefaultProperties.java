package code.with.vanilson.cucumber.space;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * SpaceShipDefaultProperties
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */

@ConfigurationProperties(prefix = "space.ship.default")
public record SpaceShipDefaultProperties(
        Integer fuel,
        String name,
        Double maxSpeed
) {
}