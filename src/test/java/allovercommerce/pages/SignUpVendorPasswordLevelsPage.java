package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpVendorPasswordLevelsPage {

    public SignUpVendorPasswordLevelsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;

    @FindBy(partialLinkText = "Become a Vendor")
    public WebElement signUpVendor;

   @FindBy(css = "#passoword")
    public WebElement passwordVendor;

   @FindBy(id = "password_strength")
    public WebElement passwordAlertText;





}
