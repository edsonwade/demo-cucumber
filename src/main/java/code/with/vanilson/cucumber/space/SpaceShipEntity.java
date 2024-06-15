package code.with.vanilson.cucumber.space;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * SpaceShipEntity
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SpaceShipEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String shipName;
    private Integer fuel;
    private Double maxSpeed;
}