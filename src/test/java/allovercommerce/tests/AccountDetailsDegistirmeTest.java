package allovercommerce.tests;

import allovercommerce.pages.AccountDetailsPage;
import allovercommerce.pages.VendorBillingAddressEkleyebilmeliPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountDetailsDegistirmeTest {

    AccountDetailsPage accountDetailsPage =new AccountDetailsPage();
    VendorBillingAddressEkleyebilmeliPage vendorBillingAddressEkleyebilmeliPage =new VendorBillingAddressEkleyebilmeliPage();

    Faker faker =new Faker();

    @Test
    public void KullaniciHesapDetaylariniGorebilmeli() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));


        //Kullanıcı en altta bulunan My Account yazısına tıklar

        ReusableMethods.scroll(vendorBillingAddressEkleyebilmeliPage.myAccountLink);
        ReusableMethods.click(vendorBillingAddressEkleyebilmeliPage.myAccountLink);



        //Kullanıcı Signin yapar
        String signUpUsername = ConfigReader.getProperty("signUpUsername");
        String password = ConfigReader.getProperty("signUpSifre");
        vendorBillingAddressEkleyebilmeliPage.signInUserName.sendKeys(signUpUsername);
        vendorBillingAddressEkleyebilmeliPage.password.sendKeys(password);
        ReusableMethods.click(vendorBillingAddressEkleyebilmeliPage.signInButton);

        //Kullanıcı My Account sayfasında "HESAP DETAYLARI" bolümüne tiklar.
        ReusableMethods.click(accountDetailsPage.accountDetailsButton);
        //Hesap Detaylarının görüntülenebildigi dogrulanır.
        //Assert.assertTrue(myAccountPage.firstName.isDisplayed());

        Faker faker= new Faker();

        ReusableMethods.bekle(2000);
        accountDetailsPage.firstNameBox.sendKeys(ConfigReader.getProperty("firstName"));
        accountDetailsPage.lastNameBox.sendKeys(ConfigReader.getProperty("lastName"));
        accountDetailsPage.displayName.sendKeys(ConfigReader.getProperty("displayName"));
        accountDetailsPage.emailAdress.sendKeys(faker.internet().emailAddress());
        ReusableMethods.click(accountDetailsPage.saveChangesButton);


    }

    @Test
    public void kullanıcıFirstNameLastNameDisplaynameVeEmailAddressBilgileriniDeğiştirebilmeli() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Kullanıcı en altta bulunan My Account yazısına tıklar


        ReusableMethods.scroll(vendorBillingAddressEkleyebilmeliPage.myAccountLink);
        ReusableMethods.click(vendorBillingAddressEkleyebilmeliPage.myAccountLink);

        //Kullanıcı Signin yapar
        String signUpUsername = ConfigReader.getProperty("signUpUsername");
        String password = ConfigReader.getProperty("signUpSifre");
        vendorBillingAddressEkleyebilmeliPage.signInUserName.sendKeys(signUpUsername);
        vendorBillingAddressEkleyebilmeliPage.password.sendKeys(password);
        ReusableMethods.click(vendorBillingAddressEkleyebilmeliPage.signInButton);

        //Kullanıcı My Account sayfasında "HESAP DETAYLARI" bolümüne tiklar.

        ReusableMethods.click(accountDetailsPage.accountDetailsButton);


        accountDetailsPage.firstNameBox.sendKeys(ConfigReader.getProperty("firstName"));
        accountDetailsPage.lastNameBox.sendKeys(ConfigReader.getProperty("lastName"));
        //myAccountPage02.displayName.sendKeys(ConfigReader.getProperty("displayName"));
        accountDetailsPage.emailAdress.sendKeys(faker.internet().emailAddress());
        ReusableMethods.click(accountDetailsPage.saveChangesButton);

        Assert.assertTrue( accountDetailsPage.firstNameBox.getAttribute("value").contains("JeffAli"));

    }

    @Test
    public void KullanıcıBiographyBolumunuDoldurabilmeli () {



        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Kullanıcı en altta bulunan My Account yazısına tıklar
        ReusableMethods.scroll(vendorBillingAddressEkleyebilmeliPage.myAccountLink);
        ReusableMethods.click(vendorBillingAddressEkleyebilmeliPage.myAccountLink);


        //Kullanıcı Signin yapar
        String signUpUsername = ConfigReader.getProperty("signUpUsername");
        String password = ConfigReader.getProperty("signUpSifre");
        vendorBillingAddressEkleyebilmeliPage.signInUserName.sendKeys(signUpUsername);
        vendorBillingAddressEkleyebilmeliPage.password.sendKeys(password);
        ReusableMethods.click(vendorBillingAddressEkleyebilmeliPage.signInButton);

        //Kullanıcı My Account sayfasında "HESAP DETAYLARI" bolümüne tiklar.
        ReusableMethods.click(accountDetailsPage.accountDetailsButton);


        // Kullanıcı Biography kısmına geçerli veri girer
        AccountDetailsPage accountDetailsPage=new AccountDetailsPage();
        ReusableMethods.scrollEnd();
        Faker faker =new Faker();
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.bekle(2000);
        accountDetailsPage.biographyTextBox.sendKeys(faker.lorem().paragraph());
        ReusableMethods.bekle(2000);
        Driver.getDriver().switchTo().defaultContent();

        //Kullanıcı sayfanın altında bulunan SAVE CHANGES (DEĞİŞİKLİKLERİ KAYDET) butonuna tıklar
        ReusableMethods.click(accountDetailsPage.saveChangesButton);

        //Biography bölümününün doldurulabildiği doğrulanır

        Assert.assertNotNull(accountDetailsPage.biographyTextBox.getText(),"biographyTextBox should not be empty");


    }


    @Test
    public void KullanıcıPassworduDegiştirebilmeli() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Kullanıcı en altta bulunan My Account yazısına tıklar
        ReusableMethods.scroll(accountDetailsPage.myAccount);
        ReusableMethods.click(accountDetailsPage.myAccount);

        //Kullanıcı Signin yapar
        String signUpUsername = ConfigReader.getProperty("signUpUsername");
        String password = ConfigReader.getProperty("signUpSifre");
        vendorBillingAddressEkleyebilmeliPage.signInUserName.sendKeys(signUpUsername);
        vendorBillingAddressEkleyebilmeliPage.password.sendKeys(password);
        ReusableMethods.click(vendorBillingAddressEkleyebilmeliPage.signInButton);

        //Kullanıcı My Account sayfasında "HESAP DETAYLARI" bolümüne tiklar.
        ReusableMethods.click(accountDetailsPage.accountDetailsButton);

        // Kullanıcı Password change bölümünde "Current password leave blank to leave unchanged" başlığı altındaki kutucuğa mevcut password u girer
        accountDetailsPage.currentPasswordBox.sendKeys(ConfigReader.getProperty("signUpSifre"));

        // Kullanıcı Password change bölümünde "New password leave blank to leave unchanged" başlığı altındaki kutucuğa yeni password u girer
        accountDetailsPage.newPasswordBox.sendKeys(faker.internet().password());
        // Kullanıcı Password change bölümünde "Confirm password" başlığı altındaki kutucuğa şifreleri doğrulamak için yeni password u tekrar girer
        accountDetailsPage.confirmPasswordBox.sendKeys(accountDetailsPage.newPasswordBox.getText());

        // Kullanıcı sayfanın altında bulunan SAVE CHANGES (DEĞİŞİKLİKLERİ KAYDET) butonuna tıklar

        ReusableMethods.click(accountDetailsPage.saveChangesButton);
        //Password un değiştirilebildiği doğrulanır
        Assert.assertTrue(accountDetailsPage.changedSuccessfullyAlert.isDisplayed());


    }
}
