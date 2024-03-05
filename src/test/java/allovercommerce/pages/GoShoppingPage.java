package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoShoppingPage {

    public GoShoppingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@aria-label='Search']")
    public WebElement searchBox;

   @FindBy(xpath = "//button[@value='13221']")
    public WebElement usbReceiptAddToCart;

   @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-btn alert-success']")
    public WebElement hasBeenAddedToCartMessage;

   @FindBy(xpath = "//div[@data-id='fbb1175']")
    public WebElement anasayfaCartButton;

    @FindBy(xpath = "//a[.='View cart']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//td[@class='product-name']")
    public WebElement urunIsmiyleDogrulama;

    @FindBy(xpath = "//button[@class='quantity-minus w-icon-minus']")
    public WebElement minusButton;

    @FindBy(xpath = "//button[@title='Plus']")
    public WebElement plusButton;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement urunMiktari;

    @FindBy(xpath = "//button[@name='update_cart']")
    public WebElement updateCartButton;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//h3[.='Billing details']")
    public WebElement billingDetailsText;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement userNameOrEmailAddressBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement loginSignInButton;

    @FindBy(xpath = "//label[@for='payment_method_bacs']")
    public WebElement wireTransferEftPaymentMethod;

    @FindBy(xpath = "//label[@for='payment_method_cod']")
    public WebElement payAtTheDoorPaymentMethod;

    @FindBy(css = "#payment_method_bacs")
    public WebElement chooseWireTransferEftPaymentMethod;

    @FindBy(css = "#payment_method_cod")
    public WebElement choosePayAtTheDoorPaymentMethod;

    @FindBy(xpath = "//a[text()='Order Complete']")
    public WebElement orderCompleteText;

 @FindBy(css = "#place_order")
 public WebElement placeOrderButton;

 @FindBy(xpath = "//a[@class='remove fas fa-times']")
 public WebElement productRemoveButton;

 @FindBy(xpath = "//span[text()='Sign Out']")
 public WebElement signOutButton;

 @FindBy(xpath = "//span[@class='icon-box-icon icon-logout']")
 public WebElement logOutButton;



}
