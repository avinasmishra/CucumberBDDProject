package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver lDriver;

    public LoginPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    @FindBy(id = "Email")
    WebElement emailId;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginBtn;

    @FindBy(linkText = "Logout")
    WebElement logout;

    public void enterEmail(String emailAddress) {
        emailId.clear();
        emailId.sendKeys(emailAddress);
    }

    public void enterPassword(String pwd) {
        password.clear();
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void clickLogout()
    {
        logout.click();
    }
}
