package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "username")
    public WebElement vendorUsernameOrEmailBox;
    @FindBy(id = "password")
    public WebElement vendorPassword;
    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInVendorButton;
    @FindBy(partialLinkText = "My Account")
    public WebElement myAccount;
    @FindBy(xpath = "//a[@href='https://allovercommerce.com/store-manager/']")
    public WebElement storeManagerElement;

    @FindBy(xpath ="//a[@href='https://allovercommerce.com/my-account-2/orders/']")
    public WebElement ordersElement;
    @FindBy(xpath ="(//a[@href='https://allovercommerce.com/my-account-2/downloads/'])[1]")
    public WebElement downloadsElement;
    @FindBy(xpath ="//a[@href='https://allovercommerce.com/my-account-2/edit-address/']")
    public WebElement addressElement;
    @FindBy(xpath ="(//a[@href='https://allovercommerce.com/my-account-2/edit-account/'])[1]")
    public WebElement accountDetailsElement;
    @FindBy(xpath ="(//a[@href='https://allovercommerce.com/wishlist/'])[2]")
    public WebElement wishListElement;
    @FindBy(xpath ="//a[@href='https://allovercommerce.com/my-account-2/support-tickets/']")
    public WebElement supportTicketsElement;
    @FindBy(xpath ="//a[@href='https://allovercommerce.com/my-account-2/followings/']")
    public WebElement followingElement;
    @FindBy(xpath ="//a[.='Logout']")
    public WebElement logOutElement;
    @FindBy(xpath ="//a[.='My Store']")
    public WebElement myStoreMenuElement;
    @FindBy(xpath ="//a[.='Browse products']")
    public WebElement browseProductsElement;
    @FindBy(xpath ="//h4[.='Downloads']")
    public WebElement downloadsMenu;
    @FindBy(xpath ="//h3[.='Billing address']")
    public WebElement billingsAddressMenu;
    @FindBy(xpath ="//h3[.='Shipping address']")
    public WebElement shippingAddressMenu;
    @FindBy(xpath ="//h4[.='Account Details']")
    public WebElement accountDetailsMenu;
    @FindBy(xpath ="//h2[.='Wishlist']")
    public WebElement wishlistMenu;
    @FindBy(xpath ="//span[.='Ticket(s)']")
    public WebElement ticketsMenu;
    @FindBy(xpath ="//td[@data-title='NO Followings']")
    public WebElement followingTextMenu;

}
