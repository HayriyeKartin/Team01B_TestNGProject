package allovercommerce.tests;

import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VendorSimpleProductTest {

    @Test
    public void vendorCanAddSimpleProduct() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        VendorPage vendorPage = new VendorPage();
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

        //"Simple Product" ın default olarak geldiği doğrulanır
        String simpleProductText = vendorPage.simpleProductFirstSelect.getText();
        Assert.assertEquals(simpleProductText, "Simple Product");

        //Virtual ve Downloadable checkbox'ları seçilir
        ReusableMethods.click(vendorPage.virtualCheckbox);
        ReusableMethods.click(vendorPage.downloadableCheckbox);

        //Price ve Sale Price kutucuklarına veri girilir
        vendorPage.priceBox.sendKeys(ConfigReader.getProperty("price"));
        vendorPage.salePriceBox.sendKeys(ConfigReader.getProperty("salePrice"));

        //Product Title kutucuğuna veri girilir
        vendorPage.productTitle.sendKeys(ConfigReader.getProperty("productTitle"));

        //Kategori seçilir
        ReusableMethods.click(vendorPage.categoriesSelect);

        //Ürünün Product kısmında görüntülendiği doğrulanır





    }
}
