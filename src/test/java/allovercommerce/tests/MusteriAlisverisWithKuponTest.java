package allovercommerce.tests;

import allovercommerce.pages.MusteriAlisverisPage;
import allovercommerce.pages.RegisterPage;
import allovercommerce.pages.UrunKarsilastirmaPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class MusteriAlisverisWithKuponTest {

    @Test
    public void test01() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna olarak kayıtlı olan email adresi girilir
        UrunKarsilastirmaPage urunKarsilastirmaPage =new UrunKarsilastirmaPage();
        urunKarsilastirmaPage.usernameOrEmailBox.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Sifre kutusuna gecerli bir veri girilir
        urunKarsilastirmaPage.passwordBox.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // Sign In butonuna tıklanır
        urunKarsilastirmaPage.signInButton.click();
        ReusableMethods.bekle(2);
        // Shopping sayfası açılır ve searchbox a "iphone" girilir ve aratılır
        urunKarsilastirmaPage.searchBox.sendKeys(ConfigReader.getProperty("indirimliUrun"), Keys.ENTER);
        //Açılan sayfadan "Iphone 15 Pro Max" urunu seçilir
        MusteriAlisverisPage musteriAlisverisPage =new MusteriAlisverisPage();
        Actions actions =new Actions(Driver.getDriver());
        actions.moveToElement(musteriAlisverisPage.iphone15ProMax).perform();
        ReusableMethods.bekle(2);
        //"Iphone 15 Pro Max" urununun üzerine gelinir ve add to card iconuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.iphone15AddToCardIcon);
        ReusableMethods.bekle(1);
        //Açılan pencereden Card daki ürünleri görmek için View cart butonuna tıklar
        ReusableMethods.click(musteriAlisverisPage.viewCardButton);
        //sayfada scrool yapılır
        ReusableMethods.scroll(musteriAlisverisPage.applyCouponButton);
        //COUPON DISCOUNT bölümüne oluşturulan kupon code girilir
        musteriAlisverisPage.kuponBox.sendKeys(ConfigReader.getProperty("olusturulanKuponCode"));
        //Apply Coupon butonuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.applyCouponButton);
        ReusableMethods.bekle(1);
        ReusableMethods.scrollHome();
        //"Coupon code applied successfully." yazısının görüntülendiği doğrulanır
        String expectedText = "Coupon code applied successfully.";
        Assert.assertEquals(musteriAlisverisPage.kuponUygulandiText.getText(),expectedText);
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna olarak kayıtlı olan email adresi girilir
        UrunKarsilastirmaPage urunKarsilastirmaPage =new UrunKarsilastirmaPage();
        urunKarsilastirmaPage.usernameOrEmailBox.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Sifre kutusuna gecerli bir veri girilir
        urunKarsilastirmaPage.passwordBox.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // Sign In butonuna tıklanır
        urunKarsilastirmaPage.signInButton.click();
        ReusableMethods.bekle(2);
        // Shopping sayfası açılır ve searchbox a "kazak" girilir ve aratılır
        urunKarsilastirmaPage.searchBox.sendKeys(ConfigReader.getProperty("indirimsizUrun"), Keys.ENTER);
        //Açılan sayfadan "KAZAK" urunu seçilir
        MusteriAlisverisPage musteriAlisverisPage =new MusteriAlisverisPage();
        Actions actions =new Actions(Driver.getDriver());
        actions.moveToElement(musteriAlisverisPage.kazak1).perform();
        ReusableMethods.bekle(2);
        //"KAZAK" urununun üzerine gelinir ve add to card iconuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.kazakAdToCartIcon);
        ReusableMethods.bekle(1);
        //Açılan pencereden Card daki ürünleri görmek için View cart butonuna tıklar
        ReusableMethods.click(musteriAlisverisPage.viewCardButton);
        //sayfada scrool yapılır
        ReusableMethods.scroll(musteriAlisverisPage.applyCouponButton);
        //COUPON DISCOUNT bölümüne oluşturulan kupon code girilir
        musteriAlisverisPage.kuponBox.sendKeys(ConfigReader.getProperty("olusturulanKuponCode"));
        //Apply Coupon butonuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.applyCouponButton);
        ReusableMethods.bekle(1);
        ReusableMethods.scrollHome();
        //"Sorry, this coupon is not applicable to selected products." yazısının görüntülendiği doğrulanır
        String expectedText = "Sorry, this coupon is not applicable to selected products.";
        Assert.assertEquals(musteriAlisverisPage.kuponUygulanmadiText.getText(),expectedText);
        Driver.closeDriver();
    }
    @Test
    public void test03() throws AWTException {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna olarak kayıtlı olan email adresi girilir
        UrunKarsilastirmaPage urunKarsilastirmaPage =new UrunKarsilastirmaPage();
        urunKarsilastirmaPage.usernameOrEmailBox.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Sifre kutusuna gecerli bir veri girilir
        urunKarsilastirmaPage.passwordBox.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // Sign In butonuna tıklanır
        urunKarsilastirmaPage.signInButton.click();
        ReusableMethods.bekle(2);
        // Shopping sayfası açılır ve searchbox a "iphone" girilir ve aratılır
        urunKarsilastirmaPage.searchBox.sendKeys(ConfigReader.getProperty("indirimliUrun"), Keys.ENTER);
        //Açılan sayfadan "Iphone 15 Pro Max" urunu seçilir
        MusteriAlisverisPage musteriAlisverisPage =new MusteriAlisverisPage();
        Actions actions =new Actions(Driver.getDriver());
        actions.moveToElement(musteriAlisverisPage.iphone15ProMax).perform();
        ReusableMethods.bekle(2);
        //"Iphone 15 Pro Max" urununun üzerine gelinir ve add to card iconuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.iphone15AddToCardIcon);
        ReusableMethods.bekle(1);
        //Açılan pencereden Card daki ürünleri görmek için View cart butonuna tıklar
        ReusableMethods.click(musteriAlisverisPage.viewCardButton);
        //sayfada scrool yapılır
        ReusableMethods.scroll(musteriAlisverisPage.applyCouponButton);
        //COUPON DISCOUNT bölümüne oluşturulan kupon code girilir
        musteriAlisverisPage.kuponBox.sendKeys(ConfigReader.getProperty("olusturulanKuponCode"));
        //Apply Coupon butonuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.applyCouponButton);
        ReusableMethods.bekle(1);
        //"Coupon code applied successfully." yazısının görüntülendiği doğrulanır
        //String expectedText = "Coupon code applied successfully.";
        // Assert.assertEquals(musteriAlisverisPage.kuponUygulandiText.getText(),expectedText);
        //Proceed to checkout butonuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.proceedToCheckoutButton);
        //BILLING DETAILS sayfası açılır
        Faker faker =new Faker();
        //First Name kutusuna geçerli bir veri girilir
        ReusableMethods.deleteMethod(musteriAlisverisPage.billingFirstNameBox);
        musteriAlisverisPage.billingFirstNameBox.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        //Last Name kutusuna geçerli bir veri girilir
        ReusableMethods.deleteMethod(musteriAlisverisPage.billingLastNameBox);
        musteriAlisverisPage.billingLastNameBox.sendKeys(faker.name().lastName());
        ReusableMethods.click(musteriAlisverisPage.billingCountryDdm);
        ReusableMethods.bekle(3);
        actions.click(musteriAlisverisPage.billingCountryUSA).perform();
        //Street address kutusuna geçerli bir veri girilir
        ReusableMethods.deleteMethod(musteriAlisverisPage.billingStreetBox);
        musteriAlisverisPage.billingStreetBox.sendKeys(faker.address().streetAddress());
        //Town/City kutusunua geçerli bir veri girilir
        ReusableMethods.deleteMethod(musteriAlisverisPage.billingTownBox);
        musteriAlisverisPage.billingTownBox.sendKeys(faker.address().cityName());
        ReusableMethods.bekle(1);
        //State drop down menu den uygun şehir seçilir
        ReusableMethods.click(musteriAlisverisPage.billingProvinceDdm);
        ReusableMethods.bekle(1);
        ReusableMethods.click(musteriAlisverisPage.stateNewYork);
        //ZIP Code kutusuna geçerli bir code girilir
        ReusableMethods.deleteMethod(musteriAlisverisPage.billingZipCodeBox);
        ReusableMethods.click(musteriAlisverisPage.billingZipCodeBox);
        musteriAlisverisPage.billingZipCodeBox.sendKeys(faker.address().zipCode());
        //Phone kutusuna geçerli bir veri girilir
        ReusableMethods.deleteMethod(musteriAlisverisPage.billingPhoneBox);
        musteriAlisverisPage.billingPhoneBox.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.scroll(musteriAlisverisPage.billingStreetBox);
        ReusableMethods.bekle(1);

        //Email addres kutusunda mailimiz görüntülendiği doğrulanır
        String expectedMail = ConfigReader.getProperty("kayitliEmail");
        String actualMail = musteriAlisverisPage.billinEmailBox.getAttribute("value");
        Assert.assertEquals(actualMail,expectedMail);
        ReusableMethods.click(musteriAlisverisPage.payAdTheDoor);
        ReusableMethods.bekle(1);
        //PLACE ORDER butonuna tıklanır
        ReusableMethods.click(musteriAlisverisPage.placeOrderButton);
        ReusableMethods.bekle(2);
        //"Thank you. Your order has been received." yazısının görüntülendiği doğrulanır
        String actualText =musteriAlisverisPage.alisverisTamamText.getText();
        Assert.assertEquals(actualText,"Thank you. Your order has been received.");
        Driver.closeDriver();
    }
}
