package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KuponOlusturmaPage {
    public KuponOlusturmaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(text(),'Coupons')]")
    public WebElement couponsElement;
    @FindBy(xpath = "//*[@id=\"menu-item-1079\"]/a")
    public WebElement myAccount;
    @FindBy(xpath = "//*[@id=\"add_new_coupon_dashboard\"]/span[2]")
    public WebElement addNewKupon;
    @FindBy(xpath = "//*[@id=\"title\"]")
    public WebElement codeBox;
    @FindBy(xpath = "//*[@id=\"discount_type\"]")
    public WebElement discountTypeDropDown;
    @FindBy(xpath = "//*[@id=\"coupon_amount\"]")
    public WebElement couponAmount;
    @FindBy(xpath = "//*[@id=\"coupon_amount\"]")
    public WebElement couponDate;
    @FindBy(xpath = "//*[@id=\"free_shipping\"]")
    public WebElement allowFreeShipping;
    @FindBy(xpath = "//*[@id=\"show_on_store\"]")
    public WebElement showOnStore;
    @FindBy(xpath = "//*[@id=\"wcfm_coupon_manager_submit_button\"]")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"wcfm_coupon_manager_submit\"]/div")
    public WebElement kuponSavedText;
    @FindBy(xpath = "//*[@id=\"wcfm-content\"]/div[2]/div[2]/div[2]/span")
    public WebElement kuponTypeSonucText;
}
