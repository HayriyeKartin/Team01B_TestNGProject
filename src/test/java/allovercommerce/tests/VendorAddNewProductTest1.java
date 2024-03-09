package allovercommerce.tests;

import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static allovercommerce.utilities.ReusableMethods.extentReports;
import static allovercommerce.utilities.ReusableMethods.extentTest;

public class VendorAddNewProductTest1 {

    //US14 Vendor olarak ürün ekleme seçeneklerini görebilmeli 1
    //(My Account - Store Manager - Product - Add New)
    VendorPage vendorPage = new VendorPage();
    @Test
    public void VendorCanSeeProductSelect() {
        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO1 Product seçenekleri görüntülenmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");

        //Sıgn In butonuna tıklanır
        ReusableMethods.click(vendorPage.signInButton);
        extentTest.info("Kullanıcı Sign In butonuna tıklar");

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");

        //Sol menüde yer alan Store Manager butonuna tıklanır
        ReusableMethods.click(vendorPage.storeManagerButton);
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");

        //Add New butonuna tıklanır
        ReusableMethods.click(vendorPage.addNewButton);
        extentTest.info("Kullanıcı Add New butonuna tıklar");

        //Simple Product yazısına tıklanır
        ReusableMethods.click(vendorPage.productSelect);
        extentTest.info("Kullanıcı Simple Product seçeneğine tıklar");

        //Açılan menüde; Simple Product, Variable Product, Grouped Product, External-Affiliate Product seçeneklerinin
        //görüntülendiği doğrulanır
        List<String> actualSelectBox = ReusableMethods.ddmAllText(vendorPage.productSelect);
        List<String> expectedSelectBox = new ArrayList<>();
        expectedSelectBox.add("Simple Product");
        expectedSelectBox.add("Variable Product");
        expectedSelectBox.add("Grouped Product");
        expectedSelectBox.add("External/Affiliate Product");
        Assert.assertEquals(actualSelectBox, expectedSelectBox);
        extentTest.pass("Simple Product, Variable Product, " +
                "Grouped Product, External-Affiliate Product) seçeneklerini görüntülendiği doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }

    @Test
    public void VendorCanAddProductImage() throws AWTException {
        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO2 Ürün fotoğrafı eklenebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");

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
        extentTest.info("Kullanıcı My Account yazısına tıklar");

        //Sol menüde yer alan Store Manager butonuna tıklanır
        ReusableMethods.click(vendorPage.storeManagerButton);
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");

        //Add New butonuna tıklanır
        ReusableMethods.click(vendorPage.addNewButton);
        extentTest.info("Kullanıcı Add New butonuna tıklar");

        //Açılan sayfada image alanına tıklanır
        ReusableMethods.click(vendorPage.productImage);
        extentTest.info("Kullanıcı image alanına tıklar");

        //Açılan "Upload Files" sayfasına ürünün fotoğrafı yüklenir
        vendorPage.productSelectFiles.click();
        //"C:\Users\Hayriye\IdeaProjects\AsusVivoBook.jpg"
        String dosyaYolu = System.getProperty("user.home") + "\\IdeaProjects\\AsusVivoBook.PNG";
        ReusableMethods.uploadFilePath(dosyaYolu);
        extentTest.info("Kullanıcı açılan sayfaya ürün fotoğrafını yükler");

        //Select butonuna tıklanır
        ReusableMethods.click(vendorPage.photoAddSelectButton);
        extentTest.info("Kullanıcı select butonuna tıklar");
        ReusableMethods.bekle(3);
        ReusableMethods.screenShot("VendorCanAddProductImage");

        //Ürün fotoğrafının eklendiği doğrulanır
        String actualResult = ReusableMethods.getStringValueByJS("featured_img_display", "class");
        String expectedResult = "";
        Assert.assertNotEquals(actualResult, expectedResult);
        extentTest.pass("Ürün fotoğrafının başarılı bir şekilde eklendiği doğrulanır");
        extentReports.flush();
        Driver.closeDriver();
    }

    @Test
    public void VendorCanWriteTitleAndDescription() {

        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO3 Product Title, Short Description ve Description yazılabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");

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
        extentTest.info("Kullanıcı My Account yazısına tıklar");

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");

        //Product Title kutucuğuna veri girilir
        vendorPage.productTitle.sendKeys(ConfigReader.getProperty("productTitle"));
        extentTest.info("Kullanıcı Product Title alanına veri girer");

        //Short Description alanına veri girilir
        Driver.getDriver().switchTo().frame(0);
        vendorPage.shortDescription.sendKeys(ConfigReader.getProperty("shortDescription"));
        extentTest.info("Kullanıcı Short Description alanına veri girer");

        //Short Description alanına veri girildiği doğrulanır
        Assert.assertTrue(vendorPage.shortDescription.isDisplayed());
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("Short Description alanına veri girildiği doğrulanır");

        //Description alanına veri girilir
        Driver.getDriver().switchTo().frame(1);
        vendorPage.description.sendKeys(ConfigReader.getProperty("description"));
        extentTest.info("Kullanıcı Description alanına veri girer");

        //Description alanına veri girildiği doğrulanır
        Assert.assertTrue(vendorPage.description.isDisplayed());
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("Description alanına veri girildiği doğrulanır");
        extentReports.flush();

    }

    @Test
    public void VendorCanSelectCategories() {

        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO4 Categories seçilebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");

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
        extentTest.info("Kullanıcı My Account yazısına tıklar");

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");

        //Ürün için bir kategori seçilir
        ReusableMethods.click(vendorPage.categoriesSelect);
        extentTest.info("Kullanıcı Categories alanından bir kategori seçer");

        //Kategori seçildiği doğrulanır
        Assert.assertTrue(vendorPage.categoriesSelect.isSelected());
        extentTest.pass("Kategori seçiminin yapıldığı dorulanır");
        extentReports.flush();

    }

    @Test
    public void VendorCanAddNewCategories() {

        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO5 Yeni Categories eklenebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");

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
        extentTest.info("Kullanıcı My Account yazısına tıklar");

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");

        //Yeni bir kategori eklenir
        ReusableMethods.click(vendorPage.addNewCategoryButton);
        vendorPage.categoryNameBox.sendKeys(ConfigReader.getProperty("newCategories"));
        ReusableMethods.click(vendorPage.categoryAddButton);
        extentTest.info("Kullanıcı yeni bir kategori ekler");

        //Kategori eklendiği doğrulanır
        Assert.assertTrue(vendorPage.newCategory.isDisplayed());
        extentTest.pass("Yeni bir kategori eklendiği doğrulanır");
        extentReports.flush();

    }

    @Test
    public void VendorCanSelectProductBrands() {

        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO6 Product brands seçilebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");

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
        extentTest.info("Kullanıcı My Account yazısına tıklar");

        //Sol menüde yer alan Store Manager butonuna tıklanır
        ReusableMethods.click(vendorPage.storeManagerButton);
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");

        //Product brands seçilir
        ReusableMethods.click(vendorPage.productBrandsSelect);
        extentTest.info("Kullanıcı Product Brands alanından bir marka seçer");

        //Product brands seçildiği doğrulanır
        Assert.assertTrue(vendorPage.productBrandsSelect.isSelected());
        extentTest.pass("Product Brands seçildiği doğrulanır");
        extentReports.flush();

    }

    @Test
    public void vendorCanAddNewProductBrands() {

        //Kullanıcı Web sitesine gider
        ReusableMethods.createExtentReport("US14-TCO7 Yeni Product brands eklenebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");

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
        extentTest.info("Kullanıcı My Account yazısına tıklar");

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");

        //Yeni bir Product brands eklenir
        ReusableMethods.click(vendorPage.addNewProductBrands);
        vendorPage.productBrandsNameBox.sendKeys(ConfigReader.getProperty("newProductBrands"));
        extentTest.info("Kullanıcı yeni bir Product Brands ekler");

        //Product brans eklendiği doğrulanır
        ReusableMethods.click(vendorPage.productBrandsAddButton);
        Assert.assertTrue(vendorPage.newProductBrands.isDisplayed());
        extentTest.pass("Yeni Product Brands eklendiği doğrulanır");
        extentReports.flush();
    }
}
