package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

    public VendorPage() {
        PageFactory.initElements(Driver.getDriver(), this
        );
    }

    //hayriye

    //Vendor Shipping Adress (Teslimat Adresi)  ekleyebilmeli
    //(My Account - Adressses - Shipping Address)
    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signInButton;

    @FindBy(css = "#username")
    public WebElement signInUsername;

    @FindBy(css = "#password")
    public WebElement signInPassword;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInButton2;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/'])[1]")
    public WebElement vendorMyAccount;

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement myAccountAddressesButton;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement billingAddButton;

    @FindBy(css = "#billing_first_name")
    public WebElement billingFirstName;

    @FindBy(css = "#billing_last_name")
    public WebElement billingLastName;

    @FindBy(css = "#billing_company")
    public WebElement billingCompanyName;

    @FindBy(css = "#billing_country")
    public WebElement billingCountryRegion;

    @FindBy(css = "#billing_address_1")
    public WebElement billingStreetAddress;

    @FindBy(css = "#billing_address_2")
    public WebElement billingApartment;

    @FindBy(css = "#billing_city")
    public WebElement billingTownCity;

    @FindBy(css = "#billing_state")
    public WebElement billingStateProvince;

    @FindBy(css = "#billing_postcode")
    public WebElement billingPostCode;

    @FindBy(css = "#billing_phone")
    public WebElement billingPhone;

    @FindBy(xpath = "//button[@value='Save address']")
    public WebElement billingSaveAddressButton;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement billingAlertText;

    @FindBy(xpath = "//*[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement billingLastNameAlertText;

    //Vendor olarak ürün ekleme seçeneklerini görebilmeli 2
    // (My Account - Store Manager - Product - Add New)

    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerButton;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement productsButton;

    @FindBy(css = "#add_new_product_dashboard")
    public WebElement addNewButton;

    @FindBy(xpath = "//div[.='Inventory']")
    public WebElement inventoryMenuButton;

    @FindBy(css = "#sku")
    public WebElement stockCode;

    @FindBy(css = "#manage_stock")
    public WebElement manageStock;

    @FindBy(css = "#stock_qty")
    public WebElement stockQty;

    @FindBy(css = "#backorders")
    public WebElement allowBackorders;

    @FindBy(css = "#stock_status")
    public WebElement stockStatus;

    @FindBy(css = "#sold_individually")
    public WebElement soldIndividually;

    @FindBy(xpath = "//div[.='Shipping']")
    public WebElement shippingMenuButton;

    @FindBy(css = "#weight")
    public WebElement shippingWeight;

    @FindBy(css = "#length")
    public WebElement dimensionsLength;

    @FindBy(css = "#width")
    public WebElement dimensionsWidth;

    @FindBy(css = "#height")
    public WebElement dimensionsHeight;

    @FindBy(css = "#shipping_class")
    public WebElement shippingClass;

    @FindBy(css = "#_wcfmmp_processing_time")
    public WebElement processingTime;

    @FindBy(xpath = "//div[.='Attributes']")
    public WebElement attributesMenuButton;

    @FindBy(css = "#attributes_is_active_1")
    public WebElement colorCheckbox;

    @FindBy(css = "#attributes_value_1")
    public WebElement colorAttributeSelect;

    @FindBy(css = "#attributes_is_active_2")
    public WebElement sizeCheckbox;

    @FindBy(css = "#attributes_value_2")
    public WebElement sizeAttributeSelect;

    @FindBy(xpath = "//div[.='Linked']")
    public WebElement linkedMenuButton;

    @FindBy(xpath = "//*[contains( text(),'SEO' )]")
    public WebElement seoMenuButton;

    @FindBy(xpath = "//div[.='Advanced']")
    public WebElement advancedMenuButton;

    //Vendor olarak Simple Product ekleyebilmeliyim
    @FindBy(xpath = "//option[.='Simple Product']")
    public WebElement simpleProductFirstSelect;

    @FindBy(css = "#is_virtual")
    public WebElement virtualCheckbox;

    @FindBy(css = "#is_downloadable")
    public WebElement downloadableCheckbox;

    @FindBy(css = "#regular_price")
    public WebElement priceBox;

    @FindBy(css = "#sale_price")
    public WebElement salePriceBox;

    @FindBy(css = "#pro_title")
    public WebElement productTitle;

    @FindBy(xpath = "//input[@data-super_parent='402']")
    public WebElement categoriesSelect;


    //gulsum
    //Vendor Registration

    @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;
    @FindBy(partialLinkText = "Become a Vendor")
    public WebElement becomeVendor;

    @FindBy(xpath="(//h2)[1]")
    public WebElement vendorRegisterPage;

    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement vendorEmail;

    @FindBy(xpath = "//*[@value='Re-send Code']")
    public WebElement reSendCodeButton;

    @FindBy(css = ".wcfm-message.email_verification_message.wcfm-success")
    public WebElement verificationMessage;
    @FindBy(xpath = "//*[@placeholder='Verification Code']")
    public WebElement vendorVerificationCodeBox;
    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement password;
    @FindBy(xpath = "//input[@value='Register']")
    public WebElement vendorRegisterButton; //kayıt sayfasındaki son buton

    @FindBy(xpath = "//div[.='Registration Successfully Completed.']")
    public WebElement registerSuccesText;

    @FindBy(css = "#password_strength")
    public WebElement passwordStrength;
    @FindBy(css = ".wcfm-message.wcfm-error")
    public WebElement passwordAlertMessage;
    @FindBy(xpath = "//*[@class='button button-large']")
    public WebElement vendorNotRightNow;
    @FindBy(xpath = "//h1[.='Welcome to Allover Commerce!']")
    public WebElement dashboard;



    //vendor icin sign in locateleri
    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement signInBox;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userName;

    //Vendor Shipping

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "(//span[@class='cart-count'])[1]")
    public WebElement multipleProduct;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/cart/'])[1]")
    public WebElement cartIcon;

    @FindBy(xpath = "//h4[.='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "(//a[.='Checkout'])[1]")
    public WebElement checkOut;

    @FindBy(xpath = "//input[@value='lamberto']")
    public WebElement billingUsername;

    @FindBy(css = "#billing_email_field > label")
    public WebElement billingEmail;

    @FindBy(xpath = "//td[@class='product-name']")
    public WebElement yourOrderProduct; //your orderda gorulebilen bir veya birden fazla urun

    @FindBy(css = "tr.order-total span > bdi")
    public WebElement total;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrder;

    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement orderCompletedText;

    @FindBy(css = "#payment_method_bacs")
    public WebElement wireTransfer;

    @FindBy(xpath = "(//*[@class='input-radio'])[2]")
    public WebElement payAtTheDoor;

    @FindBy(partialLinkText = "My Account")
    public WebElement myAccount;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement orders;

    @FindBy(xpath = "(//*[@class='woocommerce-button btn btn-default btn-rounded btn-outline btn-sm btn-block view'])[1]")
    public WebElement ilkOrderView;

    @FindBy(xpath = "//*[@class='woocommerce-order-details__title']")
    public WebElement orderDetails;

    @FindBy(css = ".woocommerce-checkout-payment")
    public WebElement paymentMethods;

    //US20 Enter your code

    @FindBy(xpath = "(//*[@class='form-control'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement viewCart;

    @FindBy(css = ".showcoupon")
    public WebElement enterCouponCode;

    @FindBy(css = "#coupon_code")
    public WebElement couponCodeBox;

    @FindBy(css = ".btn.button.btn-rounded.btn-default")
    public WebElement applyCouponCode;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successCoupon;



}
