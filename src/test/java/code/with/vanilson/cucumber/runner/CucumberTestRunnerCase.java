package code.with.vanilson.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/**
 * CucumberTestRunnerCase
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */

@SuppressWarnings("NewClassNamingConvention")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty"},
        glue = {"code.with.vanilson.cucumber.glue"},
        tags = "not @ignore_product_management")
public class CucumberTestRunnerCase {
}