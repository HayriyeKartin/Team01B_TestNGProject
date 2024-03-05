package allovercommerce.tests;

import allovercommerce.pages.VendorPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VendorShippingTest {

    VendorPage vendorPage = new VendorPage();


    @Test
    public void addProductToCart() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        vendorPage.addToCartButton.click();

        //Bir veya birden fazla ürünün sepete eklenebildiği doğrulanır.
        Assert.assertTrue(vendorPage.multipleProduct.isDisplayed());

    }

    @Test
    public void productDisplay() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        vendorPage.addToCartButton.click();

        //Ana sayfada bulunan "Cart" simgesinı tıklar
        vendorPage.cartIcon.click();

        //"Checkout" butonuna tıklar
        vendorPage.checkOut.click();

        //Seçilen ürünlerin "Your Order" da görüldüğü doğrulanır
        Assert.assertTrue(vendorPage.yourOrderProduct.isDisplayed());

    }

    @Test
    public void billingDetails() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        vendorPage.addToCartButton.click();

        //Cart' a click yap
        vendorPage.cartIcon.click();

        //Checkout' a click yap
        vendorPage.checkOut.click();

        //Fatura adresinin doldurulduğunu dogrula
        Assert.assertTrue(vendorPage.billingUsername.isDisplayed());

    }

    @Test
    public void totalAmount() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        vendorPage.addToCartButton.click();

        //Web sayfasında bulunan "Cart" simgesine tıklar
        vendorPage.cartIcon.click();

        //"Shopping Cart"" sayfası görüntülenir"
        Assert.assertTrue(vendorPage.shoppingCart.isDisplayed());

        //Seçilen ürünlerin "Your Order" da görüldüğü doğrulanır
        Assert.assertTrue(vendorPage.yourOrderProduct.isDisplayed());

        //"Total" bölümünde toplam ödenecek rakamın görüntülendiği doğrulanır
        Assert.assertTrue(vendorPage.total.isDisplayed());
    }

    @Test
    public void wireTransfer() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        vendorPage.addToCartButton.click();

        //Web sayfasında bulunan "Cart" simgesine tıklar
        vendorPage.cartIcon.click();

        //checkout a tıkla
        vendorPage.checkOut.click();

        //Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli
        ReusableMethods.scroll(vendorPage.billingEmail);
        vendorPage.wireTransfer.click();

        //Wire transfer/EFT secildildiği doğrulanır
        Assert.assertTrue(vendorPage.wireTransfer.isSelected());

    }

    @Test
    public void payAtTheDoor() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        ReusableMethods.click(vendorPage.addToCartButton);

        //Web sayfasında bulunan "Cart" simgesine tıklar
        vendorPage.cartIcon.click();

        //checkout a tıkla
        vendorPage.checkOut.click();

        //Wire transfer/EFT veya Pay at the door seçenekleri seçilebilmeli
        ReusableMethods.scroll(vendorPage.billingEmail);
        ReusableMethods.click(vendorPage.payAtTheDoor);

        //Wire transfer/EFT ticketlarının secilebildiği doğrulanır
        Assert.assertTrue(vendorPage.payAtTheDoor.isSelected());

    }
    @Test
    public void placeOrder() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        ReusableMethods.click(vendorPage.addToCartButton);

        //Web sayfasında bulunan "Cart" simgesine tıklar
        vendorPage.cartIcon.click();

        //checkout a tıkla
        vendorPage.checkOut.click();

        //Wire transfer/EFT veya Pay at the door secilir
        ReusableMethods.scroll(vendorPage.billingEmail);
        ReusableMethods.click(vendorPage.wireTransfer);

        //Place Order'a tıklanarak alışverişin tamamlandığı görülebilmeli
        ReusableMethods.click(vendorPage.placeOrder);
        ReusableMethods.bekle(3);
        Assert.assertTrue(vendorPage.orderCompletedText.isDisplayed());

    }

    @Test
    public void orders() {

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //Açılan sayfada ürün seçilir
        ReusableMethods.selectRandomProducts();

        //Add to cart butotuna tıklanır
        vendorPage.addToCartButton.click();

        //My Account sayfasına gidilir
        ReusableMethods.click(vendorPage.myAccount);

        //Orders yazısına tıklanır
        vendorPage.orders.click();

        //Açılan sayfada siparis numarasına tıklanır
        vendorPage.ilkOrderView.click();

        //ORDER DETAILS alanının görüldügü dogrulanir
        ReusableMethods.bekle(3);
        ReusableMethods.scroll(vendorPage.orderDetails);
        Assert.assertTrue(vendorPage.orderDetails.isDisplayed());

    }

    @Test
    public void enterYourCode() {

        //US20 Oluşturulan coupon ENTER YOUR CODE tıklanarak girilmeli

        //Vendor olarak web sitesine gidilir ve sign in olunur
        ReusableMethods.singInVendor();

        //	Olusturdugum urunumu search yap
        vendorPage.searchButton.sendKeys("Giorgio Armani Si Eau De Parfum 100ml", Keys.ENTER);

        //	Add to cart' a click yap
        ReusableMethods.click(vendorPage.addToCartButton);

        //	Ana sayfada bulunan "Cart" simgesine tıklanır
        vendorPage.cartIcon.click();

        // View cart butonuna tıklanır
        vendorPage.checkOut.click();

        //	ENTER YOUR CODE tıkla
        ReusableMethods.click(vendorPage.enterCouponCode);

        //	Coupon code gir //
        vendorPage.couponCodeBox.sendKeys(ConfigReader.getProperty("coupon"));
        ReusableMethods.bekle(3);

        //	Apply coupon butonuna tikla
        ReusableMethods.scroll(vendorPage.applyCouponCode);
        ReusableMethods.bekle(2);
        vendorPage.applyCouponCode.click();

        // Gecerli coupon kodu girilidigini dogrula
        Assert.assertTrue(vendorPage.successCoupon.getText().contains("Coupon code applied successfully."));
        ReusableMethods.bekle(3);

        // Place order' a click yap
        ReusableMethods.click(vendorPage.placeOrder);

        // Place order' a click yapildigini dogrula
        Assert.assertTrue(vendorPage.orderCompletedText.getText().contains("Thank you"));
        ReusableMethods.bekle(3);

    }
}
