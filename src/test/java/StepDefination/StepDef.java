package StepDefination;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class StepDef extends BaseClass {

    @Before
    public void setup()
    {
        log = LogManager.getLogger("StepDef");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("setup executed...");
        driver.manage().window().maximize();
    }

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {

        loginPg = new LoginPage(driver);
        addCustPg = new AddNewCustomerPage(driver);
        searchCustPg = new SearchCustomerPage(driver);
        log.info("browser launched..");
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        log.info("Url opened..");
        }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String emailAdd, String pwd) {
        loginPg.enterEmail(emailAdd);
        loginPg.enterPassword(pwd);
        log.info("email & password entered..");
    }

    @When("Click on Login")
    public void click_on_login() {
        loginPg.clickLogin();
        log.info("clicked on login..");
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle))
        {
            log.warn("Page title pass");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
            log.warn("test failed..");
        }
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    @When("User click on Logout link")
    public void user_click_on_logout_link() {
        loginPg.clickLogout();
        log.info("logout link.");
    }

    @Then("close browser")
    public void close_browser() {
        driver.close();
        log.info("Browser closed...");
    }

    //// Add New Customers/////////

    @Then("User can view the Dashboard")
    public void user_can_view_the_dashboard() {
        String actualTitle = addCustPg.getPageTitle();
        String expectedTitle = "Dashboard / nopCommerce administration";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

        /*
        if (actualTitle.equals(expectedTitle))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }   */

    }
    @When("User click on Customers menu")
    public void user_click_on_customers_menu() {
        addCustPg.clickOnCustomerMenu();
        log.info("customers menu");
    }

    @When("Click on Customers Items")
    public void click_on_customers_items() {
        addCustPg.clickOnCustomerMenuItem();
        log.info("customer menu Items");

    }
    @Then("User click on Add new hyperlink")
    public void user_click_on_add_new_hyperlink() {
        addCustPg.addNew();
        log.info("click on add new customer");

    }
    @Then("User enter customers info")
    public void user_enter_customers_info() {
        //addcustpg.enterEmail("abc14@gmail.com");
        addCustPg.enterEmail(generateEmailID() + "@gmail.com");
        addCustPg.enterPassword("123456");
        addCustPg.enterFirstName("Kumar");
        addCustPg.enterLastName("Mishra");
        addCustPg.enterGender("female");
        addCustPg.enterDOB("6/20/2023");
        addCustPg.enterCompanyName("SBI Enterprise");
        addCustPg.managerOfVender("Vendor 1");
        addCustPg.adminComment("Automation");
        log.info("customer info.");


    }
    @Then("click on Save button")
    public void click_on_save_button() {
        addCustPg.saveBtn();
        log.info("save new customer details");

    }
    @Then("User should view the confirmation message {string}")
    public void user_should_view_the_confirmation_message(String expectedResult) {
        String bodyTag = driver.findElement(By.tagName("body")).getText();
        if (bodyTag.contains(expectedResult)){
            log.warn("confirmation message");
            Assert.assertTrue(true);
        }
        else {
            log.warn("confirmation failed");
            Assert.assertTrue(false);
        }
    }

    ///////Search by Email /////////////////////

    @When("Enter Customer Email")
    public void enter_customer_email() {
        searchCustPg.searchEmail("victoria_victoria@nopCommerce.com");
        log.info("search customer email");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @When("Click on search button")
    public void click_on_search_button() {
        searchCustPg.searchButton();
        log.info("search customer email");
    }

    @Then("user should found Email in the search table")
    public void user_should_found_email_in_the_search_table() {

        try {
            String expectedEmail = "victoria_victoria@nopCommerce.com";
            Assert.assertTrue(searchCustPg.searchCustomerByEmail(expectedEmail) == true);
        } catch (StaleElementReferenceException e) {
            String expectedEmail = "victoria_victoria@nopCommerce.com";
            Assert.assertTrue(searchCustPg.searchCustomerByEmail(expectedEmail) == true);

        }
    }

   @After
   public void tearDown(Scenario sc) throws IOException {
        if (sc.isFailed() ==true){
            //convert webdriver obj to take screenshot
            String filePath = "C:\\Users\\Avinash\\IdeaProjects\\CucumberFramework\\Screenshot\\failedScreenshot.png";
            TakesScreenshot scrshot = ((TakesScreenshot)driver);

            File srcfile = scrshot.getScreenshotAs(OutputType.FILE);
            File destfile = new File(filePath);

            //copy file at destination
            FileUtils.copyFile(srcfile,destfile);

        }
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario sc) {

        if (sc.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            //attached image file report(data,media type, ame of attachment)
            sc.attach(screenshot, "image/png", sc.getName());
        }
    }

}