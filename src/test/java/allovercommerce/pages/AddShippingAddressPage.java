package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddShippingAddressPage {

    public AddShippingAddressPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement userNameOrEmailAddressBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement loginSignInButton;

    @FindBy(xpath = "//*[@id='menu-item-1079']/a")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addressesButton;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement addButton;

    @FindBy(css = "#shipping_first_name")
    public WebElement firstNameBox;

    @FindBy(css = "#shipping_last_name")
    public WebElement lastNameBox;

    @FindBy(css = "#shipping_country")
    public WebElement countryRegionBox;

    @FindBy(xpath = "//input[@data-placeholder='House number and street name']")
    public WebElement streetAddressBox;

    @FindBy(xpath = "//*[@id='shipping_city']")
    public WebElement townCityBox;

    @FindBy(xpath = "//select[@id='shipping_state']")
    public WebElement stateBox;

    @FindBy(xpath = "//input[@id='shipping_postcode']")
    public WebElement zipCodeBox;

    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveAddressButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addressChangedSuccessfullyMessage;

    @FindBy(xpath = "//li[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement isARequiredFieldMessage;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//span[@class='icon-box-icon icon-logout']")
    public WebElement logOutButton;


    public void deleteMethod(WebElement webElement) {

        String codeValue = webElement.getAttribute("value");
        for (int i = 0; i < codeValue.length(); i++) {
            webElement.sendKeys(Keys.BACK_SPACE);
        }

    }






}
