package allovercommerce.tests;

import allovercommerce.pages.KuponOlusturmaPage;
import allovercommerce.pages.MyAccountPage;
import allovercommerce.pages.RegisterPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KuponOlusturmaTest {

    @Test
    public void test01() {
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
        ReusableMethods.bekle(3);
        //My Account a tıklanır
        KuponOlusturmaPage kuponOlusturmaPage =new KuponOlusturmaPage();
        kuponOlusturmaPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfada Store manager butonuna tıklar
        ReusableMethods.bekle(1);
        myAccountPage.storeManagerElement.click();
        //Store Manager sayfasındaki My Store menusünün görüntülenir
        //Coupons menusune tıklanır
        ReusableMethods.click(kuponOlusturmaPage.couponsElement);
        //Coupons sayfasında Add New butonuna tıklanır
        kuponOlusturmaPage.addNewKupon.click();
        // Code girilir
        //Description bölümüne açıklama girilir
        Faker faker =new Faker();
        String code = faker.code().asin();
        String aciklama = faker.lorem().toString();
        kuponOlusturmaPage.codeBox.sendKeys(code, Keys.TAB,aciklama);
        //Discount Type "Percentage discount"seçilir
        ReusableMethods.ddmIndex(kuponOlusturmaPage.discountTypeDropDown,0);
        //Coupon Amount kısmına girilir
        //Coupon expiry date seçilir
        kuponOlusturmaPage.couponAmount.
                sendKeys(Keys.BACK_SPACE,ConfigReader.
                        getProperty("kuponAmount%"),Keys.TAB,ConfigReader.getProperty("kuponAmaount"));
        //Allow Free Shipping ve Show on Store işaretlenir
        ReusableMethods.click(kuponOlusturmaPage.allowFreeShipping);
        ReusableMethods.bekle(1);
        ReusableMethods.click(kuponOlusturmaPage.showOnStore);
        ReusableMethods.bekle(1);
        //SUBMIT butonuna tıklanır
        ReusableMethods.click(kuponOlusturmaPage.submitButton);
        ReusableMethods.visibleWait(kuponOlusturmaPage.kuponSavedText,2);
        // "Coupon Successfully Published." yazısının görüntülendiği doğrulanır
        Assert.assertEquals(kuponOlusturmaPage.kuponSavedText.getText(),"Coupon Successfully Published.");
        Driver.closeDriver();

    }
    @Test
    public void test02() {
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
        ReusableMethods.bekle(3);
        //My Account a tıklanır
        KuponOlusturmaPage kuponOlusturmaPage =new KuponOlusturmaPage();
        kuponOlusturmaPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfada Store manager butonuna tıklar
        ReusableMethods.bekle(1);
        myAccountPage.storeManagerElement.click();
        //Store Manager sayfasındaki My Store menusünün görüntülenir
        //Coupons menusune tıklanır
        ReusableMethods.click(kuponOlusturmaPage.couponsElement);
        //Coupons sayfasında Add New butonuna tıklanır
        kuponOlusturmaPage.addNewKupon.click();
        // Code kutusu boş bırakılır
        //Description bölümüne açıklama girilir
        Faker faker =new Faker();
        String code = faker.code().asin();
        String aciklama = faker.lorem().toString();
        kuponOlusturmaPage.codeBox.sendKeys(Keys.TAB,aciklama);
        //Discount Type "Percentage discount" seçilir
        ReusableMethods.ddmIndex(kuponOlusturmaPage.discountTypeDropDown,0);
        //Coupon Amount kısmına girilir
        //Coupon expiry date seçilir
        kuponOlusturmaPage.couponAmount.
                sendKeys(Keys.BACK_SPACE,ConfigReader.
                        getProperty("kuponAmount%"),Keys.TAB,ConfigReader.getProperty("kuponAmaount"));
        //Allow Free Shipping ve Show on Store işaretlenir
        ReusableMethods.click(kuponOlusturmaPage.allowFreeShipping);
        ReusableMethods.bekle(1);
        ReusableMethods.click(kuponOlusturmaPage.showOnStore);
        ReusableMethods.bekle(1);
        //SUBMIT butonuna tıklanır
        ReusableMethods.click(kuponOlusturmaPage.submitButton);
        ReusableMethods.visibleWait(kuponOlusturmaPage.kuponSavedText,2);
        // "Please insert atleast Coupon Title before submit." yazısının görüntülendiği
        // ve dolayısıyle kupon oluşturulamadığı doğrulanır
        Assert.assertEquals(kuponOlusturmaPage.kuponSavedText.getText(),"Please insert atleast Coupon Title before submit.");
        Driver.closeDriver();

    }
    @Test
    public void test03() {
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
        ReusableMethods.bekle(3);
        //My Account a tıklanır
        KuponOlusturmaPage kuponOlusturmaPage =new KuponOlusturmaPage();
        kuponOlusturmaPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfada Store manager butonuna tıklar
        ReusableMethods.bekle(1);
        myAccountPage.storeManagerElement.click();
        //Store Manager sayfasındaki My Store menusünün görüntülenir
        //Coupons menusune tıklanır
        ReusableMethods.click(kuponOlusturmaPage.couponsElement);
        //Coupons sayfasında Add New butonuna tıklanır
        kuponOlusturmaPage.addNewKupon.click();
        // Code girilir
        //Description bölümüne herhangi bir açıklama girilmez..
        Faker faker =new Faker();
        String code = faker.code().asin();
        String aciklama = faker.lorem().toString();
        kuponOlusturmaPage.codeBox.sendKeys(code);
        //Discount Type seçilir
        ReusableMethods.ddmIndex(kuponOlusturmaPage.discountTypeDropDown,0);
        //Coupon Amount kısmına girilir
        //Coupon expiry date seçilir
        kuponOlusturmaPage.couponAmount.
                sendKeys(Keys.BACK_SPACE,ConfigReader.
                        getProperty("kuponAmount%"),Keys.TAB,ConfigReader.getProperty("kuponAmaount"));
        //Allow Free Shipping ve Show on Store işaretlenir
        ReusableMethods.click(kuponOlusturmaPage.allowFreeShipping);
        ReusableMethods.bekle(1);
        ReusableMethods.click(kuponOlusturmaPage.showOnStore);
        ReusableMethods.bekle(1);
        //SUBMIT butonuna tıklanır
        ReusableMethods.click(kuponOlusturmaPage.submitButton);
        ReusableMethods.visibleWait(kuponOlusturmaPage.kuponSavedText,2);
        // "Coupon Successfully Published." yazısının görüntülendiği doğrulanır
        Assert.assertEquals(kuponOlusturmaPage.kuponSavedText.getText(),"Coupon Successfully Published.");
        Driver.closeDriver();
    }
    @Test
    public void test04() {
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
        ReusableMethods.bekle(3);
        //My Account a tıklanır
        KuponOlusturmaPage kuponOlusturmaPage =new KuponOlusturmaPage();
        kuponOlusturmaPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfada Store manager butonuna tıklar
        ReusableMethods.bekle(1);
        myAccountPage.storeManagerElement.click();
        //Store Manager sayfasındaki My Store menusünün görüntülenir
        //Coupons menusune tıklanır
        ReusableMethods.click(kuponOlusturmaPage.couponsElement);
        //Coupons sayfasında Add New butonuna tıklanır
        kuponOlusturmaPage.addNewKupon.click();
        // Code girilir
        //Description bölümüne açıklama girilir
        Faker faker =new Faker();
        String code = faker.code().asin();
        String aciklama = faker.lorem().toString();
        kuponOlusturmaPage.codeBox.sendKeys(code,Keys.TAB,aciklama);
        //Discount Type "Fixed Product Discount" seçilir
        ReusableMethods.ddmIndex(kuponOlusturmaPage.discountTypeDropDown,1);
        //Coupon Amount kısmı girilir
        //Coupon expiry date seçilir
        kuponOlusturmaPage.couponAmount.
                sendKeys(Keys.BACK_SPACE,ConfigReader.
                        getProperty("kuponAmaount"),Keys.TAB,ConfigReader.getProperty("couponExpriyDate"));
        //Allow Free Shipping ve Show on Store işaretlenir
        ReusableMethods.click(kuponOlusturmaPage.allowFreeShipping);
        ReusableMethods.bekle(1);
        ReusableMethods.click(kuponOlusturmaPage.showOnStore);
        ReusableMethods.bekle(1);
        //SUBMIT butonuna tıklanır
        ReusableMethods.click(kuponOlusturmaPage.submitButton);
        ReusableMethods.visibleWait(kuponOlusturmaPage.kuponSavedText,2);
        // "Coupon Successfully Published." yazısının görüntülendiği doğrulanır
        Assert.assertEquals(kuponOlusturmaPage.kuponSavedText.getText(),"Coupon Successfully Published.");
        // Store manager sayfası açılır Edit Coupon bölümünde Discount Type olarak "Fixed product discount"
        //yazısının görüntülendiği doğrulanır
        System.out.println(kuponOlusturmaPage.kuponTypeSonucText.getText());
        Assert.assertEquals(kuponOlusturmaPage.kuponTypeSonucText.getText(),"Fixed product discount");
        Driver.closeDriver();


    }
    @Test
    public void test05() {
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
        ReusableMethods.bekle(3);
        //My Account a tıklanır
        KuponOlusturmaPage kuponOlusturmaPage =new KuponOlusturmaPage();
        kuponOlusturmaPage.myAccount.click();
        //My account sayfasının açıldığı görülür
        //Sayfada Store manager butonuna tıklar
        ReusableMethods.bekle(1);
        myAccountPage.storeManagerElement.click();
        //Store Manager sayfasındaki My Store menusünün görüntülenir
        //Coupons menusune tıklanır
        ReusableMethods.click(kuponOlusturmaPage.couponsElement);
        //Coupons sayfasında Add New butonuna tıklanır
        kuponOlusturmaPage.addNewKupon.click();
        // Code girilir
        //Description bölümüne açıklama girilir
        Faker faker =new Faker();
        String code = faker.code().asin();
        String aciklama = faker.lorem().toString();
        kuponOlusturmaPage.codeBox.sendKeys(code,Keys.TAB,aciklama);
        //Discount Type "Percentage discount" seçilir
        ReusableMethods.ddmIndex(kuponOlusturmaPage.discountTypeDropDown,0);
        //Coupon Amount kısmına girilir
        //Coupon expiry date seçilir
        kuponOlusturmaPage.couponAmount.
                sendKeys(Keys.BACK_SPACE,ConfigReader.
                        getProperty("kuponAmount%"),Keys.TAB,ConfigReader.getProperty("kuponAmaount"));
        //Allow Free Shipping ve Show on Store işaretlenir
        ReusableMethods.click(kuponOlusturmaPage.allowFreeShipping);
        ReusableMethods.bekle(1);
        ReusableMethods.click(kuponOlusturmaPage.showOnStore);
        ReusableMethods.bekle(1);
        //SUBMIT butonuna tıklanır
        ReusableMethods.click(kuponOlusturmaPage.submitButton);
        ReusableMethods.visibleWait(kuponOlusturmaPage.kuponSavedText,2);
        // "Coupon Successfully Published." yazısının görüntülendiği doğrulanır
        Assert.assertEquals(kuponOlusturmaPage.kuponSavedText.getText(),"Coupon Successfully Published.");
        // Store manager sayfası açılır Edit Coupon bölümünde Discount Type olarak "Percentage discount"
        //yazısının görüntülendiği doğrulanır
        System.out.println(kuponOlusturmaPage.kuponTypeSonucText.getText());
        Assert.assertEquals(kuponOlusturmaPage.kuponTypeSonucText.getText(),"Percentage discount");
        Driver.closeDriver();


    }
}
