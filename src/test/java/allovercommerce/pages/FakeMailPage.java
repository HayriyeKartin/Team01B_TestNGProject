package allovercommerce.pages;

import allovercommerce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FakeMailPage {

    public FakeMailPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//span[@id='email']")
    public WebElement fakeMailEmailBox;
    @FindBy(css = "#schranka > tr:nth-child(1)")
    public WebElement endMailBox; //en son gonderilen mail kutusu
    @FindBy(tagName = "b")
    public WebElement verificationCode;
}
