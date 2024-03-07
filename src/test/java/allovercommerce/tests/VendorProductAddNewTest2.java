package allovercommerce.tests;

import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VendorProductAddNewTest2 {

    VendorPage vendorPage = new VendorPage();

    @BeforeMethod
    public void beforeTest(){

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
    }
    @Test
    public void VendorCanSeeMenus() { //Inventory, Shipping, Attributes, Linked, Seo, Advanced menüleri görülebilmeli

        //Inventory, Shipping, Attributes, Linked, Seo, Advanced menülerinin görüntülendiği doğrulanır
        ReusableMethods.scroll(vendorPage.inventoryMenuButton);
        Assert.assertTrue(vendorPage.inventoryMenuButton.isDisplayed());
        Assert.assertTrue(vendorPage.shippingMenuButton.isDisplayed());
        Assert.assertTrue(vendorPage.attributesMenuButton.isDisplayed());
        Assert.assertTrue(vendorPage.linkedMenuButton.isDisplayed());
        Assert.assertTrue(vendorPage.seoMenuButton.isDisplayed());
        Assert.assertTrue(vendorPage.advancedMenuButton.isDisplayed());

    }
    @Test
    public void vendorCanMakeInventoryTransactions() { //Inventory işlemleri yapılabilmeli (SKU, Manage Stock, Stock status, Sold Individually)

        //Sayfanın alt bölümünde bulunan menüde Inventory butonuna tıklanır
        ReusableMethods.click(vendorPage.inventoryMenuButton);

        //Inventory işlemleri yapılabilmeli  (SKU, Manage Stock, Stock status, Sold Individually)
        vendorPage.stockCode.sendKeys("PC-ASUS-X1502ZA-EJ1645");
        ReusableMethods.setAttributeJS(vendorPage.stockCodeAttributeValue, "PC-ASUS-X1502ZA-EJ1645");
        String actualValueText = vendorPage.stockCode.getAttribute("value");
        Assert.assertEquals(actualValueText, "PC-ASUS-X1502ZA-EJ1645");


        ReusableMethods.click(vendorPage.manageStock);
        vendorPage.stockQty.sendKeys(Keys.DELETE, "1");

        ReusableMethods.ddmValue(vendorPage.allowBackorders, "no");
        ReusableMethods.click(vendorPage.manageStock);

        ReusableMethods.ddmValue(vendorPage.stockStatus, "onbackorder");
        ReusableMethods.click(vendorPage.soldIndividually);

    }
    @Test
    public void vendorCanMakeShippingTransactions() { //Shipping işlemleri yapılabilmeli (Weight, Dimensions, Shipping class, Processing Time)

        //Sayfanın alt bölümünde bulunan menüde Shipping butonuna tıklanır
        ReusableMethods.click(vendorPage.shippingMenuButton);

        //Weight(kg) kutucuğuna geçerli bir değer girilir
        vendorPage.shippingWeight.sendKeys("2");

        //Dimensions(cm) kutucuklarına geçerli değerler girilir
        vendorPage.dimensionsLength.sendKeys("33");
        vendorPage.dimensionsWidth.sendKeys("18");
        vendorPage.dimensionsHeight.sendKeys("2");

        //Shipping Class'ta default değerin seçili olduğu doğrulanır
        Assert.assertTrue(vendorPage.shippingClass.isDisplayed());

        //Processing Time menüsünden seçim yapılabildiği doğrulanır
        ReusableMethods.ddmValue(vendorPage.processingTime, "3");
        Assert.assertTrue(vendorPage.processingTime.getText().contains("1-3 business days"));

    }
    @Test
    public void vendorCanMakeAttributesTransactions() { //Attributes işlemleri yapılabilmeli (Color, Size)

        //Sayfanın alt bölümünde bulunan menüde Attributes butonuna tıklanır
        ReusableMethods.click(vendorPage.attributesMenuButton);

        //Color checkbox'a tıklanır
        ReusableMethods.click(vendorPage.colorCheckbox);

        //Seçim menüsünden bir renk seçilir ve görüntülendiği doğrulanır
        ReusableMethods.ddmVisibleText(vendorPage.colorAttributeSelect, "Inkwell Gray");
        Assert.assertTrue(vendorPage.colorAttributeSelect.getText().contains("Inkwell Gray"));

        //Size checkbox'a tıklanır
        ReusableMethods.click(vendorPage.sizeCheckbox);

        //Seçim menüsünden ürünün boyutu seçilir ve görüntülendiği doğrulanır
        ReusableMethods.ddmValue(vendorPage.sizeAttributeSelect, "1377");
        Assert.assertTrue(vendorPage.sizeAttributeSelect.getText().contains("31.35"));
    }
}
