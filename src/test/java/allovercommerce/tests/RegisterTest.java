package allovercommerce.tests;

import allovercommerce.pages.RegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest {
    RegisterPage registerPage=new RegisterPage();
    Faker faker =new Faker();




    @Test
    public void registerPozitifTest() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna gecerli bir veri girilir
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
        registerPage.registerButton.click();
        // Username kutusu boş bırakilir
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        //Username boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Kayıt işleminin tamamlanmadığını doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerUsername),"Lütfen bu alanı doldurun.");
        Driver.closeDriver();
    }

    @Test
    public void registerEmailAlaniBos() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna gecerli bir veri girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        // Eposta adresi kutusu boş bırakılır

        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        //Email boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Kayıt işleminin tamamlanmadığını doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerEmail),"Lütfen bu alanı doldurun.");
        Driver.closeDriver();
    }

    @Test
    public void registerPasswordAlaniBos() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusu boş bırakilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        // Sifre kutusu boş bırakılır

        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        //Password alani boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Kayıt işleminin tamamlanmadığını doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerPassword),"Lütfen bu alanı doldurun.");
        Driver.closeDriver();
    }
    @Test
    public void registerPolicyKutusuTiklanmaz() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna gecerli bir veri girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretmez

        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        ReusableMethods.bekle(1);
        // "I agree to the privacy policy" kutusu işaretlenmediği için
        //"İlerlemek istiyorsanız lütfen bu kutuyu işaretleyin." uyari mesajı görülür
        String uyariMesaji ="İlerlemek istiyorsanız lütfen bu kutuyu işaretleyin.";
        // Kayıt işleminin tamamlanmadıgı dogrulanır.
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerRadioButton),uyariMesaji);
        Driver.closeDriver();
    }

    //**************************    User Stor 02    ************************************************************

    @Test
    public void KayitliBilgilerleKayitTest() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna daha önce kayıtlı olan bir username girilir
        registerPage.registerUsername.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Eposta adresi kutusuna daha önce kayıtlı olan bir eposta adresi girilir
        registerPage.registerEmail.sendKeys(ConfigReader.getProperty("kayitliEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        //Kayıt işleminin gerçekleşmediği doğrulanır
        ReusableMethods.bekle(1);
        String expectedResultText = "An account is already registered with your email address. ";
        Assert.assertTrue(registerPage.registeredText.getText().contains(expectedResultText));
        Driver.closeDriver();
    }
    @Test
    public void KayitliBilgilerleKayitTest2() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna daha önce kayıtlı olmayan bir username girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        // Eposta adresi kutusuna daha önce kayıtlı olmayan bir eposta adresi girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        // Sifre kutusuna daha önce kayitli bir şifre girilir
        registerPage.registerPassword.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        ReusableMethods.bekle(1);
        //Kayıt işleminin gerçekleştiği doğrulanır
        Assert.assertTrue(registerPage.registerSignOutText.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
    @Test
    public void KayitliBilgilerleKayitTest3() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna daha önce kayıtlı olmayan bir username girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        // Eposta adresi kutusuna daha önce kayıtlı olan bir eposta adresi girilir
        registerPage.registerEmail.sendKeys(ConfigReader.getProperty("kayitliEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        ReusableMethods.bekle(1);
        //Kayıt işleminin gerçekleşmediği doğrulanır
        ReusableMethods.bekle(1);
        String expectedResultText = "An account is already registered with your email address. ";
        Assert.assertTrue(registerPage.registeredText.getText().contains(expectedResultText));
        Driver.closeDriver();
    }
    @Test
    public void KayitliBilgilerleKayitTest4() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna daha önce kayıtlı olmayan bir username girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        // Eposta adresi kutusuna geçersiz bir veri girilir
        registerPage.registerEmail.sendKeys(ConfigReader.getProperty("invalidData"));
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        ReusableMethods.bekle(1);
        //Email kutusuna geçersiz bir veri girildiği için
        //"Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"abc\" adresinde \"@\" eksik."
        //uyari mesaji görülür
        String uyariMesaji ="Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"abc\" adresinde \"@\" eksik.";
        //Kayıt işleminin gerçekleşmediği doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerEmail),uyariMesaji);
        Driver.closeDriver();
    }
    @Test
    public void KayitliBilgilerleKayitTest5() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        // Username kutusuna daha önce kayıtlı olan bir username girilir
        registerPage.registerUsername.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Eposta adresi kutusuna daha önce kayıtlı olmayan bir email girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        // Sifre kutusuna daha önce kayıtlı olmayan bir sifre girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        //Kayıt işleminin gerçekleşmediği doğrulanır
        ReusableMethods.bekle(1);
        String expectedResultText = "An account is already registered with that username. Please choose another.";
        Assert.assertTrue(registerPage.registeredText.getText().contains(expectedResultText));
        Driver.closeDriver();
    }

}
