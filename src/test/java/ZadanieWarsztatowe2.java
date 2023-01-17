import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ZadanieWarsztatowe2 {



    public static void main(String[] args) throws IOException {
      String emailUser = "scstneehvsmyxxqmog@tmmcv.net";
      String hasloUser = "Test123qwe";

//      zaloguje się na tego samego użytkownika z zadania 1

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl");
        driver.manage().window().maximize();
        WebElement singInElement = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        singInElement.click();
        WebElement emailToLogIn = driver.findElement(By.xpath("//*[@id=\"field-email\"]"));
        emailToLogIn.sendKeys(emailUser);
        WebElement hasloToLogIn = driver.findElement(By.xpath("//*[@id=\"field-password\"]"));
        hasloToLogIn.sendKeys(hasloUser);
        WebElement singInButton = driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        singInButton.click();

//        wybierze do zakupu Hummingbird Printed Sweater
        WebElement clothesButton = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        clothesButton.click();
        WebElement hummingbirdPrintedSweaterIcon = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[1]/a/img"));
        hummingbirdPrintedSweaterIcon.click();

//        wybierze rozmiar M
        WebElement changeSizeInput = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        changeSizeInput.click();
        WebElement selectSize = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        selectSize.click();

//        wybierze 5 sztuk według parametru podanego w teście
      WebElement  selectQuantity = driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));

      WebElement clickEmpty = driver.findElement(By.xpath("//*[@id=\"wrapper\"]"));
      selectQuantity.sendKeys(Keys.CONTROL + "a");
      selectQuantity.sendKeys(Keys.DELETE);
      selectQuantity.sendKeys("");
//
      WebElement upQuantity = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i"));
      upQuantity.click();
      upQuantity.click();
      upQuantity.click();
      upQuantity.click();

      clickEmpty.click();

//       ??????????????????
//      WebElement numberInput = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
//      numberInput.click();
//      numberInput.sendKeys(Keys.CONTROL + "a");
//      numberInput.sendKeys(Keys.DELETE);
//      WebElement numberAgain = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
//      numberAgain.sendKeys("5");
//    ????????????????
//      dodaj produkt do koszyka,
      WebElement addToCartButton =  driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]"));
      addToCartButton.click();



//      przejdzie do opcji - checkout,

      WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
      proceedToCheckoutButton.click();

      WebElement procedToCheckoutFinallyButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
      procedToCheckoutFinallyButton.click();


//      potwierdzi address (możesz go dodać wcześniej ręcznie),

//      WebElement selectAddressInput = driver.findElement(By.xpath("//*[@id=\"id-address-delivery-address-30001\"]/header/label/span[1]/input"));
//      selectAddressInput.click();

      WebElement continueSelectAddressButton = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
      continueSelectAddressButton.click();

//      wybierze metodę odbioru - PrestaShop "pick up in store",
      WebElement continueShippingMetod = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
      continueShippingMetod.click();

//      wybierze opcję płatności - Pay by Check,
      WebElement payByCheckInput = driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]"));
      payByCheckInput.click();

//      kliknie na "order with an obligation to pay",
      WebElement aggreInput = driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
      aggreInput.click();
      WebElement placeOrderInput = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
      placeOrderInput.click();
//      zrobi screenshot z potwierdzeniem zamówienia i kwotą

      String screenShootPath = "E:\\AUTOMATYK\\SS";
      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("E:\\AUTOMATYK\\SS"));




    }
}
