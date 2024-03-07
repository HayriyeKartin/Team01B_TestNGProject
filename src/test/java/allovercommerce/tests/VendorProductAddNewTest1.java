package allovercommerce.tests;

import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static allovercommerce.utilities.ReusableMethods.extentTest;

public class VendorProductAddNewTest1 {

    VendorPage vendorPage = new VendorPage();
    @Test
    public void test01() {

        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO1 Product seçenekleri görüntülenmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanici allovercommerce sayfasına gider");

        //Sıgn In butonuna tıklanır
        vendorPage.signInButton.click();
        extentTest.info("Kullanıcı Sign In butonuna tıklar");

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();

        //Simple Product yazısına tıklanır
        vendorPage.productSelect.click();

        //Açılan menüde; Simple Product, Variable Product, Grouped Product, External-Affiliate Product seçeneklerinin
        //görüntülendiği doğrulanır
        List<String> actualSelectBox = ReusableMethods.ddmAllText(vendorPage.productSelect);
        List<String> expectedSelectBox = new ArrayList<>();
        expectedSelectBox.add("Simple Product");
        expectedSelectBox.add("Variable Product");
        expectedSelectBox.add("Grouped Product");
        expectedSelectBox.add("External/Affiliate Product");
        Assert.assertEquals(actualSelectBox, expectedSelectBox);
    }

    @Test
    public void test02() throws AWTException {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        vendorPage.signInButton.click();

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        ReusableMethods.click(vendorPage.storeManagerButton);

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();

        //Açılan sayfada image alanına tıklanır
        ReusableMethods.click(vendorPage.productImage);

        //Açılan "Upload Files" sayfasına ürünün fotoğrafı yüklenir
        vendorPage.productSelectFiles.click();
        //"C:\Users\Hayriye\IdeaProjects\AsusVivoBook.jpg"
        String dosyaYolu = System.getProperty("user.home") + "\\IdeaProjects\\AsusVivoBook.PNG";
        ReusableMethods.uploadFilePath(dosyaYolu);

        //Select butonuna tıklanır
        ReusableMethods.click(vendorPage.photoAddSelectButton);

        //Ürün fotoğrafının eklendiği doğrulanır
        String actualResult = ReusableMethods.getStringValueByJS("featured_img_display", "class");
        String expectedResult = "";
        Assert.assertNotEquals(actualResult, expectedResult);

    }

    @Test
    public void test03() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        vendorPage.signInButton.click();

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();

        //Product Title kutucuğuna veri girilir
        vendorPage.productTitle.sendKeys(ConfigReader.getProperty("productTitle"));

        //Short Description alanına veri girilir
        Driver.getDriver().switchTo().frame(0);
        vendorPage.shortDescription.sendKeys(ConfigReader.getProperty("shortDescription"));

        //Short Description alanına veri girildiği doğrulanır
        Assert.assertTrue(vendorPage.shortDescription.isDisplayed());
        Driver.getDriver().switchTo().defaultContent();

        //Description alanına veri girilir
        Driver.getDriver().switchTo().frame(1);
        vendorPage.description.sendKeys(ConfigReader.getProperty("description"));

        //Description alanına veri girildiği doğrulanır
        Assert.assertTrue(vendorPage.description.isDisplayed());
        Driver.getDriver().switchTo().defaultContent();

    }

    @Test
    public void test04() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        vendorPage.signInButton.click();

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();

        //Ürün için bir kategori seçilir
        ReusableMethods.click(vendorPage.categoriesSelect);

        //Kategori seçildiği doğrulanır
        Assert.assertTrue(vendorPage.categoriesSelect.isSelected());

    }

    @Test
    public void test05() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        vendorPage.signInButton.click();

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();

        //Yeni bir kategori eklenir
        ReusableMethods.click(vendorPage.addNewCategoryButton);
        vendorPage.categoryNameBox.sendKeys(ConfigReader.getProperty("newCategories"));
        ReusableMethods.click(vendorPage.categoryAddButton);

        //Kategori eklendiği doğrulanır
        Assert.assertTrue(vendorPage.newCategory.isDisplayed());

    }

    @Test
    public void test06() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        vendorPage.signInButton.click();

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        ReusableMethods.click(vendorPage.storeManagerButton);

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();

        //Product brands seçilir
        ReusableMethods.click(vendorPage.productBrandsSelect);

        //Product brands seçildiği doğrulanır
        Assert.assertTrue(vendorPage.productBrandsSelect.isSelected());

    }

    @Test
    public void test07() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        vendorPage.signInButton.click();

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();

        //Yeni bir Product brands eklenir
        ReusableMethods.click(vendorPage.addNewProductBrands);
        vendorPage.productBrandsNameBox.sendKeys(ConfigReader.getProperty("newProductBrands"));

        //Product brans eklendiği doğrulanır
        ReusableMethods.click(vendorPage.productBrandsAddButton);
        Assert.assertTrue(vendorPage.newProductBrands.isDisplayed());

    }

}
