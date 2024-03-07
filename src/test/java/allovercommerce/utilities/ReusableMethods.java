package allovercommerce.utilities;

import allovercommerce.pages.VendorPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ReusableMethods {

    public static ExtentReports extentReports;
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentTest extentTest;

    //ExtentReport

    public static void createExtentReport(String testName){

        //bu object i raporlari olusturmak ve yonetmek icin kullanacağız
        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a Html raporlayiciyi ekler
        //Bu raporun html formatinda olusmasini saglar
        extentReports.attachReporter(extentHtmlReporter);

        //Html raporun browser sekmesinde title kısmında goruntulenir
        extentHtmlReporter.config().setDocumentTitle("Team02 TestNG");

        //Raporun adini ayarlar, bu raporda goruntulenecek olan genel basliktir
        extentHtmlReporter.config().setReportName("Team02 TestNG Project");

        //Raporun sistem bilgi bolumune cesitli istedigimiz bilgileri ekleriz
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Rıdvan Özdemir");
        extentReports.setSystemInfo("Test Automation Engineer","Hayriye Kartın");
        extentReports.setSystemInfo("Test Automation Engineer","Fatih Yavuz");
        extentReports.setSystemInfo("Test Automation Engineer","Şeyma Bilgin");
        extentReports.setSystemInfo("Test Automation Engineer","Gülsüm Baltacı");
        extentReports.setSystemInfo("Test Automation Engineer","Asiye Atak");

        //Amazon test adinda yeni bir test olusturur ve bu teste TestSteps aciklamasini ekler
        extentTest=extentReports.createTest(testName,"Test Steps");
    }


    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }
    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }
    //Alert promptBox
    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    /*
       Select select2 = new Select(gun);
       select2.selectByVisibleText("7");
       //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
    */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }
    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }
    //SwitchToWindow2
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS
    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //Tüm Sayfa ScreenShot
    public static void screenShot(String name) {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/techproed/testOutputs/screenshots/" + name + date + ".png";
        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //WebElement ScreenShot
//webelement screenshot
    public static void  screenShotOfWebElement(WebElement webElement){
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/techproed/testOutputs/webElementScreenshots/" +  date + ".png";
        try {
            Files.write(  Paths.get(dosyaYolu) , webElement.getScreenshotAs(OutputType.BYTES) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }
    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }
    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }
    //JS SetAttributeValue
    public static void setAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }
    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }

    //JS GetAttributeStringValue
    public static String getStringValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
        return attribute_Value;
    }


    public static String ddmSelectedOptionText(WebElement ddm) {
        Select select = new Select(ddm);
        return select.getFirstSelectedOption().getText();
    }

    public static List<String> ddmAllText(WebElement ddm) {
        Select select = new Select(ddm);
        return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    //JS Uyari Mesaji
    public static String uyariMesaji(WebElement inputElement){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", inputElement);
        System.out.println("Validation Message = "+validationMessage);
        return validationMessage;
    }
    //CheckBox Temizleme
    public static void deleteMethod(WebElement webElement) {

        String codeValue = webElement.getAttribute("value");
        for (int i = 0; i < codeValue.length(); i++) {
            webElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    //US17- US20 Vendor olarak Sign In olma - gulsum


    public static void singInVendor() {
        VendorPage vendorPage = new VendorPage();
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        vendorPage.signInBox.click();
        vendorPage.userName.sendKeys(ConfigReader.getProperty("signInUsername"),
                Keys.TAB, ConfigReader.getProperty("signInPassword"), Keys.ENTER);
        ReusableMethods.bekle(3);
    }

    public static void selectRandomProducts(){ //random urun/urunler sec

        Random random = new Random();
        Actions actions = new Actions(Driver.getDriver());

        int randomNum = random.nextInt(32); // 0 dahil, 32 hariç
        List<Integer> numOfNonproduct = Arrays.asList(2, 4, 5, 6, 7, 8, 9, 14, 15, 22);
        if (!numOfNonproduct.contains(randomNum)) {
            List<WebElement> allProducts = Driver.
                    getDriver().
                    findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']"));
            WebElement randomProduct = allProducts.get(randomNum);
            scroll(randomProduct);
            actions.sendKeys(Keys.PAGE_DOWN);
            click(randomProduct);
        } else {
            selectRandomProducts();
        }
    }

    //File Upload Robot Class
    public static void uploadFilePath(String dosyaYolu) {
        try {
            ReusableMethods.bekle(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();
            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);
            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);
            // Sonraki işlemler için ek 3 saniye bekler.
        } catch (Exception ignored) {
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }
    }


}
