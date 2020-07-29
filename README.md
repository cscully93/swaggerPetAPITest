# swaggerPetAPITest
I created a maven project and used the Cucumber Framwwork and gherkin syntax to run my tests
I used java objects for each of the API's I needed which contains all the data needed for each API.
In the action package actions classes for each of the API's, this is where they are run from.
After each run a file will be added to the data-created folder

To run this project:
Import it as a maven project and use the following link https://github.com/cscully93/swaggerPetAPITest.git
Ensure on your IDE that you have relevant Cucumber and Gherkin plugins installed.
Once loaded properly navigate to the file petApiRunner.java in the api.test.pet package.

For the full suite of tests ensure that it is that tag is:

@petApiTest - full feature file
@postPet for the test to post a pet to the store
@getPet to retrieve the pet deatils and verify that the details are correct
@updatePet to update the pet name and disaply the pet details again
@deletePet to delete the pet from the database and verify that it has been deleted

