package api.test.pet;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features/",
        glue = "stepDefinitions",
        tags = "@petAPITest",
        publish = true,
        plugin  = {"pretty",
                "html:target/cucumber-pretty",
                "json:target/cucumber.json"})
public class petApiRunner extends AbstractTestNGCucumberTests {

}
