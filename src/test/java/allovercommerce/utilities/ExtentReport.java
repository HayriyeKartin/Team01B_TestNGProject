package allovercommerce.utilities;

import allovercommerce.pages.VendorPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ExtentReport {

    VendorPage vendorPage = new VendorPage();
    ExtentHtmlReporter htmlReporter;

    ExtentReports extent;
    //helps to generate the logs in the test report.
    ExtentTest extentTest;

    @BeforeTest
    public void startReport() {
        // initialize the HtmlReporter
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/"+date+"htmlReport.html";
        htmlReporter = new ExtentHtmlReporter(path);

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        //configuration items to change the look and feel
        //add content, manage tests etc

        htmlReporter.config().setDocumentTitle("Team02 TestNG");
        htmlReporter.config().setReportName("Team02 TestNG Project");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("Test Automation Engineer","Rıdvan Özdemir");
        extent.setSystemInfo("Test Automation Engineer","Hayriye Kartın");
        extent.setSystemInfo("Test Automation Engineer","Fatih Yavuz");
        extent.setSystemInfo("Test Automation Engineer","Şeyma Bilgin");
        extent.setSystemInfo("Test Automation Engineer","Gülsüm Baltacı");
        extent.setSystemInfo("Test Automation Engineer","Asiye Atak");
    }

    @Test(priority = 1)
    public void VendorCanSeeProductSelect() {
        extentTest = extent.createTest("US14-TCO1 Product seçenekleri görüntülenmeli", "Test passed");
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");
        ReusableMethods.click(vendorPage.signInButton);
        extentTest.info("Kullanıcı Sign In butonuna tıklar");
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        vendorPage.signInButton2.click();
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");
        ReusableMethods.click(vendorPage.storeManagerButton);
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");
        ReusableMethods.click(vendorPage.addNewButton);
        extentTest.info("Kullanıcı Add New butonuna tıklar");
        ReusableMethods.click(vendorPage.productSelect);
        extentTest.info("Kullanıcı Simple Product seçeneğine tıklar");
        List<String> actualSelectBox = ReusableMethods.ddmAllText(vendorPage.productSelect);
        List<String> expectedSelectBox = new ArrayList<>();
        expectedSelectBox.add("Simple Product");
        expectedSelectBox.add("Variable Product");
        expectedSelectBox.add("Grouped Product");
        expectedSelectBox.add("External/Affiliate Product");
        Assert.assertEquals(actualSelectBox, expectedSelectBox);
        extentTest.pass("Simple Product, Variable Product, " +
                "Grouped Product, External-Affiliate Product) seçeneklerini görüntülendiği doğrulanır");
    }


    @Test(priority = 2)
    public void VendorCanAddProductImage() throws IOException {
        extentTest = extent.createTest("US14-TCO2 Ürün fotoğrafı eklenebilmeli", "Test passed");
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");
        extentTest.info("Kullanıcı Sign In butonuna tıklar");
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");
        ReusableMethods.click(vendorPage.storeManagerButton);
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");
        ReusableMethods.click(vendorPage.addNewButton);
        extentTest.info("Kullanıcı Add New butonuna tıklar");
        ReusableMethods.click(vendorPage.productImage);
        extentTest.info("Kullanıcı image alanına tıklar");
        vendorPage.productSelectFiles.click();
        //"C:\Users\Hayriye\IdeaProjects\AsusVivoBook.jpg"
        String dosyaYolu = System.getProperty("user.home") + "\\IdeaProjects\\AsusVivoBook.PNG";
        ReusableMethods.uploadFilePath(dosyaYolu);
        extentTest.info("Kullanıcı açılan sayfaya ürün fotoğrafını yükler");
        ReusableMethods.click(vendorPage.photoAddSelectButton);
        extentTest.info("Kullanıcı select butonuna tıklar");
        String actualResult = ReusableMethods.getStringValueByJS("featured_img_display", "class");
        String expectedResult = "";
        Assert.assertNotEquals(actualResult, expectedResult);
        extentTest.pass("Ürün fotoğrafının başarılı bir şekilde eklendiği doğrulanır");
        ReusableMethods.bekle(3);

        ReusableMethods.screenShot("VendorCanAddProductImage");
    }

    @Test(priority = 3)
    public void VendorCanWriteTitleAndDescription() {
        extentTest = extent.createTest("US14-TCO3 Product Title, Short Description ve Description yazılabilmeli", "Test passed");
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");
        extentTest.info("Kullanıcı Sign In butonuna tıklar");
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");
        vendorPage.productTitle.sendKeys(ConfigReader.getProperty("productTitle"));
        extentTest.info("Kullanıcı Product Title alanına veri girer");
        Driver.getDriver().switchTo().frame(0);
        vendorPage.shortDescription.sendKeys(ConfigReader.getProperty("shortDescription"));
        extentTest.info("Kullanıcı Short Description alanına veri girer");
        Assert.assertTrue(vendorPage.shortDescription.isDisplayed());
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("Short Description alanına veri girildiği doğrulanır");
        Driver.getDriver().switchTo().frame(1);
        vendorPage.description.sendKeys(ConfigReader.getProperty("description"));
        extentTest.info("Kullanıcı Description alanına veri girer");
        Assert.assertTrue(vendorPage.description.isDisplayed());
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("Description alanına veri girildiği doğrulanır");
    }

    @Test(priority = 4)
    public void VendorCanSelectCategories() {
        extentTest = extent.createTest("US14-TCO4 Categories seçilebilmeli", "Test passed");
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");
        extentTest.info("Kullanıcı Sign In butonuna tıklar");
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");
        ReusableMethods.click(vendorPage.categoriesSelect);
        extentTest.info("Kullanıcı Categories alanından bir kategori seçer");
        Assert.assertTrue(vendorPage.categoriesSelect.isSelected());
        extentTest.pass("Kategori seçiminin yapıldığı doğrulanır");
    }

    @Test(priority = 5)
    public void VendorCanAddNewCategories() {
        extentTest = extent.createTest("US14-TCO5 Yeni Categories eklenebilmeli", "Test passed");
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");
        extentTest.info("Kullanıcı Sign In butonuna tıklar");
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");
        ReusableMethods.click(vendorPage.addNewCategoryButton);
        vendorPage.categoryNameBox.sendKeys(ConfigReader.getProperty("newCategories"));
        ReusableMethods.click(vendorPage.categoryAddButton);
        extentTest.info("Kullanıcı yeni bir kategori ekler");
        Assert.assertTrue(vendorPage.newCategory.isDisplayed());
        extentTest.pass("Yeni bir kategori eklendiği doğrulanır");

    }

    @Test(priority = 6)
    public void VendorCanSelectProductBrands() {
        extentTest = extent.createTest("US14-TCO6 Product brands seçilebilmeli", "Test passed");
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");
        extentTest.info("Kullanıcı Sign In butonuna tıklar");
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");
        ReusableMethods.click(vendorPage.storeManagerButton);
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");
        ReusableMethods.click(vendorPage.productBrandsSelect);
        extentTest.info("Kullanıcı Product Brands alanından bir marka seçer");
        Assert.assertTrue(vendorPage.productBrandsSelect.isSelected());
        extentTest.pass("Product Brands seçildiği doğrulanır");

    }

    @Test(priority = 7)
    public void vendorCanAddNewProductBrands() {
        extentTest = extent.createTest("US14-TCO7 Yeni Product brands eklenebilmeli", "Test passed");
        extentTest.info("Kullanıcı allovercommerce sayfasına gider");
        extentTest.info("Kullanıcı Sign In butonuna tıklar");
        extentTest.info("Kullanıcı kayıtlı username ve password ile Vendor girişi yapar");
        ReusableMethods.click(vendorPage.vendorMyAccount);
        extentTest.info("Kullanıcı My Account yazısına tıklar");
        vendorPage.storeManagerButton.click();
        extentTest.info("Kullanıcı Store Manager butonuna tıklar");
        ReusableMethods.click(vendorPage.productsButton);
        extentTest.info("Kullanıcı Products butonuna tıklar");
        vendorPage.addNewButton.click();
        extentTest.info("Kullanıcı Add New butonuna tıklar");
        ReusableMethods.click(vendorPage.addNewProductBrands);
        vendorPage.productBrandsNameBox.sendKeys(ConfigReader.getProperty("newProductBrands"));
        extentTest.info("Kullanıcı yeni bir Product Brands ekler");
        ReusableMethods.click(vendorPage.productBrandsAddButton);
        Assert.assertTrue(vendorPage.newProductBrands.isDisplayed());
        extentTest.pass("Yeni Product Brands eklendiği doğrulanır");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, result.getTestName());
        }
        else {
            extentTest.log(Status.SKIP, result.getTestName());
        }
    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }
}

