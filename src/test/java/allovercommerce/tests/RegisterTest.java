package allovercommerce.tests;

import allovercommerce.pages.RegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static allovercommerce.utilities.ReusableMethods.extentReports;
import static allovercommerce.utilities.ReusableMethods.extentTest;

public class RegisterTest {
    RegisterPage registerPage=new RegisterPage();
    Faker faker =new Faker();


    @Test(priority = 1)
    public void registerPozitifTest() {
        ReusableMethods.createExtentReport("US01-TC01 Register olarak giriş yapılabilmeli ");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanici allovercommerce sayfasina gider");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Kullanici Register butonuna tıklar");
        // Username kutusuna gecerli bir veri girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        extentTest.info("Kullanici geçerli bir username girer");
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        extentTest.info("Kullanici geçerli bir email girer");
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        extentTest.info("Kullanici geçerli bir password girer");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("Kullanici 'I agree to the privacy policy' kutusunu isaretler");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Kullanici Sign Up butonuna tıklar");
        ReusableMethods.bekle(1);
        // Kayıt işleminin tamamlandıgını dogrulanır.
        Assert.assertTrue(registerPage.registerSignOutText.isDisplayed());
        extentTest.pass("Kullanici kayit isleminin gerceklestigini dogrular");
        extentReports.flush();
        ReusableMethods.bekle(3);
        Driver.closeDriver();



    }

    @Test(priority = 2)
    public void registerUsernameKutusuBos() {
        ReusableMethods.
                createExtentReport("US01-TC02 Username alani bos birakildiginda kayit islemi gerceklesmemelidir. ( Negatif test)");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanici allovercommerce sayfasina gider");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Kullanici Register butonuna tıklar");
        // Username kutusu boş bırakilir
        extentTest.info("Kullanici Username kutusunu boş bırakir");
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        extentTest.info("Kullanici geçerli bir email girer");
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        extentTest.info("Kullanici geçerli bir password girer");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("Kullanici 'I agree to the privacy policy' kutusunu isaretler");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Kullanici Sign Up butonuna tıklar");
        //Username boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Kayıt işleminin tamamlanmadığını doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerUsername),"Lütfen bu alanı doldurun.");
        extentTest.pass("Username boş bırakıldığ için \"Lütfen bu alanı doldurun.\" mesajı görülür\n" +
                "Kayıt işleminin tamamlanmadığını doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }

    @Test(priority = 3)
    public void registerEmailAlaniBos() {
        ReusableMethods.
                createExtentReport("US01-TC03 E-Mail alani bos birakildiginda kayit islemi gerceklesmemelidir. ( Negatif test)");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanici allovercommerce sayfasina gider");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Kullanici Register butonuna tıklar");
        // Username kutusuna gecerli bir veri girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        extentTest.info("Kullanici Username kutusuna gecerli veri girer");
        // Eposta adresi kutusu boş bırakılır
        extentTest.info("Kullanici Email kutusunu boş bırakir");
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        extentTest.info("Kullanici Password kutusuna gecerli veri girer");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("Kullanici 'I agree to the privacy policy' kutusunu isaretler");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Kullanici Sign Up butonuna tıklar");
        //Email boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Kayıt işleminin tamamlanmadığını doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerEmail),"Lütfen bu alanı doldurun.");
        extentTest.pass("Email boş bırakıldığ için \"Lütfen bu alanı doldurun.\" mesajı görülür\n" +
                "Kayıt işleminin tamamlanmadığını doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }

    @Test(priority = 4)
    public void registerPasswordAlaniBos() {
        ReusableMethods.
                createExtentReport("US01-TC04 Password alani bos birakildiginda kayit islemi gerceklesmemelidir. ( Negatif test)");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanici allovercommerce sayfasina gider");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Kullanici Register butonuna tıklar");
        // Username kutusuna gecerli bir veri girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        extentTest.info("Kullanici Username kutusuna gecerli veri girer");
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        extentTest.info("Kullanici geçerli bir email girer");
        // Sifre kutusu boş bırakılır
        extentTest.info("Kullanici password kutusunu boş bırakır");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("Kullanici 'I agree to the privacy policy' kutusunu isaretler");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Kullanici Sign Up butonuna tıklar");
        //Password alani boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Kayıt işleminin tamamlanmadığını doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerPassword),"Lütfen bu alanı doldurun.");
        extentTest.pass("Password alani boş bırakıldığ için \"Lütfen bu alanı doldurun.\" mesajı görülür\n" +
                "Kayıt işleminin tamamlanmadığını doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }
    @Test(priority = 5)
    public void registerPolicyKutusuTiklanmaz() {
        ReusableMethods.
                createExtentReport("US01-TC05 \"I agree to the privacy policy\" alani bos birakildiginda kayit islemi gerceklesmemelidir( Negatif test)");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanici allovercommerce sayfasina gider");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Kullanici Register butonuna tıklar");
        // Username kutusuna gecerli bir veri girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        extentTest.info("Kullanici Username kutusuna gecerli veri girer");
        // Eposta adresi kutusuna gecerli bir veri girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        extentTest.info("Kullanici geçerli bir email girer");
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        // "I agree to the privacy policy" kutusu işaretmez
        extentTest.info("Kullanici \"I agree to the privacy policy\" kutusu işaretmez");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Kullanici Sign Up butonuna tıklar");
        ReusableMethods.bekle(1);
        // "I agree to the privacy policy" kutusu işaretlenmediği için
        //"İlerlemek istiyorsanız lütfen bu kutuyu işaretleyin." uyari mesajı görülür
        String uyariMesaji ="İlerlemek istiyorsanız lütfen bu kutuyu işaretleyin.";
        // Kayıt işleminin tamamlanmadıgı dogrulanır.
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerRadioButton),uyariMesaji);
        extentTest.pass("'I agree to the privacy policy' kutusu işaretlenmediği için "+uyariMesaji+" mesajı görülür\n" +
                "Kayıt işleminin tamamlanmadığını doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }

    //**************************    User Stor 02    ************************************************************

    @Test(priority = 6)
    public void KayitliBilgilerleKayitTest() {
        ReusableMethods.createExtentReport("US02-TC01 Kullanıcının kayıtlı bir username, password, email kullanarak kayıt olamamalı");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanici allovercommerce sayfasina gider");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Kullanici Register butonuna tıklar");
        // Username kutusuna daha önce kayıtlı olan bir username girilir
        registerPage.registerUsername.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        extentTest.info("Username kutusuna daha önce kayıtlı olan bir username girilir");
        // Eposta adresi kutusuna daha önce kayıtlı olan bir eposta adresi girilir
        registerPage.registerEmail.sendKeys(ConfigReader.getProperty("kayitliEmail"));
        extentTest.info("Eposta adresi kutusuna daha önce kayıtlı olan bir eposta adresi girilir");
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        extentTest.info("Sifre kutusuna gecerli bir veri girilir");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("\"I agree to the privacy policy\" kutusu işaretlenir");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Sign Up butonuna tıklanır");
        //Kayıt işleminin gerçekleşmediği doğrulanır
        ReusableMethods.bekle(1);
        String expectedResultText = "An account is already registered with your email address. ";
        Assert.assertTrue(registerPage.registeredText.getText().contains(expectedResultText));
        extentTest.info(expectedResultText+" mesajı görüntülenir");
        extentTest.pass("Kayıt işleminin gerçekleşmediği doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }
    @Test(priority = 7)
    public void KayitliBilgilerleKayitTest2() {
        ReusableMethods.createExtentReport("US02-TC02 Kullanıcının kayıtlı olmayan bir username, " +
                "email ve kayıtlı olan password ile kayıt olabilmeli");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Web sitesine gidilir");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Register butonuna tıklanır");
        // Username kutusuna daha önce kayıtlı olmayan bir username girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        extentTest.info("Username kutusuna daha önce kayıtlı olmayan bir username girilir");
        // Eposta adresi kutusuna daha önce kayıtlı olmayan bir eposta adresi girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        extentTest.info("Eposta adresi kutusuna daha önce kayıtlı olmayan bir eposta adresi girilir");
        // Sifre kutusuna daha önce kayitli bir şifre girilir
        registerPage.registerPassword.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        extentTest.info("Sifre kutusuna daha önce kayitli bir şifre girilir");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("\"I agree to the privacy policy\" kutusu işaretlenir");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Sign Up butonuna tıklanır");
        ReusableMethods.bekle(1);
        //Kayıt işleminin gerçekleştiği doğrulanır
        Assert.assertTrue(registerPage.registerSignOutText.isDisplayed());
        extentTest.pass("Kayıt işleminin gerçekleştiği doğrulanır");
        ReusableMethods.bekle(2);
        extentReports.flush();
        Driver.closeDriver();
    }
    @Test(priority = 8)
    public void KayitliBilgilerleKayitTest3() {
        ReusableMethods.createExtentReport("US02-TC03 Kullanıcının kayıtlı olmayan bir username, password " +
                "ve kayıtlı olan email kullanarak kayıt olamamalı");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Web sitesine gidilir");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Register butonuna tıklanır");
        // Username kutusuna daha önce kayıtlı olmayan bir username girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        extentTest.info("Username kutusuna daha önce kayıtlı olmayan bir username girilir");
        // Eposta adresi kutusuna daha önce kayıtlı olan bir eposta adresi girilir
        registerPage.registerEmail.sendKeys(ConfigReader.getProperty("kayitliEmail"));
        extentTest.info("Eposta adresi kutusuna daha önce kayıtlı olan bir eposta adresi girilir");
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        extentTest.info("Sifre kutusuna gecerli bir veri girilir");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("\"I agree to the privacy policy\" kutusu işaretlenir");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Sign Up butonuna tıklanır");
        ReusableMethods.bekle(1);
        //Kayıt işleminin gerçekleşmediği doğrulanır
        ReusableMethods.bekle(1);
        String expectedResultText = "An account is already registered with your email address. ";
        Assert.assertTrue(registerPage.registeredText.getText().contains(expectedResultText));
        extentTest.info("'An account is already registered with your email address. ' uyarısı görüntülenir ");
        extentTest.pass("Kayıt işleminin gerçekleşmediği doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }
    @Test(priority = 9)
    public void KayitliBilgilerleKayitTest4() {
        ReusableMethods.createExtentReport("US02-TC04 Kullanıcının geçersiz bir email kullanarak kayıt olamamalı");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Web sitesine gidilir");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Register butonuna tıklanır");
        // Username kutusuna daha önce kayıtlı olmayan bir username girilir
        registerPage.registerUsername.sendKeys(faker.name().username());
        extentTest.info("Username kutusuna daha önce kayıtlı olmayan bir username girilir");
        // Eposta adresi kutusuna geçersiz bir veri girilir
        registerPage.registerEmail.sendKeys(ConfigReader.getProperty("invalidData"));
        extentTest.info("Eposta adresi kutusuna geçersiz bir veri girilir");
        // Sifre kutusuna gecerli bir veri girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        extentTest.info("Sifre kutusuna gecerli bir veri girilir");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("\"I agree to the privacy policy\" kutusu işaretlenir");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Sign Up butonuna tıklanır");
        ReusableMethods.bekle(1);
        //Email kutusuna geçersiz bir veri girildiği için
        //"Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"abc\" adresinde \"@\" eksik."
        //uyari mesaji görülür
        String uyariMesaji ="Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"abc\" adresinde \"@\" eksik.";
        //Kayıt işleminin gerçekleşmediği doğrulanır
        Assert.assertEquals(ReusableMethods.uyariMesaji(registerPage.registerEmail),uyariMesaji);
        extentTest.info("'Lütfen e-posta adresine bir \\\"@\\\" işareti ekleyin. \\\"abc\\\" adresinde \\\"@\\\" eksik.'\n" +
                "mesajı görüntülenir");
        extentTest.pass("Kayıt işleminin gerçekleşmediği doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }
    @Test(priority = 10)
    public void KayitliBilgilerleKayitTest5() {
        ReusableMethods.createExtentReport("US02-TC05 Kullanıcının kayıtlı bir usernameve kayırtlı olmayan " +
                "password, email kullanarak kayıt olamamalı");
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Web sitesine gidilir");
        // Register butonuna tıklanır
        registerPage.registerButton.click();
        extentTest.info("Register butonuna tıklanır");
        // Username kutusuna daha önce kayıtlı olan bir username girilir
        registerPage.registerUsername.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        extentTest.info("Username kutusuna daha önce kayıtlı olan bir username girilir");
        // Eposta adresi kutusuna daha önce kayıtlı olmayan bir email girilir
        registerPage.registerEmail.sendKeys(faker.internet().emailAddress());
        extentTest.info("Eposta adresi kutusuna daha önce kayıtlı olmayan bir email girilir");
        // Sifre kutusuna daha önce kayıtlı olmayan bir sifre girilir
        registerPage.registerPassword.sendKeys(faker.internet().password());
        extentTest.info("Sifre kutusuna daha önce kayıtlı olmayan bir sifre girilir");
        // "I agree to the privacy policy" kutusu işaretlenir
        registerPage.registerRadioButton.click();
        extentTest.info("\"I agree to the privacy policy\" kutusu işaretlenir");
        // Sign Up butonuna tıklanır
        registerPage.registerSignUpButton.click();
        extentTest.info("Sign Up butonuna tıklanır");
        //Kayıt işleminin gerçekleşmediği doğrulanır
        ReusableMethods.bekle(1);
        String expectedResultText = "An account is already registered with that username. Please choose another.";
        Assert.assertTrue(registerPage.registeredText.getText().contains(expectedResultText));
        extentTest.info(expectedResultText+" mesajını görüntülenir");
        extentTest.pass("Kayıt işleminin gerçekleşmediği doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }

}
