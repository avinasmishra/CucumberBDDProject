package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

    WebDriver ldriver;

    public AddNewCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[@href='#']/p[contains(text(),'Customers')]")
    WebElement customer_menu;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']/p[contains(text(),'Customers')]")
    WebElement customer_menuItem;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement add_new;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "FirstName")
    WebElement firstname;

    @FindBy(id = "LastName")
    WebElement lastname;

    @FindBy(id = "Gender_Male")
    WebElement male_gender;

    @FindBy(id = "Gender_Female")
    WebElement female_gender;

    @FindBy(id = "DateOfBirth")
    WebElement dob;

    @FindBy(name = "Company")
    WebElement comapny_name;

    @FindBy(id = "IsTaxExempt")
    WebElement tax;

    @FindBy(name = "save")
    WebElement btn_save;

    @FindBy(id = "AdminComment")
    WebElement adminComment;

    @FindBy(id = "VendorId")
    WebElement managerVendor;

    public void managerOfVender(String value){
        Select drp = new Select(managerVendor);
        drp.selectByVisibleText(value);
    }

    public void adminComment(String comment){
        adminComment.sendKeys(comment);
    }

    public void enterCompanyName(String cname){
        comapny_name.sendKeys(cname);
    }
    public void enterDOB(String dateofbirth){
        dob.sendKeys(dateofbirth);
    }

    public void enterGender(String gender){
        if (gender.equalsIgnoreCase("male")){
            male_gender.click();
        } else if (gender.equalsIgnoreCase("female")) {
            female_gender.click();
        }
        else {
            male_gender.click();
        }

    }
    public String getPageTitle()
    {
        return ldriver.getTitle();
    }
    public void clickOnCustomerMenu() {
        customer_menu.click();
    }

    public void clickOnCustomerMenuItem() {
        customer_menuItem.click();
    }

    public void addNew() {
        add_new.click();
    }

    public void enterEmail(String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void enterPassword(String pwd) {

        password.sendKeys(pwd);
    }

    public void enterFirstName(String fname) {

        firstname.sendKeys(fname);
    }

    public void enterLastName(String lname) {

        lastname.sendKeys(lname);
    }
    public void saveBtn(){
        btn_save.click();
    }

}