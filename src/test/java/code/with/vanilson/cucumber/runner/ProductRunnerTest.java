package code.with.vanilson.cucumber.runner;

/**
 * ProductRunnerTest
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"code.with.vanilson.cucumber.steps", "code.with.vanilson.cucumber.config"},
        plugin = {"pretty", "html:target/cucumber.html"},
        tags = "not @ignore_product_management"
)
public class ProductRunnerTest {
    /**
     * to run this uncommenting the application.yml for postgres,
     * make sure the steps are well-defined to not interact with the real database
     */
}