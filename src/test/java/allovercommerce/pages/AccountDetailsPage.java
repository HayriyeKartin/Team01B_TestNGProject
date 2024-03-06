package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailsPage {


    public AccountDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "My Account")
    public WebElement myAccount;


    @FindBy(partialLinkText = "Account details")
    public WebElement accountDetailsButton;

    @FindBy(id = "account_first_name")
    public WebElement firstNameBox;

    @FindBy(id = "account_last_name")
    public WebElement lastNameBox;

    @FindBy(id = "account_display_name")
    public WebElement displayName;

    @FindBy(id = "account_email")
    public WebElement emailAdress;

    @FindBy(xpath = "//*[@class='woocommerce-Button button btn btn-dark btn-rounded btn-sm']")
    public WebElement saveChangesButton;


    @FindBy(xpath = "//*[@id='tinymce']/p")
    public WebElement biographyTextBox;

    @FindBy(css = "#password_current")
    public WebElement currentPasswordBox;
    @FindBy(css = "#password_1")
    public WebElement newPasswordBox;

    @FindBy(css = "#password_2")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//*[.='Account details changed successfully.']")
    public WebElement changedSuccessfullyAlert;












}
