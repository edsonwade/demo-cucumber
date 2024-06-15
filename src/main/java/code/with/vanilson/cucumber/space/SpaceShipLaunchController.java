package code.with.vanilson.cucumber.space;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * SpaceShipLaunchController
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */


@RestController
@RequestMapping("/launch")
public class SpaceShipLaunchController {

    @GetMapping("/counter/{lastCount}")
    public String countDown(@PathVariable  int lastCount)
    {
        int nextCount = lastCount-1;
        return nextCount > 0 ? "T-" + nextCount : "Launch! Go go go!";
    }
}