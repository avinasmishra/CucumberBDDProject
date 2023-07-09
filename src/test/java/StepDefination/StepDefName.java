package StepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.StaleElementReferenceException;

public class StepDefName extends BaseClass{
    ///////Search by Name  (Here we creating multiple step def file///////////////////

    @When("Enter Customer FirstName")
    public void enter_customer_first_name() {
        searchCustPg.enterFirstName("Victoria");
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @When("Enter Customer LastName")
    public void enter_customer_last_name() {
        searchCustPg.enterLastName("Terces");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user should found Name in the search table")
    public void user_should_found_name_in_the_search_table() {
        try {
            String expectedName = "Victoria Terces";
            if(searchCustPg.searchByFNameLName(expectedName) == true)
            {
                log.info("found name in search table");
                Assert.assertTrue(true);
            }
            else {
                log.error("name not found in search table");
                Assert.assertTrue(false);

            }
        }
        catch (StaleElementReferenceException e){
            String expectedName = "Victoria Terces";
            if(searchCustPg.searchByFNameLName(expectedName) == true)
            {
                log.info("found name in search table...");
                Assert.assertTrue(true);
            }
            else {
                log.error("name not found in search table...");
                Assert.assertTrue(false);
            }
        }

    }
}
