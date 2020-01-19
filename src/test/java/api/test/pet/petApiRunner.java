package api.test.pet;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features/pet.feature",
        glue = "stepDefinitions",
        tags = {"@petAPITest"},
        plugin = {"pretty",
                "html:target/cucumber-reports"},
        strict = true)

public class petApiRunner {

}
