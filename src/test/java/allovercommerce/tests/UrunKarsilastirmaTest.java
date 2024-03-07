package allovercommerce.tests;

import allovercommerce.pages.RegisterPage;
import allovercommerce.pages.UrunKarsilastirmaPage;
import allovercommerce.utilities.ConfigReader;
import allovercommerce.utilities.Driver;
import allovercommerce.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class UrunKarsilastirmaTest {
    RegisterPage registerPage = new RegisterPage();
    UrunKarsilastirmaPage urunKarsilastirmaPage =new UrunKarsilastirmaPage();
    Actions actions =new Actions(Driver.getDriver());




    @Test
    public void test01() throws AWTException, InterruptedException {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        registerPage.signInButton.click();
        // Eposta adresi kutusuna olarak kayıtlı olan email ya da username girilir
        urunKarsilastirmaPage.usernameOrEmailBox.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Sifre kutusuna gecerli bir veri girilir
        urunKarsilastirmaPage.passwordBox.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // Sign In butonuna tıklanır
        urunKarsilastirmaPage.signInButton.click();
        ReusableMethods.bekle(3);
        // Shopping sayfası açılır ve searchbox a "kazak" girilir ve aratılır
        urunKarsilastirmaPage.searchBox.sendKeys("kazak", Keys.ENTER);
        //Açılan sayfadan "KAZAK" urunu seçilir
        actions.moveToElement(urunKarsilastirmaPage.kazak1).perform();
        ReusableMethods.bekle(3);
        //kazak urununun üzerinde beklenir ve compare butonuna tıklanır
        ReusableMethods.click(urunKarsilastirmaPage.kazak1KarsilastirmaButton);
        ReusableMethods.bekle(1);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        //Sayfada scroll yapılır
        ReusableMethods.scroll(urunKarsilastirmaPage.scrollDownElement);
        ReusableMethods.bekle(1);
        // 2. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak2).perform();
        ReusableMethods.bekle(3);
        ReusableMethods.click(urunKarsilastirmaPage.kazak2KarsilastirmaButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        // 3. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak3).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.kazak3KarsilastirmaButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        // 4. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak4).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.kazak4KarsilastirmaButton);
        ReusableMethods.bekle(2);
        //Compare Products penceresinden Start Compare butonuna tıklanır
        actions.click(urunKarsilastirmaPage.startCompareButton).perform();
        //Açılan pencerede seçilen 4 adet urunun görüldüğü ve karşılaştırılabildiği doğrulanır
        Assert.assertTrue(urunKarsilastirmaPage.maviliKazak.isDisplayed());
        Assert.assertTrue(urunKarsilastirmaPage.siyahKazak.isDisplayed());
        Assert.assertTrue(urunKarsilastirmaPage.koyuGriKazak.isDisplayed());
        Assert.assertTrue(urunKarsilastirmaPage.kahverengiKazak.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void dortUrundenFazlasiComparedeGorunmezTest() throws AWTException, InterruptedException {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        registerPage.signInButton.click();
        // Eposta adresi kutusuna olarak kayıtlı olan email adresi girilir
        urunKarsilastirmaPage.usernameOrEmailBox.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Sifre kutusuna gecerli bir veri girilir
        urunKarsilastirmaPage.passwordBox.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // Sign In butonuna tıklanır
        urunKarsilastirmaPage.signInButton.click();
        ReusableMethods.bekle(3);
        // Shopping sayfası açılır ve searchbox a "kazak" girilir ve aratılır
        urunKarsilastirmaPage.searchBox.sendKeys("kazak", Keys.ENTER);
        //Açılan sayfadan "KAZAK" urunu seçilir
        actions.moveToElement(urunKarsilastirmaPage.kazak1).perform();
        ReusableMethods.bekle(3);
        //kazak urununun üzerinde beklenir ve compare butonuna tıklanır
        ReusableMethods.click(urunKarsilastirmaPage.kazak1KarsilastirmaButton);
        ReusableMethods.bekle(1);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        //Sayfada scroll yapılır
        ReusableMethods.scroll(urunKarsilastirmaPage.scrollDownElement);
        ReusableMethods.bekle(1);
        // 2. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak2).perform();
        ReusableMethods.bekle(3);
        ReusableMethods.click(urunKarsilastirmaPage.kazak2KarsilastirmaButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        // 3. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak3).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.kazak3KarsilastirmaButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        // 4. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak4).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.kazak4KarsilastirmaButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        ReusableMethods.bekle(1);
        //Sayfanın yukarısına scroll yapılır
        ReusableMethods.scroll(urunKarsilastirmaPage.scrollUppElement);
        ReusableMethods.bekle(1);
        // 5. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak5).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.kazak5KarsilastirmaButton);
        ReusableMethods.bekle(2);
        //Compare Products penceresinde 5 ürün seçilmesine rağmen 4 ürün görüntülenir
        // 4 urunden fazla seçilemediği doğrulanır

        String expected = "(4 Products)";
        Assert.assertEquals(urunKarsilastirmaPage.urunAdedi.getText(),expected);
        ReusableMethods.click(urunKarsilastirmaPage.startCompareButton);
        ReusableMethods.bekle(1);
        Driver.closeDriver();
    }
    @Test
    public void test03() throws AWTException, InterruptedException {
        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        // Sign In butonuna tıklanır
        registerPage.signInButton.click();
        // Eposta adresi kutusuna olarak kayıtlı olan email adresi girilir
        urunKarsilastirmaPage.usernameOrEmailBox.sendKeys(ConfigReader.getProperty("kayitliUsername"));
        // Sifre kutusuna gecerli bir veri girilir
        urunKarsilastirmaPage.passwordBox.sendKeys(ConfigReader.getProperty("kayitliUserPassword"));
        // Sign In butonuna tıklanır
        urunKarsilastirmaPage.signInButton.click();
        ReusableMethods.bekle(3);
        // Shopping sayfası açılır ve searchbox a "kazak" girilir ve aratılır
        urunKarsilastirmaPage.searchBox.sendKeys("kazak", Keys.ENTER);
        //Açılan sayfadan "KAZAK" urunu seçilir
        actions.moveToElement(urunKarsilastirmaPage.kazak1).perform();
        ReusableMethods.bekle(3);
        //kazak urununun üzerinde beklenir ve compare butonuna tıklanır
        ReusableMethods.click(urunKarsilastirmaPage.kazak1KarsilastirmaButton);
        ReusableMethods.bekle(1);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        //Sayfada scroll yapılır
        ReusableMethods.scroll(urunKarsilastirmaPage.scrollDownElement);
        ReusableMethods.bekle(1);
        // 2. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak2).perform();
        ReusableMethods.bekle(3);
        ReusableMethods.click(urunKarsilastirmaPage.kazak2KarsilastirmaButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        // 3. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak3).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.kazak3KarsilastirmaButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.bosClick);
        // 4. olarak başka bir urun seçilir ve compere butonuna tıklanır
        actions.moveToElement(urunKarsilastirmaPage.kazak4).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(urunKarsilastirmaPage.kazak4KarsilastirmaButton);
        ReusableMethods.bekle(2);
        //Compare Products penceresinden Start Compare butonuna tıklanır
        actions.click(urunKarsilastirmaPage.startCompareButton).perform();
        //Copare penceresi açılır ve seçilen 4 adet urunun silinir
        for (int i = 0; i <4 ; i++) { //4 kere click yapılır
            ReusableMethods.click(urunKarsilastirmaPage.urunSil1);
            ReusableMethods.bekle(1);
        }

        //urunlerin silindiği ve "No products added to the compare" mesajının görüntülendiği doğrulanır
        Assert.assertEquals(urunKarsilastirmaPage.urunlerSilindiText.getText(),"No products added to the compare");
        Driver.closeDriver();

    }
}
