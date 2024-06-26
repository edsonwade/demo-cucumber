package code.with.vanilson.cucumber.runner;

import io.cucumber.junit.platform.engine.Cucumber;

/**
 * CucumberTestRunnerCase
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")  // Adjust this package name as necessary
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "code.with.vanilson.cucumber.steps")
@IncludeEngines("cucumber")

public class CucumberTestRunnerCase {
}