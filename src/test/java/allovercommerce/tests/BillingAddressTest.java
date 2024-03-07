package allovercommerce.tests;

import allovercommerce.pages.BillingAddressPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillingAddressTest {

    BillingAddressPage billingAddressPage = new BillingAddressPage();
    Faker faker = new Faker();

    @Test
    public void testBillingAddress() {
//Web sitesine gidilir ve SingIn butonuna tıklanır.
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        billingAddressPage.userSingInButton.click();
// Siteye daha önce kayıtlı bilgilerle giriş yapar ve singIn butonuna tıklar

        billingAddressPage.userName.sendKeys(ConfigReader.getProperty("costumerEmail"));
        billingAddressPage.password.sendKeys(ConfigReader.getProperty("costumerPassword"));
        billingAddressPage.getSignInLoginSignIn.click();
        //Billing Address, ADD butonu tıkLar
        billingAddressPage.signOutdakiMyAccount.click();
        billingAddressPage.Adresbutonu.click();
        billingAddressPage.Addbutonu.click();
//Country/Region, Street address, Town / City, State, ZIP Code ve Phone bigilerini girer
        billingAddressPage.userBillingAdressFirsName.clear();
        billingAddressPage.userBillingAdressFirsName.sendKeys(faker.name().firstName());
        billingAddressPage.userBillingAdressLastName.clear();
        billingAddressPage.userBillingAdressLastName.sendKeys(faker.name().lastName());
        billingAddressPage.userBillingAdressCompanyName.clear();
        billingAddressPage.userBillingAdressCompanyName.sendKeys(faker.name().name());
        ReusableMethods.ddmVisibleText(billingAddressPage.userBillingAdressCountry,"Turkey");
        billingAddressPage.userBillingStreetAdress1.clear();
        billingAddressPage.userBillingStreetAdress1.sendKeys(faker.address().streetAddress());
        billingAddressPage.userBillingStreetAdres2.clear();
        billingAddressPage.userBillingStreetAdres2.sendKeys(faker.address().streetAddress());
        billingAddressPage.userBillingAdressTown.clear();
        billingAddressPage.userBillingAdressTown.sendKeys(faker.address().city());
        billingAddressPage.userBillinZıpCode.clear();
        billingAddressPage.userBillinZıpCode.sendKeys(faker.address().zipCode());
        ReusableMethods.ddmVisibleText(billingAddressPage.userBillingAdressState,"Trabzon");
        billingAddressPage.userBillingAdressPhone.clear();
        billingAddressPage.userBillingAdressPhone.sendKeys(faker.phoneNumber().cellPhone());
        //Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) ekler
        ReusableMethods.click(billingAddressPage.userBillingAdressSaveAdressButton);

        //Save Address butonuba tıklandığında "Address changed successfully." metni görülmeli
        ReusableMethods.scroll(billingAddressPage.billingAddressChangedSuccessfullyMesaji);
        Assert.assertEquals(billingAddressPage.billingAddressChangedSuccessfullyMesaji.getText(),"Address changed successfully.");


        //Güncelleme işlemleri için Edit your Billing Address butonu tıklanabilmeli.
        //Eklenen kullanıcı bilgileri görülmeli ve güncellenebilmeli.
        billingAddressPage.billingEDITYOURBILLINGADDRESSButonu.click();


        //Email adresi otomatik olarak gelmeli
        ReusableMethods.bekle(3);
        ReusableMethods.scroll(billingAddressPage.scrollEmail);
        Assert.assertTrue(billingAddressPage.billingEmail.isDisplayed());
        ReusableMethods.bekle(3);


    }

}
