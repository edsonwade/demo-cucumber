package code.with.vanilson.cucumber.space;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * SpaceShipEntity
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@Entity
@Data
@Table(name = "space_ship_entity")
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