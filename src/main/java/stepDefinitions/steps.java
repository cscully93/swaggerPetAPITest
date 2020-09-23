package stepDefinitions;

import actions.deleteActions;
import actions.getActions;
import actions.postActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = {"actions"})
public class steps {

    private static ConfigurableApplicationContext context = SpringApplication.run(steps.class);
    private static postActions post = context.getBean(postActions.class);
    private static getActions get = context.getBean(getActions.class);
    private static deleteActions delete = context.getBean(deleteActions.class);

    @Before
    public void before(Scenario scenario) {
        String scenarioName = scenario.getName();
        System.out.println("------------------------------");
        System.out.println("Running Scenario: " + scenarioName);
        System.out.println("------------------------------");
    }

    @After
    public void after() {
        System.out.println("------------------------------");
        System.out.println("Scenario has completed");
        System.out.println("------------------------------");
    }

    @Given("the user builds the postPet API")
    public void the_user_builds_the_postPet_API() {
        post.buildAPI();
    }

    @When("the user runs the postPet API")
    public void the_user_runs_the_postPet_API() throws IOException {
        post.postPet();
    }

    @Then("the API will be run successfully")
    public void the_API_will_create_the_Pet_in_the_store() {
        post.checkActualResult();
    }

    @Given("the user builds the getPet API")
    public void the_user_builds_the_getPet_API() {
        get.buildAPI();
    }

    @When("the user runs the getPet API")
    public void the_user_runs_the_getPet_API() throws IOException {
        get.getPetById();
        get.checkStatus();
    }

    @When("the verifies the details are correct")
    public void the_verifies_the_details_are_correct() {

        get.verifyPetDetails();

    }

    @Then("the details will be returned correctly")
    public void the_details_will_be_returned_correctly() {
        get.printDetails();
        get.writePetToFile();

    }

    @Given("the user builds the postPetUpdate API to up")
    public void the_user_builds_the_postPetUpdate_API_to_up() {
    post.buildUpdateAPI();
    }

    @When("the user runs the postPetUpdate API")
    public void the_user_runs_the_postPetUpdate_API() throws IOException {
       post.postPetUpdateName();
    }

    @Then("the API will update the pet's name")
    public void the_API_will_update_the_pet_s_name() {
        post.checkActualResult();
    }

    @Then("the name will be verified as changed.")
    public void the_name_will_be_verified_as_changed() throws IOException {
        get.buildAPI();
        get.getPetById();
        get.checkStatus();
        get.printDetails();
    }

    @Given("the user builds the deletePet API")
    public void the_user_builds_the_deletePet_API() {
       delete.buildAPI();
    }

    @When("the user runs the deletePet API")
    public void the_user_runs_the_deletePet_API() throws IOException {
        delete.deletePetById();
    }

    @Then("the pet will be deleted")
    public void the_pet_will_be_deleted() {
        delete.checkActualResult();
    }

    @Then("verified as no longer existing on database")
    public void verified_as_no_longer_existing_on_database() throws IOException {
        get.buildAPI();
        get.getPetById();
        get.checkStatus();
    }


}
