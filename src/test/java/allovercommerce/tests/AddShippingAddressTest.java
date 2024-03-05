package allovercommerce.tests;

import allovercommerce.pages.AddShippingAddressPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddShippingAddressTest {

    AddShippingAddressPage addShippingAddressPage = new AddShippingAddressPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        //Sayfaya gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sign In butonuna tiklanir
        ReusableMethods.click(addShippingAddressPage.signInButton);

        //Username ve password alanina gecerli datalar girilir
        addShippingAddressPage.userNameOrEmailAddressBox.sendKeys(ConfigReader.getProperty("userNameOrEmailAddress"));
        addShippingAddressPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));

        //SIGN IN butonuna tiklanir
        ReusableMethods.click(addShippingAddressPage.loginSignInButton);

        //Sayfanin en altinda bulunan My Account butonuna tiklanir
        ReusableMethods.click(addShippingAddressPage.myAccountButton);

        //Acilan My Account sayfasinda solda bulunan Addresses butonuna tiklanir
        ReusableMethods.click(addShippingAddressPage.addressesButton);

        //Shipping Address bolumu altinda bulunan ADD butonuna tiklanir
        ReusableMethods.click(addShippingAddressPage.addButton);

        //Acilan sayfada zorunlu alanlar doldurulur ve SAVE ADDRESS butonuna tiklanir
        addShippingAddressPage.deleteMethod(addShippingAddressPage.firstNameBox);
        addShippingAddressPage.firstNameBox.sendKeys(faker.name().firstName());

        addShippingAddressPage.deleteMethod(addShippingAddressPage.lastNameBox);
        addShippingAddressPage.lastNameBox.sendKeys(faker.name().lastName());

        ReusableMethods.ddmValue(addShippingAddressPage.countryRegionBox, "US");
        addShippingAddressPage.deleteMethod(addShippingAddressPage.streetAddressBox);
        addShippingAddressPage.streetAddressBox.sendKeys(faker.address().streetAddress());

        addShippingAddressPage.deleteMethod(addShippingAddressPage.townCityBox);
        addShippingAddressPage.townCityBox.sendKeys(faker.address().city());

        ReusableMethods.ddmValue(addShippingAddressPage.stateBox, "NY");

        addShippingAddressPage.deleteMethod(addShippingAddressPage.zipCodeBox);
    }

    @Test
    public void addShippingAddress() {

        addShippingAddressPage.zipCodeBox.sendKeys(faker.address().zipCode());

        ReusableMethods.click(addShippingAddressPage.saveAddressButton);

        //Address changed successfully. mesajinin goruldugu dogrulanir
        Assert.assertTrue(addShippingAddressPage.addressChangedSuccessfullyMessage.isDisplayed());

        ReusableMethods.click(addShippingAddressPage.signOutButton);
        ReusableMethods.click(addShippingAddressPage.logOutButton);

        //Sayfa kapatilir
        //Driver.closeDriver();
    }

    @Test
    public void addShippingAddressNegatif() {
        ReusableMethods.click(addShippingAddressPage.saveAddressButton);

        // ...is a required field. mesaji gorulur ve adres ekleme isleminin gerceklesmedigi dogrulanir
        Assert.assertTrue(addShippingAddressPage.isARequiredFieldMessage.isDisplayed());

        //Sayfa kapatilir (class seviyesinde test yaparken sadece son calisan testte bu aktif olmali yoksa hata veriyor!!)
        Driver.closeDriver();
    }

}
