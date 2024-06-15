package code.with.vanilson.cucumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * SpaceShipDtoList
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */

public class SpaceShipDtoList {
    private List<SpaceShipDto> ships;
}