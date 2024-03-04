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

}
