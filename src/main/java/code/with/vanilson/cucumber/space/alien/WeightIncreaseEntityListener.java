package code.with.vanilson.cucumber.space.alien;

import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * WeightIncreaseEntityListener
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class WeightIncreaseEntityListener {
    private final WeightGainEnabledService weightGainEnabledService;

    @PrePersist
    public void justBeforePersist(Object object) {
        log.info("Listened for object with type {}", object.getClass().getSimpleName());
        if (weightGainEnabledService.isEnabled()) {
            if (object instanceof Alien alien) {
                alien.setWeight(alien.getWeight() + 5);
                log.info("Added weight to alien. Alien now looks like this: {}", alien);
            }
        } else {
            log.warn("Weight Gain service has been disabled");
        }
    }

}