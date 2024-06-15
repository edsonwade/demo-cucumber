package code.with.vanilson.cucumber.space.alien;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * AlienController
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@RestController()
@RequestMapping("/alien")
@RequiredArgsConstructor
public class AlienController {
    private final AlienRepository alienRepository;
    private final WeightGainEnabledService weightGainEnabledService;

    @GetMapping
    List<Alien> listAllAliens() {
        return alienRepository.findAll();
    }

    @PostMapping("/{enableWeightGain}")
    @SuppressWarnings("java:S4684")
    Alien createAlien(@RequestBody @Valid Alien newAlien, @PathVariable("enableWeightGain") boolean enableWeightGain) {
        if (enableWeightGain) {
            weightGainEnabledService.enableWeightGain();
        }
        return alienRepository.save(newAlien);
    }

}