package allovercommerce.tests;

import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class VendorAddSimpleProductTest {

    //US16 Vendor olarak Simple Product ekleyebilmeliyim
    @Test
    public void vendorCanAddSimpleProduct() {

        //Kullanıcı Web sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        //Sıgn In butonuna tıklanır
        VendorPage vendorPage = new VendorPage();
        ReusableMethods.bekle(1);
        vendorPage.signInButton.click();

        //Kayıtlı username ve password ile Vendor girişi yapılır
        vendorPage.signInUsername.sendKeys(ConfigReader.getProperty("vendorFakeUsername"));
        vendorPage.signInPassword.sendKeys(ConfigReader.getProperty("vendorFakePassword"));
        ReusableMethods.bekle(1);
        vendorPage.signInButton2.click();

        //Footer bölümünde bulunan My Account yazısına tıklanır
        ReusableMethods.click(vendorPage.vendorMyAccount);
        ReusableMethods.bekle(2);

        //Sol menüde yer alan Store Manager butonuna tıklanır
        vendorPage.storeManagerButton.click();
        ReusableMethods.bekle(2);

        //Sol menüde yer alan Products butonuna tıklanır
        ReusableMethods.click(vendorPage.productsButton);
        ReusableMethods.bekle(2);

        //Add New butonuna tıklanır
        vendorPage.addNewButton.click();
        ReusableMethods.bekle(2);

        //Virtual ve Downloadable checkbox'ları seçilir
        ReusableMethods.click(vendorPage.virtualCheckbox);
        ReusableMethods.click(vendorPage.downloadableCheckbox);
        ReusableMethods.bekle(2);

        //Product Title kutucuğuna veri girilir
        vendorPage.productTitle.sendKeys(ConfigReader.getProperty("productTitle"));
        ReusableMethods.bekle(3);

        //Price ve Sale Price kutucuklarına veri girilir
        vendorPage.priceBox.sendKeys(ConfigReader.getProperty("price"));
        vendorPage.salePriceBox.sendKeys(ConfigReader.getProperty("salePrice"));
        ReusableMethods.bekle(3);

        //Ürün fotoğrafı yüklenir
        ReusableMethods.click(vendorPage.productImage);
        vendorPage.productSelectFiles.click();
        String dosyaYolu = System.getProperty("user.home") + "\\IdeaProjects\\AsusVivoBook.PNG";
        ReusableMethods.uploadFilePath(dosyaYolu);
        ReusableMethods.bekle(2);
        ReusableMethods.click(vendorPage.photoAddSelectButton);
        ReusableMethods.bekle(2);

        //Galeriden ürün fotoğrafı seçilir
        ReusableMethods.click(vendorPage.galleryImage);
        ReusableMethods.click(vendorPage.mediaLibraryImage);
        ReusableMethods.bekle(2);
        ReusableMethods.click(vendorPage.addToGalleryButton);
        ReusableMethods.bekle(2);

        //Short DEscription ve Description alanları doldurulur
        Driver.getDriver().switchTo().frame(0);
        vendorPage.shortDescription.sendKeys(ConfigReader.getProperty("shortDescription"));
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.bekle(3);
        Driver.getDriver().switchTo().frame(1);
        vendorPage.description.sendKeys(ConfigReader.getProperty("description"));
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.bekle(3);

        //Ürün için bir kategori seçilir
        ReusableMethods.click(vendorPage.categoriesSelect);
        ReusableMethods.bekle(3);

        //Product brands seçilir
        ReusableMethods.click(vendorPage.productBrandsSelect);
        ReusableMethods.bekle(3);

        //Sayfanın sonunda bulunan Downloadable menüsüne tıklanır
        ReusableMethods.click(vendorPage.downloadableMenuButton);
        ReusableMethods.bekle(2);

        //Name alanına geçerli bir değer
        vendorPage.downloadableNameBox.sendKeys(ConfigReader.getProperty("downloadableProductName"));
        ReusableMethods.bekle(3);

        //Files alanına bir dosya yüklenir
        ReusableMethods.click(vendorPage.downloadableFileUpload);
        ReusableMethods.bekle(2);
        ReusableMethods.click(vendorPage.chooseMediaUploadFiles);
        ReusableMethods.click(vendorPage.uploadsSelectFilesButton);

        String dosyaYolu2 = System.getProperty("user.home") + "\\IdeaProjects\\Windows 10 Pro Retail Product Key.zip";
        ReusableMethods.uploadFilePath(dosyaYolu2);
        ReusableMethods.click(vendorPage.fileSelectButton);
        ReusableMethods.bekle(3);

        //Submit butonuna tıklanır
        ReusableMethods.click(vendorPage.addProductSubmitButton);
        ReusableMethods.bekle(3);

        //Ürünün Product kısmında görüntülenir
        ReusableMethods.click(vendorPage.productsButton);
        ReusableMethods.scroll(vendorPage.newProductCheckbox);
        ReusableMethods.bekle(3);








    }
}
