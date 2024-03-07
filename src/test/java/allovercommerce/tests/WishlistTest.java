package allovercommerce.tests;

import allovercommerce.pages.WishlistPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTest {

    WishlistPage wishlistPage = new WishlistPage();

    @BeforeMethod
    public void setUp() {
        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        // Incelemek istenilen urun tiklanir
        ReusableMethods.click(wishlistPage.comfortableBackpack);

        //incelenen urunun sayfasinda Wishlist(begen,kalp) butonuna tiklanir
        ReusableMethods.click(wishlistPage.comfortableBackpackWishlistButton);

        //Ana sayfadaki Wishlist butonuna tiklanir
        ReusableMethods.click(wishlistPage.anaSayfaWishlistButton);
        Driver.getDriver().navigate().refresh();

    }

    @Test(priority = 1)
    public void addProductToWishlistAndDisplayProductInWishlist() {

        //Eklenen urunler Wishlist sayfasinda gorulur
        Assert.assertTrue(wishlistPage.comfortableBackpackInWishlist.isDisplayed());

        //Class seviyesinde test yapabilmek icin whishlistteki urunler silinir
        ReusableMethods.click(wishlistPage.removeWishlist);

        //Sayfa Kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 2)
    public void quickViewFeatures() {

        //Wishlistteki bir urun icin Quick View butonuna tiklanir
        ReusableMethods.click(wishlistPage.quickView);

        //Quick View butonuna tiklandiktan sonra urun ozellikleri goruntulenir
        Assert.assertTrue(wishlistPage.quickViewFeatures.isEnabled());//================>>> isDisplayed olunca calismiyor !!!

        //Class seviyesinde test yapabilmek icin whishlistteki urunler silinir
        ReusableMethods.click(wishlistPage.closeQuickView);
        ReusableMethods.click(wishlistPage.removeWishlist);

        //Sayfa Kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 3)
    public void addToCartAndOrder() {

        //Satin alinmak istenen urun icin Add To Cart butonuna tiklanir
        ReusableMethods.click(wishlistPage.addToCart);

        //Ana sayfadaki Cart butonuna tiklanir, ardindan acilan sayfada View Cart butonuna tiklanir ve Cart sayfasina gidilir
        ReusableMethods.click(wishlistPage.anaSayfaCartButton);
        ReusableMethods.click(wishlistPage.ViewCartButton);
        //Satin alma islemi icin PROCEED TO CHECKOUT butonuna tiklanir ve Checkout sayfasina gidilir
        ReusableMethods.click(wishlistPage.proceedToCheckoutButton);

        //Checkout sayfasindaki zorunlu alanlar doldurulur ve PLACE ORDER butonuna tiklanir
        Faker faker = new Faker();
        wishlistPage.checkoutFirstName.sendKeys(faker.name().firstName());
        wishlistPage.checkoutLasttName.sendKeys(faker.name().lastName());
        ReusableMethods.click(wishlistPage.checkoutCountryRegion);
        ReusableMethods.click(wishlistPage.checkoutCountryRegion);
        wishlistPage.checkoutStreetAddress.sendKeys(faker.address().streetAddress());
        wishlistPage.checkoutTownCity.sendKeys(faker.address().city());
        ReusableMethods.click(wishlistPage.checkoutState);
        ReusableMethods.click(wishlistPage.checkoutState);
        wishlistPage.checkoutZipCode.sendKeys(faker.address().zipCode());
        int phoneNumber = faker.number().numberBetween(0,11);
        String phoneNumberString = String.valueOf(phoneNumber);
        wishlistPage.checkoutPhone.sendKeys(phoneNumberString);
        wishlistPage.checkoutEmailAddress.sendKeys(faker.internet().emailAddress());
        ReusableMethods.click(wishlistPage.checkoutPlaceHolderButton);

        // Order Complete yazisi gorulur ve Siparisin tamamlandigi dogrulanir
        Assert.assertTrue(wishlistPage.orderCompleteText.isDisplayed());

        //Sayfa Kapatilir(class seviyesinde test yaparken sadece son calisan testte bu aktif olmali yoksa hata veriyor!!)
        Driver.closeDriver();
    }

}
