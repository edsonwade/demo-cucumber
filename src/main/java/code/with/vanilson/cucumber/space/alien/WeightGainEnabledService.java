package code.with.vanilson.cucumber.space.alien;
import org.springframework.stereotype.Service;
/**
 * WeightGainEnabledService
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@Service
public class WeightGainEnabledService {
    private final ThreadLocal<Boolean> shouldAddWeight = ThreadLocal.withInitial(() -> false);

    public void enableWeightGain() {
        shouldAddWeight.set(true);
    }

    public boolean isEnabled() {
        return shouldAddWeight.get();
    }

    public void remove() {
        shouldAddWeight.remove();
    }
}