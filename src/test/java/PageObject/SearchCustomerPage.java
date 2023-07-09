package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {

    WebDriver ldriver;

    public SearchCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id = "SearchEmail")
    WebElement email;

    @FindBy(id = "search-customers")
    WebElement search_btn;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
    //@FindBy(xpath = "//table[@role='grid']")
    WebElement searchResult;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
    List<WebElement> tableColons;

    @FindBy(id = "SearchFirstName")
    WebElement searchFName;

    @FindBy(id = "SearchLastName")
    WebElement searchLName;

    public void searchEmail(String emailAddress)
    {
        email.sendKeys(emailAddress);
    }
    public void searchButton()
    {
        search_btn.click();
    }
    public boolean searchCustomerByEmail(String emailAdd)
    {
        boolean found = false;
        int totalRows = tableRows.size();

        for (int i=1;i<=totalRows;i++)
        {
            WebElement webEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i + "]/td[2]"));
            String actualEmail = webEmail.getText();
            if(actualEmail.equals(emailAdd))
            {
                found =true;
            }

        }
        return found;
    }

    public void enterFirstName(String fName)
    {
        searchFName.sendKeys(fName);
    }

    public void enterLastName(String lName)
    {
        searchLName.sendKeys(lName);
    }
    public boolean searchByFNameLName(String name)
    {
        boolean found1=false;
        int tRows = tableRows.size();
        for (int i=1;i<=tRows;i++)
        {
            WebElement WebName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i + "]/td[3]"));
            String actualName = WebName.getText();
            if(actualName.equals(name))
            {
                found1=true;
                break;
            }
        }
        return found1;
    }

}