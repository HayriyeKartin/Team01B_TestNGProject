package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailsPage {


    public AccountDetailsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id=\"menu-item-1079\"]/a")
    public WebElement myAccount;

    @FindBy(css = "#username")
    public WebElement signInUserName;

    @FindBy(css = "#password")
    public WebElement signInPassword;

    @FindBy(xpath = "//button[@type='submit' and @name='login']")
    public WebElement signInButton;

    @FindBy(partialLinkText = "Account details")
    public WebElement accountDetailsButton;

    @FindBy(xpath = "//h4[.='Account Details']")
    public WebElement accountDetailsText;

    @FindBy(id = "account_first_name")
    public WebElement firstNameBox;

    @FindBy(id = "account_last_name")
    public WebElement lastNameBox;

    @FindBy(id = "account_display_name")
    public WebElement displayNameBox;


    @FindBy(xpath = "//*[@class='woocommerce-Button button btn btn-dark btn-rounded btn-sm']")
    public WebElement saveChangesButton;

    @FindBy(id = "account_email")
    public WebElement emailAddressButton;

    @FindBy(xpath = "//iframe[@id='user_description_ifr']")
    public WebElement biographyIframe;

    @FindBy(xpath = "//button[@id='user_description-html']")
    public WebElement biographyTextButton; //text butonu

    @FindBy(xpath = "//*[.='Biography']")
    public WebElement biographyText; //scroll yapacagımız yazı


    @FindBy(css = ".wp-editor-area")
    public WebElement biographyPage; //yazı yazacagımız alan

    @FindBy(xpath = "//*[@data-id='user_description']")
    public WebElement metinAlani;

    @FindBy(xpath = "//a[.='Account details']")
    public WebElement accountDetails;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement changedSuccessfullyAlert;













}
