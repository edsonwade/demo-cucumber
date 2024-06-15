package code.with.vanilson.cucumber.space.greeting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * GreetingService
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */
@SuppressWarnings("unused")
@Service
@Slf4j
@RequiredArgsConstructor
public class GreetingService {

    public String greet(String greeting, String name) {
        return String.format("%s %s", greeting, name);
    }
}