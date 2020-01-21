package api.test.pet;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/",
        glue = "stepDefinitions",
        tags = {"@petAPITest"},
        plugin  = {"pretty",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber.json"},
        strict = true)

//This is a test
public class petApiRunner {

}
