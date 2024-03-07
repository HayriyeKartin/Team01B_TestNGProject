package allovercommerce.tests;

import allovercommerce.pages.AccountDetailsPage;
import allovercommerce.pages.VendorBillingAddressEkleyebilmeliPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AccountDetailsDegistirmeTest {
    AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        //1-Kullanıcı anasayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //2-Kullanıcı en altta bulunan My Account yazısına tıklar
        //3-Kullanıcı My Account sayfasına gelir
        ReusableMethods.scroll(accountDetailsPage.myAccount);
        ReusableMethods.click(accountDetailsPage.myAccount);

        //4-Kullanıcı Sign in yapar
        accountDetailsPage.signInUserName.sendKeys(ConfigReader.getProperty("signUpMail"));
        accountDetailsPage.signInPassword.sendKeys(ConfigReader.getProperty("signUpSifre"));
        ReusableMethods.click(accountDetailsPage.signInButton);

        //5-Kullanıcı My Account sayfasından "HESAP DETAYLARI" bölümüne tıklar
        ReusableMethods.click(accountDetailsPage.accountDetailsButton);
    }

    @Test
    public void KullaniciAccountDetailsDegistirebilmeli() {


        //6-Hesap detaylarının görüntülenebildiği doğrulanır
        Assert.assertTrue(accountDetailsPage.accountDetailsText.isDisplayed());
    }

    @Test
    public void KullaniciFirstNameLastNameDisplayNameEmailAddressBilgileriniDegistirebilmeli() {

        //5-Kullanıcı First name kısmına geçerli bir veri girer
        accountDetailsPage.firstNameBox.clear();
        accountDetailsPage.firstNameBox.sendKeys(ConfigReader.getProperty("firstName"));
        //6-Kullanıcı Last name kısmına geçerli bir veri girer
        accountDetailsPage.lastNameBox.clear();
        accountDetailsPage.lastNameBox.sendKeys(ConfigReader.getProperty("lastName"));
        //7-Kullanıcı Display name kısmına geçerli bir veri girer
        accountDetailsPage.displayNameBox.clear();
        accountDetailsPage.displayNameBox.sendKeys(ConfigReader.getProperty("displayName"));
        //8-Kullanıcı email adress kısmına geçerli bir mail adresi girer
        accountDetailsPage.emailAddressButton.clear();
        accountDetailsPage.emailAddressButton.sendKeys(ConfigReader.getProperty("signUpMail"));
        //9-Kullanıcı sayfanın altında bulunan "DEĞİŞİKLİKLERİ KAYDET" butonuna tıklar
        ReusableMethods.click(accountDetailsPage.saveChangesButton);
        //10-First name, Last name, Display name ve Email address bilgilerinin değiştirilebildiği doğrulanır
        Assert.assertTrue(accountDetailsPage.changedSuccessfullyAlert.isDisplayed());

    }

    @Test
    public void KullaniciAccountDetailsDegistirebilmeliBiographyBolumunuDoldurabilmeli() {

        Actions actions = new Actions(Driver.getDriver());

        //Kullanıcı Biography kısmına geçerli veri girer

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().switchTo().frame("user_description_ifr");
        accountDetailsPage.metinAlani.clear();
        ReusableMethods.bekle(2);
        accountDetailsPage.metinAlani.sendKeys(faker.harryPotter().quote());
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().defaultContent();
        //Kullanıcı sayfanın altında bulunan SAVE CHANGES (DEĞİŞİKLİKLERİ KAYDET) butonuna tıklar



        //Biography bölümününün doldurulabildiği doğrulanır




    }


}
