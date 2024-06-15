package code.with.vanilson.cucumber;

/**
 * SpaceShipDto
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */

import code.with.vanilson.cucumber.space.SpaceShipEntity;

import java.io.Serializable;

/**
 * A DTO for the {@link SpaceShipEntity} entity
 */
public record SpaceShipDto(Integer id, String shipName, Integer fuel, Double maxSpeed) implements Serializable {
}