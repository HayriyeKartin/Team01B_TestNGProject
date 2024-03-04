package allovercommerce.tests;

import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VendorShippingAddressTest {

    @Test
    public void vendorCanAddShippingAddress() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        VendorPage vendorPage = new VendorPage();
        vendorPage.signInButton.click();

        //Kayıtlı username ve password girilir Sıgn In olunur
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Addreses butonuna tıklanır
        ReusableMethods.click(vendorPage.myAccountAddressesButton);

        //'Shipping Address' altında bulunan ADD butonuna tıklanır
        ReusableMethods.click(vendorPage.billingAddButton);

        //First name alanına geçerli bir değer girilir
        vendorPage.billingFirstName.sendKeys("Aslı");

        //Last name alanına geçerli bir değer girilir
        vendorPage.billingLastName.sendKeys("Kılıç");

        //Company name (optional) alanına geçerli bir değer girilir
        vendorPage.billingCompanyName.sendKeys("Kılıçlar");

        //Country/Region alanına geçerli bir değer girilir
        ReusableMethods.ddmVisibleText(vendorPage.billingCountryRegion, "Turkey");

        //Street address alanına geçerli bir değer girilir
        vendorPage.billingStreetAddress.sendKeys("Göksu Sok.");

        //Apartment alanına geçerli bir değer girilir
        vendorPage.billingApartment.sendKeys("İnci Apt.");

        //ZIP Code alanına geçerli bir değer girilir
        vendorPage.billingPostCode.sendKeys("06820");

        //Town/City alanına geçerli bir değer girilir
        vendorPage.billingTownCity.sendKeys("Eryaman");

        //Province alanına geçerli bir değer girilir
        ReusableMethods.ddmVisibleText(vendorPage.billingStateProvince, "Ankara");

        //Phone alanına geçerli bir değer giriniz
        vendorPage.billingPhone.sendKeys("05051005050");

        //"""Save Address"" butonuna tıklanır"
        ReusableMethods.click(vendorPage.billingSaveAddressButton);

        //"Address changed successfully." mesajının görüntülendiğini doğrulanır"
        //Address changed successfully.
        ReusableMethods.bekle(3);
        String actualMessageText = vendorPage.billingAlertText.getText();
        Assert.assertEquals(actualMessageText, "Address changed successfully.");

    }

    @Test
    public void vendorCanAddShippingAddressNegative() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        VendorPage vendorPage = new VendorPage();
        vendorPage.signInButton.click();

        //Kayıtlı username ve password girilir Sıgn In olunur
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorNegativeFakeUserName"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorNegativeFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Addreses butonuna tıklanır
        ReusableMethods.click(vendorPage.myAccountAddressesButton);

        //'Shipping Address' altında bulunan ADD butonuna tıklanır
        ReusableMethods.click(vendorPage.billingAddButton);

        //First name alanına geçerli bir değer girilir
        vendorPage.billingFirstName.sendKeys("Ayşe");

        //Last name alanı boş bırakılır

        //Company name (optional) alanına geçerli bir değer girilir
        vendorPage.billingCompanyName.sendKeys("Yılmazlar");

        //Country/Region alanına geçerli bir değer girilir
        ReusableMethods.ddmVisibleText(vendorPage.billingCountryRegion, "Turkey");

        //Street address alanına geçerli bir değer girilir
        vendorPage.billingStreetAddress.sendKeys("Altay Sok.");

        //Apartment alanına geçerli bir değer girilir
        vendorPage.billingApartment.sendKeys("Zümrüt Apt.");

        //ZIP Code alanına geçerli bir değer girilir
        vendorPage.billingPostCode.sendKeys("06580");

        //Town/City alanına geçerli bir değer girilir
        vendorPage.billingTownCity.sendKeys("Etimesgut");

        //Province alanına geçerli bir değer girilir
        ReusableMethods.ddmVisibleText(vendorPage.billingStateProvince, "Ankara");

        //Phone alanına geçerli bir değer giriniz
        vendorPage.billingPhone.sendKeys("05051005050");

        //"""Save Address"" butonuna tıklanır"
        ReusableMethods.click(vendorPage.billingSaveAddressButton);

        //"Last name is a required field." mesajının görüntülendiği doğrulanır
        ReusableMethods.bekle(3);
        String actualMessageText = vendorPage.billingLastNameAlertText.getText();
        Assert.assertEquals(actualMessageText, "Last name is a required field.");

    }
}
