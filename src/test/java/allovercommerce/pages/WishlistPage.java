package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

    public WishlistPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='Comfortable Backpack']")
    public WebElement comfortableBackpack;

    @FindBy(xpath = "//a[@href='?add_to_wishlist=13257']")
    public WebElement comfortableBackpackWishlistButton;

    @FindBy(xpath = "//*[@data-id='40078c4']")
    public WebElement anaSayfaWishlistButton;

    @FindBy(xpath ="//*[.='Comfortable Backpack']")
    public WebElement comfortableBackpackInWishlist;

    @FindBy(xpath = "//*[@title='Quick View']")
    public WebElement quickView;

    @FindBy(xpath = "//*[@class='woocommerce-product-details__short-description']")
    public WebElement quickViewFeatures;

    @FindBy(xpath = "//*[@data-product_id='13257']")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@data-id='fbb1175']")
    public WebElement anaSayfaCartButton;

    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement ViewCartButton;

    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = "#billing_first_name")
    public WebElement checkoutFirstName;

    @FindBy(css = "#billing_last_name")
    public WebElement checkoutLasttName;

    @FindBy(xpath = "//*[@title='United States (US)']")
    public WebElement checkoutCountryRegion;

    @FindBy(css = "#billing_address_1")
    public WebElement checkoutStreetAddress;

    @FindBy(css = "#billing_city")
    public WebElement checkoutTownCity;

    @FindBy(xpath = "//*[@title='New York']")
    public WebElement checkoutState;

    @FindBy(css = "#billing_postcode")
    public WebElement checkoutZipCode;

    @FindBy(css = "#billing_phone")
    public WebElement checkoutPhone;

    @FindBy(css = "#billing_email")
    public WebElement checkoutEmailAddress;

    @FindBy(css = "#place_order")
    public WebElement checkoutPlaceHolderButton;

    @FindBy(xpath = "//*[text()='Order Complete']")
    public WebElement orderCompleteText;

    @FindBy(xpath = "//a[@class='remove remove_from_wishlist fas fa-times']")
    public WebElement removeWishlist;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    public WebElement closeQuickView;



}
