package allovercommerce.tests;

import allovercommerce.pages.FakeMailPage;
import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VendorTest {

    VendorPage vendorPage = new VendorPage();
    FakeMailPage fakeMailPage = new FakeMailPage();



    @Test(priority = 1)
    public void pozitiveTest() {
        //Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));


        //Register butonuna tıklanır
        vendorPage.registerButton.click();

        //"Become a Vendor"" linkine tıklanır
        vendorPage.becomeVendor.click();

        //"Vendor Registeration"  sayfasının açıldığını doğrula.
        ReusableMethods.bekle(5);
        Assert.assertTrue(vendorPage.vendorRegisterPage.isDisplayed());

        //Sayfa kapatılır
        Driver.closeDriver();
    }


    @Test(priority = 2)
    public void vendorRegistration() {
        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Register butonuna tıklanır
        vendorPage.registerButton.click();

        //Become a Vendor butonuna tıklanır
        vendorPage.becomeVendor.click();

        //"Vendor Registeration"  sayfasının açıldığını doğrula.
        Assert.assertTrue(vendorPage.vendorRegisterPage.isDisplayed());

        //Emaile fake Mail adresinden bir mail adresi ile girilir
        String allOverCommerceHandle = Driver.getDriver().getWindowHandle(); //allovercommerce sayfasının handle değerini aldık
        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("fakeMailUrl"));
        String fakeMailHAndle = Driver.getDriver().getWindowHandle();//fakeMail sayfasının handle degerini aldık
        String emailAddress = fakeMailPage.fakeMailEmailBox.getText();
        Driver.getDriver().switchTo().window(allOverCommerceHandle);
        ReusableMethods.bekle(3);
        vendorPage.vendorEmail.sendKeys(emailAddress, Keys.TAB);

        //RE-SEND CODE butonuna tıklanır
        vendorPage.reSendCodeButton.click();

        // "Verification code sent to your email: abc@abc.com." mesajının görüldüğü doğrulanır
        Assert.assertTrue(vendorPage.verificationMessage.isDisplayed());

        //Mail adresine gelen 'Verification Code' u ilgili kutucuğa girilir
        Driver.getDriver().switchTo().window(fakeMailHAndle).navigate().refresh();
        fakeMailPage.endMailBox.click();
        Driver.getDriver().switchTo().window(fakeMailHAndle).navigate().back();
        ReusableMethods.bekle(6);
        fakeMailPage.endMailBox.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.bekle(3);
        String verificationCode = fakeMailPage.verificationCode.getText();
        Driver.getDriver().switchTo().window(allOverCommerceHandle);
        vendorPage.vendorVerificationCodeBox.sendKeys(verificationCode);

        //Password ve Confirm Password kutucuklarını doldurulur
        vendorPage.password.sendKeys(ConfigReader.getProperty("fakePassword"),
                Keys.TAB, ConfigReader.getProperty("fakePassword"));

        //Register butonuna tıklanır
        vendorPage.vendorRegisterButton.sendKeys(Keys.ENTER);

        //"Registration Successfully Completed." mesajı görüntülenir
        String expectedResult = "Registration Successfully Completed.";
        String actualResult = vendorPage.registerSuccesText.getText();

        //Vendor kaydının gerçekleştiği doğrulanır
        Assert.assertEquals(expectedResult, actualResult);

        //Açılan sayfada 'NOT RIGHT NOW' butonuna tıklanır
        vendorPage.vendorNotRightNow.click();

        //"Welcome to Allower Commerce!" mesajı görüntülenir
        Assert.assertTrue(vendorPage.dashboard.isDisplayed());

        //Sayfa kapatılır
        Driver.closeDriver();

    }

    @Test(priority = 3)
    public void requiredFieldIsLeftEmpty() {

        //Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Register butonuna tıklanır
        vendorPage.registerButton.click();
        //Become a Vendor yazısına tıklanır
        vendorPage.becomeVendor.click();

        //Email kutucuğu bos bırakıldı
        //RE-SEND CODE butonuna tıklanır
        vendorPage.reSendCodeButton.click();

        //"Verification Code" kutucuğu bos bırakıldı

        //Password ve Confirm Password kutucuklarını doldurulur
        //Register butonuna tıklanır
        String fakePassword = ConfigReader.getProperty("fakePassword");
        vendorPage.password.sendKeys(fakePassword, Keys.TAB, fakePassword, Keys.TAB, Keys.ENTER);
        ReusableMethods.click(vendorPage.vendorRegisterButton);

        //Kayit islemi gerceklestirilemedigi dogrulanır
        Assert.assertTrue(vendorPage.vendorRegisterButton.isDisplayed());
        ReusableMethods.bekle(3);

        //Sayfa kapatılır
        Driver.closeDriver();
    }

    @Test(priority = 4)
    public void passwordCharacters() {

        //Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("vendorUrl"));

        //Açılan Vendor Registration sayfasında Email kutucuğu doldurulur
        //RE-SEND CODE butonuna tıklanır
        String allOverCommerceHandle = Driver.getDriver().getWindowHandle(); //allovercommerce sayfasının handle değerini aldık
        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("fakeMailUrl"));
        String fakeMailHAndle = Driver.getDriver().getWindowHandle();//fakeMail sayfasının handle degerini aldık
        String emailAddress = fakeMailPage.fakeMailEmailBox.getText();

        Driver.getDriver().switchTo().window(allOverCommerceHandle); //driver imizi allover sayfasına gecirdik
        ReusableMethods.bekle(3);
        vendorPage.vendorEmail.sendKeys(emailAddress, Keys.TAB);
        vendorPage.reSendCodeButton.click();

        //Fake Mail adresine gelen 'Verification Code' ilgili kutucuğa girilir
        Driver.getDriver().switchTo().window(fakeMailHAndle).navigate().refresh();
        fakeMailPage.endMailBox.click();
        Driver.getDriver().switchTo().window(fakeMailHAndle).navigate().back();
        ReusableMethods.bekle(6);
        fakeMailPage.endMailBox.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.bekle(3);
        String verificationCode = fakeMailPage.verificationCode.getText();
        Driver.getDriver().switchTo().window(allOverCommerceHandle);
        vendorPage.vendorVerificationCodeBox.sendKeys(verificationCode);

        //Password ve Confirm Password kutucuklarına valid datalar girilir
        vendorPage.password.sendKeys(ConfigReader.getProperty("fakePassword"),
                Keys.TAB, ConfigReader.getProperty("fakePassword"), Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(3);

        //Password girildiğinde "Strong" mesajı görüntülenir
        Assert.assertTrue(vendorPage.passwordStrength.isDisplayed());

        //Register butonuna tıklanır
        ReusableMethods.click(vendorPage.vendorRegisterButton);

        //Açılan sayfada 'NOT RIGHT NOW' butonuna tıklanır
        vendorPage.vendorNotRightNow.click();

        //Kayıt olunduğu doğrulanır
        Assert.assertTrue(vendorPage.dashboard.isDisplayed());

    }

    @Test(priority = 5)
    public void negativeTest() {

        //Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("vendorUrl"));

        //Register butonuna tıklanır
        //vendorPage.registerButton.click();

        //Become a Vendor yazısına tıklanır
        //vendorPage.becomeVendor.click();

        //Açılan Vendor Registration sayfasında Email kutucuğu doldurulur

        String allOverCommerceHandle = Driver.getDriver().getWindowHandle(); //allovercommerce sayfasının handle değerini aldık
        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("fakeMailUrl"));
        String fakeMailHAndle = Driver.getDriver().getWindowHandle();//fakeMail sayfasının handle degerini aldık
        String emailAddress = fakeMailPage.fakeMailEmailBox.getText();

        Driver.getDriver().switchTo().window(allOverCommerceHandle); //driver imizi allover sayfasına gecirdik
        ReusableMethods.bekle(3);
        vendorPage.vendorEmail.sendKeys(emailAddress, Keys.TAB);
        ReusableMethods.scroll(vendorPage.vendorEmail);

        ReusableMethods.bekle(5);

        //RE-SEND CODE butonuna tıklanır
        vendorPage.reSendCodeButton.click();

        //Fake Mail adresine gelen 'Verification Code' ilgili kutucuğa girilir
        Driver.getDriver().switchTo().window(fakeMailHAndle).navigate().refresh();
        fakeMailPage.endMailBox.click();
        Driver.getDriver().switchTo().window(fakeMailHAndle).navigate().back();

        ReusableMethods.bekle(6);

        fakeMailPage.endMailBox.click();
        Driver.getDriver().switchTo().frame(1);

        ReusableMethods.bekle(3);

        String verificationCode = fakeMailPage.verificationCode.getText();
        Driver.getDriver().switchTo().window(allOverCommerceHandle);
        vendorPage.vendorVerificationCodeBox.sendKeys(verificationCode);

        //Password ve Confirm Password kutucuklarına geçersiz datalar girilir;
        vendorPage.password.sendKeys("aa123", Keys.TAB, "aa123");

        //Password girildiğinde "Weak" mesajı görüntülenir
        Assert.assertTrue(vendorPage.passwordStrength.isDisplayed());

        //Register butonuna tıklanır
        ReusableMethods.click(vendorPage.vendorRegisterButton);
        ReusableMethods.bekle(3);

        //Vendor kaydının gerçekleşmediği doğrulanır
        Assert.assertTrue(vendorPage.passwordAlertMessage.isDisplayed());
        ReusableMethods.bekle(3);

        //Sayfayı kapat
        Driver.quitDriver();
    }

    @Test(priority = 6)
    public void vendorRegistrationWithRegistered() {

        //Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Register butonuna tıklanır
        vendorPage.registerButton.click();

        //Become a Vendor yazısına tıklanır
        vendorPage.becomeVendor.click();

        //Açılan Vendor Registration sayfasında Email kutusuna kayıtlı bir e-mail gir
        //RE-SEND CODE kutusuna tıklanır
        vendorPage.vendorEmail.sendKeys("lamberto.midas@falkcia.com", Keys.TAB);
        ReusableMethods.scroll(vendorPage.vendorEmail);
        ReusableMethods.bekle(5);

        //"Verification code sent to your email: {e-mail} mesajı görüntülenir
        Assert.assertTrue(vendorPage.verificationMessage.isDisplayed());

        //"Verification Code" kutucuğuna tıklanır
        vendorPage.vendorVerificationCodeBox.click();

        //Fake Mail adresine gelen kod "Verification Code" kutucuğuna yazılır
        vendorPage.vendorVerificationCodeBox.sendKeys(" ");
        ReusableMethods.bekle(3);

        //Password ve Confirm Password kutucuklarını doldurulur
        vendorPage.password.sendKeys(ConfigReader.getProperty("fakePassword"),
                Keys.TAB, ConfigReader.getProperty("fakePassword"), Keys.ENTER);

        //Register butonuna tıklanır
        ReusableMethods.click(vendorPage.vendorRegisterButton);

        // "This Email already exists. Please login to the site and apply as vandor." uyarısı alındığı doğrulanır
        Assert.assertTrue(vendorPage.passwordAlertMessage.isDisplayed());

        //Sayfayı kapat
        Driver.quitDriver();

    }

}
