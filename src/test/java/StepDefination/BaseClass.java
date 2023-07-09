package StepDefination;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    public static WebDriver driver;
    public static LoginPage loginPg;
    public static AddNewCustomerPage addCustPg;
    public static SearchCustomerPage searchCustPg;

    public static Logger log;

    //to generate random email id
    public String generateEmailID()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }
}
