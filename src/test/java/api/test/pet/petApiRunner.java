package api.test.pet;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features/",
        glue = "stepDefinitions",
        tags = "@petAPITest",
        plugin  = {"pretty",
                "html:target/cucumber-pretty",
                "json:target/cucumber.json"})

//This is a test
public class petApiRunner extends AbstractTestNGCucumberTests {

}
