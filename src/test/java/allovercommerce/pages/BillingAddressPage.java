package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingAddressPage {
    public BillingAddressPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/'])[1]")
    public WebElement userSingInButton;
    @FindBy(css = "#username")
    public WebElement userName;
    @FindBy(css = "#password")
    public WebElement password;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement getSignInLoginSignIn;

    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signOutdakiMyAccount;
    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address']")
    public WebElement Adresbutonu;
    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/billing/']")
    public WebElement Addbutonu;
    @FindBy(id = "billing_first_name")
    public WebElement userBillingAdressFirsName;
    @FindBy(xpath = "//*[@name='billing_last_name']")
    public WebElement userBillingAdressLastName;
    @FindBy(xpath = "//*[@name='billing_company']")
    public WebElement userBillingAdressCompanyName;
    @FindBy (css = "#billing_country")
    public WebElement userBillingAdressCountry;
    @FindBy(xpath = "//*[@name='billing_address_1']")
    public WebElement userBillingStreetAdress1;
    @FindBy(xpath = "//*[@name='billing_address_2']")
    public WebElement userBillingStreetAdres2;

    @FindBy(xpath = "//*[@name='billing_city']")
    public WebElement userBillingAdressTown;
    @FindBy(css = "#billing_state")
    public WebElement userBillingAdressState;
    @FindBy(id = "billing_phone")
    public WebElement userBillingAdressPhone;
    @FindBy(id = "billing_postcode")
    public WebElement userBillinZıpCode;
    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement userBillingAdressSaveAdressButton;
    @FindBy(id = "billing_email")
    public WebElement userBillingAdressEmail;
    @FindBy(xpath = "//*[text()='Address changed successfully.']")
    public WebElement billingAddressChangedSuccessfullyMesaji;
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement billingEDITYOURBILLINGADDRESSButonu;

    @FindBy(xpath = "//*[@value='marques.kemon@farmoaks.com']")
    public WebElement billingEmail;
    @FindBy(xpath = "//label[@for='billing_email']")
    public WebElement scrollEmail;

}
