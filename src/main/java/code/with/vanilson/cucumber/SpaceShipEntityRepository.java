package code.with.vanilson.cucumber;

import code.with.vanilson.cucumber.space.SpaceShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SpaceShipEntityRepository
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@SuppressWarnings("unused")
public interface SpaceShipEntityRepository extends JpaRepository<SpaceShipEntity, Integer> {
}