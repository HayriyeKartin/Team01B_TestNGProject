package allovercommerce.tests;

import allovercommerce.pages.RegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest {

    @Test
    public void registerPozitifTest() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        RegisterPage registerPage=new RegisterPage();
        registerPage.registerButton.click();
        // Username kutusuna gecerli bir veri girilir
        Faker faker =new Faker();
        registerPage.registerUsername.sendKeys(faker.name().username());
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        ReusableMethods.bekle(1);
        // Kayıt işleminin tamamlandıgını dogrulanır.
        Assert.assertTrue(registerPage.registerSignOutText.isDisplayed());
        ReusableMethods.bekle(3);
        Driver.closeDriver();


    }

    @Test
    public void registerUsernameKutusuBos() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        RegisterPage registerPage=new RegisterPage();
        registerPage.registerButton.click();
        // Username kutusu boş bırakilir
        Faker faker =new Faker();
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        //Kayıt işleminin tamamlanmadığını doğrulanır

    }
}
