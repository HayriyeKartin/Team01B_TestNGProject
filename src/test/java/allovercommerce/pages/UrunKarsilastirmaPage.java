package allovercommerce.pages;


import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UrunKarsilastirmaPage {
    public UrunKarsilastirmaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "username")
    public WebElement usernameOrEmailBox;
    @FindBy(id = "password")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[.='Sign In']")
    public WebElement signInButton;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;
    @FindBy(xpath = "//div[@data-product-id=43456]")
    public WebElement kazak1;
    @FindBy(xpath = "//div[@data-product-id=14619]")
    public WebElement kazak2;
    @FindBy(xpath = "//div[@data-product-id=14262]")
    public WebElement kazak3;
    @FindBy(xpath = "//div[@data-product-id=14258]")
    public WebElement kazak4;
    @FindBy(xpath = "//div[@data-product-id=16371]")
    public WebElement kazak5;
    @FindBy(xpath = "//div[@data-product-id=14619]")
    public WebElement scrollDownElement;
    @FindBy(xpath = "//div[@data-product-id=16371]")
    public WebElement scrollUppElement;
    @FindBy(xpath = "(//a[@title='Compare'])[1]")
    public WebElement kazak1KarsilastirmaButton;
    @FindBy(xpath = "(//a[@title='Compare'])[4]")
    public WebElement kazak2KarsilastirmaButton;
    @FindBy(xpath = "(//a[@title='Compare'])[5]")
    public WebElement kazak3KarsilastirmaButton;
    @FindBy(xpath = "(//a[@title='Compare'])[6]")
    public WebElement kazak4KarsilastirmaButton;
    @FindBy(xpath = "(//a[@title='Compare'])[2]")
    public WebElement kazak5KarsilastirmaButton;
    @FindBy(xpath = "//div[@class='compare-popup-overlay']")
    public WebElement bosClick;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/kazak/'])[4]")
    public WebElement siyahKazak;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/kazak-2/'])[1]")
    public WebElement maviliKazak;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/erkek-triko-kazak-2/'])[3]")
    public WebElement koyuGriKazak;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/erkek-triko-kazak-3/'])[3]")
    public WebElement kahverengiKazak;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/kahverengi-kadin-kazak/'])[3]")
    public WebElement kadinKazak;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/compare-2/'])[5]")
    public WebElement startCompareButton;
    @FindBy(xpath = "(//p)[9]")
    public WebElement urunAdedi;
    @FindBy(xpath = "(//i[@class='w-icon-times-solid'])[1]")
    public WebElement urunSil1;
    @FindBy(xpath = "//h2[.='No products added to the compare']")
    public WebElement urunlerSilindiText;
}
