package allovercommerce.tests;

import allovercommerce.pages.MyAccountPage;
import allovercommerce.pages.RegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VendorGirisTest {

    @Test
    public void vendorGirisTest() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage=new RegisterPage();
        registerPage.signInButton.click();
        // Username or Email Address kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage =new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfanın solunda bulunan "Stora Manager" sekmesinin görüntülendiği doğrulanır..
        Assert.assertTrue(myAccountPage.storeManagerElement.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void vendorUsernameOrEmailBosTest() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage=new RegisterPage();
        registerPage.signInButton.click();
        // Username or Email Address kutusu boş bırakılır
        MyAccountPage myAccountPage =new MyAccountPage();
        // Sifre kutusuna gecerli bir veri girilir
        Faker faker =new Faker();
        myAccountPage.vendorPassword.
                sendKeys(faker.internet().
                        password(7,12,true,true,true));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(1);
        //"Username or email address" kutusu boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Vendor olarak giriş yapılamadığı doğrulanır..
        Assert.assertEquals(ReusableMethods.uyariMesaji(myAccountPage.vendorUsernameOrEmailBox),"Lütfen bu alanı doldurun.");
        Driver.closeDriver();
    }
    @Test
    public void vendorPasswordBosTest() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage=new RegisterPage();
        registerPage.signInButton.click();
        //Username or Email Address kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage =new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusu boş bırakılır

        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(1);
        //"Password" kutusu boş bırakıldığ için "Lütfen bu alanı doldurun." mesajı görülür
        //Vendor olarak giriş yapılamadığı doğrulanır..
        Assert.assertEquals(ReusableMethods.uyariMesaji(myAccountPage.vendorPassword),"Lütfen bu alanı doldurun.");
        Driver.closeDriver();
    }
    @Test
    public void vendorGirisTest4() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage=new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage =new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfada (Store manager, orders, downloads, addresses , account details, wishlist, Support tickets,
        // followings ve log out) menulerinin görüntülendiği doğrulanır..
        Assert.assertTrue(myAccountPage.storeManagerElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.ordersElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.downloadsElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.addressElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.accountDetailsElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.wishListElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.supportTicketsElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.followingElement.isDisplayed());
        ReusableMethods.bekle(1);
        Assert.assertTrue(myAccountPage.logOutElement.isDisplayed());
        ReusableMethods.bekle(1);
        Driver.closeDriver();

    }
    @Test
    public void storeManagerMyStoreMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfada Store manager butonuna tıklar
        myAccountPage.storeManagerElement.click();
        //Store Manager sayfasındaki My Store menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.myStoreMenuElement.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void ordersMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Orders butonuna tıklar
        myAccountPage.ordersElement.click();
        // Orders sayfası açılır ve Browser Products menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.browseProductsElement.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void downloadsMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Downloads butonuna tıklanır
        myAccountPage.downloadsElement.click();
        // Downloads sayfası açılır ve Downloads menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.downloadsMenu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void addressMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Downloads butonuna tıklanır
        ReusableMethods.click(myAccountPage.addressElement);
        // Address sayfası açılır ve Billing Address menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.billingsAddressMenu.isDisplayed());
        // Address sayfası açılır ve Shipping Address menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.shippingAddressMenu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void accountDetailsMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Account Details butonuna tıklanır
        ReusableMethods.click(myAccountPage.accountDetailsElement);
        // Account Details sayfası açılır ve Account Details menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.accountDetailsMenu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void wishlistMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Wishlist butonuna tıklanır
        ReusableMethods.click(myAccountPage.wishListElement);
        // Wishlist sayfası açılır ve Wishlist menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.wishlistMenu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void supportTicketsMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Support Tickets butonuna tıklanır
        ReusableMethods.click(myAccountPage.supportTicketsElement);
        // Support Tickets sayfası açılır ve Ticket(s) menusünün görüntülendiği doğrulanır
        Assert.assertTrue(myAccountPage.ticketsMenu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void followingsMenu() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Followings butonuna tıklanır
        ReusableMethods.click(myAccountPage.followingElement);
        // Followings sayfası açılır ve "You are not following any vendor yet!" yazısının görüntülendiği doğrulanır
        String expectedMessege ="You are not following any vendor yet!";
        Assert.assertEquals(myAccountPage.followingTextMenu.getText(),expectedMessege);
        Driver.closeDriver();
    }
    @Test
    public void logoutOlma() {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInButton.click();
        // Eposta adresi kutusuna vendor olarak kayıtlı olan email adresi girilir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.vendorUsernameOrEmailBox.sendKeys(ConfigReader.getProperty("vendorEmail"));
        // Sifre kutusuna gecerli bir veri girilir
        myAccountPage.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"));
        // Sign In butonuna tıklanır
        myAccountPage.signInVendorButton.click();
        ReusableMethods.bekle(3);
        //Sayfanın en altında bulunan My Account sekmesine gelinir
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(1);
        //My Account a tıklanır
        myAccountPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfadaki Logout butonuna tıklanır
        ReusableMethods.click(myAccountPage.logOutElement);
        // My account sayfası açılır ve vendor kullanıcının logout olduğu doğrulanır
        Assert.assertTrue(registerPage.signInButton.isDisplayed());
        Driver.closeDriver();
    }
}
