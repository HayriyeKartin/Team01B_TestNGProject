package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MusteriAlisverisPage {
    public MusteriAlisverisPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@data-product-id='48566']")
    public WebElement iphone15ProMax;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/figure/div[2]/a[1]")
    public WebElement iphone15AddToCardIcon;
    @FindBy(xpath = "//a[.='View Cart']")
    public WebElement viewCardButton;
    @FindBy(id = "coupon_code")
    public WebElement kuponBox;
    @FindBy(xpath = "//button[.='Apply coupon']")
    public WebElement applyCouponButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement kuponUygulandiText;
    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckoutButton;

    //Kupon sadece seçili ürünlerde uygulanır
    @FindBy(xpath = "//div[@data-product-id=43456]")
    public WebElement kazak1;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/figure/div[2]/a[1]")
    public WebElement kazakAdToCartIcon;
    @FindBy(xpath = "//ul[@role='alert']")
    public WebElement kuponUygulanmadiText;

    //BILLING DETAILS
    @FindBy(id = "billing_first_name")
    public WebElement billingFirstNameBox;
    @FindBy(id = "billing_last_name")
    public WebElement billingLastNameBox;
    @FindBy(css = "#select2-billing_country-container")
    public WebElement billingCountryDdm;
    @FindBy(xpath = "//li[.='United States (US)']")
    public WebElement billingCountryUSA;
    @FindBy(id = "billing_address_1")
    public WebElement billingStreetBox;
    @FindBy(id = "billing_postcode")
    public WebElement billingZipCodeBox;
    @FindBy(id = "billing_city")
    public WebElement billingTownBox;
    @FindBy(css = "#select2-billing_state-container")
    public WebElement billingProvinceDdm;
    @FindBy(xpath = "//li[.='New York']")
    public WebElement stateNewYork;
    @FindBy(id = "billing_phone")
    public WebElement billingPhoneBox;
    @FindBy(id = "billing_email")
    public WebElement billinEmailBox;
    @FindBy(id = "place_order")
    public WebElement placeOrderButton;
    @FindBy(id = "payment_method_cod")
    public WebElement payAdTheDoor;
    @FindBy(xpath = "//*[contains(text(),'Thank you. Your order has been received.')]")
    public WebElement alisverisTamamText;
}
