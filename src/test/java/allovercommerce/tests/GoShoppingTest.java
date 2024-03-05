package allovercommerce.tests;

import allovercommerce.pages.GoShoppingPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoShoppingTest {


    GoShoppingPage goShoppingPage = new GoShoppingPage();
    @Test(priority = 1)
    public void searchProductAndAddToChart() {

        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Searchbox a istenilen urun ismi yazdirip aratilir
        goShoppingPage.searchBox.sendKeys("USB Receipt", Keys.ENTER);

        //Acilan sayfada ADD TO CHART butonuna tiklanarak urun sepete eklenir
        ReusableMethods.click(goShoppingPage.usbReceiptAddToCart);

        //“USB Receipt” has been added to your cart. mesajinin goruldugu dogrulanir
        Assert.assertTrue(goShoppingPage.hasBeenAddedToCartMessage.isDisplayed());

        //Class seviyesinde run icin Cart da bulunan urunler silinir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);
        ReusableMethods.click(goShoppingPage.viewCartButton);
        ReusableMethods.click(goShoppingPage.productRemoveButton);

        //Sayfa kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 2)
    public void displayProductInChart() {

        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Searchbox a istenilen urun ismi yazdirip aratilir
        goShoppingPage.searchBox.sendKeys("USB Receipt", Keys.ENTER);

        //Acilan sayfada ADD TO CHART butonuna tiklanarak urun sepete eklenir
        ReusableMethods.click(goShoppingPage.usbReceiptAddToCart);

        //Ana sayfada bulunan Cart butonuna tiklanir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);

        //Acilan pencerede VIEW CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.viewCartButton);

        //Urunun sepete eklendigi dogrulanir
        Assert.assertTrue(goShoppingPage.urunIsmiyleDogrulama.isDisplayed());

        //Class seviyesinde run icin Cart da bulunan urunler silinir
        ReusableMethods.click(goShoppingPage.productRemoveButton);

        //Sayfa kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 3)
    public void clickPlusButton() {

        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Searchbox a istenilen urun ismi yazdirip aratilir
        goShoppingPage.searchBox.sendKeys("USB Receipt", Keys.ENTER);

        //Acilan sayfada ADD TO CHART butonuna tiklanarak urun sepete eklenir
        ReusableMethods.click(goShoppingPage.usbReceiptAddToCart);

        //Ana sayfada bulunan Cart butonuna tiklanir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);

        //Acilan pencerede VIEW CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.viewCartButton);

        //Plus(+) butonuna tiklanir ve sepette eklenen urun miktari arttirilir
        ReusableMethods.click(goShoppingPage.plusButton);

        //UPDATE CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.updateCartButton);

        //Urun miktarinin arttirildigi dogrulanir
        Assert.assertEquals(goShoppingPage.urunMiktari.getAttribute("value"),"2");

        //Class seviyesinde run icin Cart da bulunan urunler silinir
        ReusableMethods.click(goShoppingPage.productRemoveButton);

        //Sayfa kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 4)
    public void clickMinusButton() {

        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Searchbox a istenilen urun ismi yazdirip aratilir
        goShoppingPage.searchBox.sendKeys("USB Receipt", Keys.ENTER);

        // Acilan sayfada ADD TO CHART butonuna tiklanarak urun sepete eklenir
        ReusableMethods.click(goShoppingPage.usbReceiptAddToCart);

        //Ana sayfada bulunan Cart butonuna tiklanir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);

        //Acilan pencerede VIEW CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.viewCartButton);

        //Plus(+) butonuna tiklanir ve sepette eklenen urun miktari arttirilir
        ReusableMethods.click(goShoppingPage.plusButton);

        //Minus(-) butonuna tiklanir ve sepette eklenen urun miktari azaltilir
        ReusableMethods.click(goShoppingPage.minusButton);

        //UPDATE CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.updateCartButton);

        //Urun miktarinin azaltildigi dogrulanir
        Assert.assertEquals(goShoppingPage.urunMiktari.getAttribute("value"),"1");

        //Class seviyesinde run icin Cart da bulunan urunler silinir
        goShoppingPage = new GoShoppingPage();
        ReusableMethods.click(goShoppingPage.productRemoveButton);

        //Sayfa kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 5)
    public void displayBillingAddress() {

        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sign In butonuna tiklanir ve kullanici bilgileri ile giris yapilir
        ReusableMethods.click(goShoppingPage.signInButton);
        goShoppingPage.userNameOrEmailAddressBox.sendKeys(ConfigReader.getProperty("userNameOrEmailAddress"));
        goShoppingPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.click(goShoppingPage.loginSignInButton);

        //Searchbox a istenilen urun ismi yazdirip aratilir
        ReusableMethods.click(goShoppingPage.searchBox);
        goShoppingPage.searchBox.sendKeys("USB Receipt", Keys.ENTER);

        // Acilan sayfada ADD TO CHART butonuna tiklanarak urun sepete eklenir
        ReusableMethods.click(goShoppingPage.usbReceiptAddToCart);

        //Ana sayfada bulunan Cart butonuna tiklanir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);

        //Acilan pencerede VIEW CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.viewCartButton);

        //PROCEED TO CHECKOUT butonuna tiklanir
        ReusableMethods.click(goShoppingPage.proceedToCheckout);

        //Billing Address bilgilerinin goruldugu dogrulanir
        Assert.assertTrue(goShoppingPage.billingDetailsText.isDisplayed());

        //Class seviyesinde run icin Cart da bulunan urunler silinir ve sign out yapilir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);
        ReusableMethods.click(goShoppingPage.viewCartButton);
        ReusableMethods.click(goShoppingPage.productRemoveButton);
        ReusableMethods.click(goShoppingPage.signOutButton);
        ReusableMethods.click(goShoppingPage.logOutButton);

        //Sayfa kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 6)
    public void displayPaymentMethods() {

        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sign In butonuna tiklanir ve kullanici bilgileri ile giris yapilir
        ReusableMethods.click(goShoppingPage.signInButton);
        goShoppingPage.userNameOrEmailAddressBox.sendKeys(ConfigReader.getProperty("userNameOrEmailAddress"));
        goShoppingPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.click(goShoppingPage.loginSignInButton);

        //Searchbox a istenilen urun ismi yazdirip aratilir
        ReusableMethods.click(goShoppingPage.searchBox);
        goShoppingPage.searchBox.sendKeys("USB Receipt", Keys.ENTER);

        //Acilan sayfada ADD TO CHART butonuna tiklanarak urun sepete eklenir
        ReusableMethods.click(goShoppingPage.usbReceiptAddToCart);

        //Ana sayfada bulunan Cart butonuna tiklanir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);

        //Acilan pencerede VIEW CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.viewCartButton);

        //PROCEED TO CHECKOUT butonuna tiklanir
        ReusableMethods.click(goShoppingPage.proceedToCheckout);

        //Payment Methods gorulur ve secilir
        Assert.assertTrue(goShoppingPage.payAtTheDoorPaymentMethod.isDisplayed());
        Assert.assertTrue(goShoppingPage.wireTransferEftPaymentMethod.isDisplayed());

        ReusableMethods.click(goShoppingPage.choosePayAtTheDoorPaymentMethod);
        Assert.assertTrue(goShoppingPage.choosePayAtTheDoorPaymentMethod.isSelected());

        ReusableMethods.click(goShoppingPage.chooseWireTransferEftPaymentMethod);
        Assert.assertTrue(goShoppingPage.chooseWireTransferEftPaymentMethod.isSelected());

        //Class seviyesinde run icin Cart da bulunan urunler silinir ve sign out yapilir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);
        ReusableMethods.click(goShoppingPage.viewCartButton);
        ReusableMethods.click(goShoppingPage.productRemoveButton);
        ReusableMethods.click(goShoppingPage.signOutButton);
        ReusableMethods.click(goShoppingPage.logOutButton);

        //Sayfa kapatilir
        //Driver.closeDriver();
    }

    @Test(priority = 7)
    public void completeOrder() {

        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sign In butonuna tiklanir ve kullanici bilgileri ile giris yapilir
        ReusableMethods.click(goShoppingPage.signInButton);
        goShoppingPage.userNameOrEmailAddressBox.sendKeys(ConfigReader.getProperty("userNameOrEmailAddress"));
        goShoppingPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.click(goShoppingPage.loginSignInButton);

        //Searchbox a istenilen urun ismi yazdirip aratilir
        ReusableMethods.click(goShoppingPage.searchBox);
        goShoppingPage.searchBox.sendKeys("USB Receipt", Keys.ENTER);

        //Acilan sayfada ADD TO CHART butonuna tiklanarak urun sepete eklenir
        ReusableMethods.click(goShoppingPage.usbReceiptAddToCart);

        //Ana sayfada bulunan Cart butonuna tiklanir
        ReusableMethods.click(goShoppingPage.anasayfaCartButton);

        //Acilan pencerede VIEW CART butonuna tiklanir
        ReusableMethods.click(goShoppingPage.viewCartButton);

        //PROCEED TO CHECKOUT butonuna tiklanir
        ReusableMethods.click(goShoppingPage.proceedToCheckout);

        // PLACE ORDER butonuna tiklanir
        ReusableMethods.click(goShoppingPage.placeOrderButton);

        // Order Complete yazisinin gorundugu dogrulanir
        Assert.assertTrue(goShoppingPage.orderCompleteText.isDisplayed());

        //Sayfa kapatilir(class seviyesinde test yaparken sadece son calisan testte bu aktif olmali yoksa hata veriyor!!)
        Driver.closeDriver();

    }

}
