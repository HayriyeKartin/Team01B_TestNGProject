package allovercommerce.tests;

import allovercommerce.pages.SignUpVendorPasswordLevelsPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpVendorPasswordLevelsTest {

    SignUpVendorPasswordLevelsPage signUpVendorLevelsPage = new SignUpVendorPasswordLevelsPage();
    @BeforeMethod
    public void setUp() {
        // Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        // Register butonuna tiklanir
        ReusableMethods.click(signUpVendorLevelsPage.registerButton);

        // Acilan pencerede Signup as a vendor? yazisina tiklanir
        ReusableMethods.click(signUpVendorLevelsPage.signUpVendor);
    }

    @Test(priority = 1)
    public void tooShortPasswordLevel() {

        // Acilan sayfada Password alanina gecerli bir veri girilir
        signUpVendorLevelsPage.passwordVendor.sendKeys(ConfigReader.getProperty("tooShortPasswordLevel"));

       // Too short mesajinin goruntulendigi dogrulanir
        String actualText = signUpVendorLevelsPage.passwordAlertText.getText();
        Assert.assertEquals(actualText,"Too short");

       // Sayfa Kapatilir
       // Driver.closeDriver();
    }

    @Test(priority = 2)
    public void weakPasswordLevel() {

        // Acilan sayfada Password alanina gecerli bir veri girilir
        signUpVendorLevelsPage.passwordVendor.sendKeys(ConfigReader.getProperty("weakPasswordLevel"));

        // Too short mesajinin goruntulendigi dogrulanir
        String actualText = signUpVendorLevelsPage.passwordAlertText.getText();
        Assert.assertEquals(actualText,"Weak");

        // Sayfa Kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 3)
    public void goodPasswordLevel() {

        // Acilan sayfada Password alanina gecerli bir veri girilir
        signUpVendorLevelsPage.passwordVendor.sendKeys(ConfigReader.getProperty("goodPasswordLevel"));

        // Too short mesajinin goruntulendigi dogrulanir
        String actualText = signUpVendorLevelsPage.passwordAlertText.getText();
        Assert.assertEquals(actualText,"Good");

        // Sayfa Kapatilir
       // Driver.closeDriver();
    }

    @Test(priority = 4)
    public void strongPasswordLevel() {

        // Acilan sayfada Password alanina gecerli bir veri girilir
        signUpVendorLevelsPage.passwordVendor.sendKeys(ConfigReader.getProperty("strongPasswordLevel"));

        // Too short mesajinin goruntulendigi dogrulanir
        String actualText = signUpVendorLevelsPage.passwordAlertText.getText();
        Assert.assertEquals(actualText,"Strong");

        // Sayfa Kapatilir(class seviyesinde test yaparken sadece son calisan testte bu aktif olmali yoksa hata veriyor!!)
        Driver.closeDriver();
    }


}
