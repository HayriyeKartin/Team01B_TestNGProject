package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;
    @FindBy(id = "reg_username")
    public WebElement registerUsername;
    @FindBy(id = "reg_email")
    public WebElement registerEmail;
    @FindBy(id = "reg_password")
    public WebElement registerPassword;
    @FindBy(css = "#register-policy")
    public WebElement registerRadioButton;
    @FindBy(xpath = "//button[.='Sign Up']")
    public WebElement registerSignUpButton;
    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement registerSignOutText;

}
