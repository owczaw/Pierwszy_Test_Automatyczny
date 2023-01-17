import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZadanieWarsztatowe1 {

    private WebDriver driver;
    private String emailUser = "scstneehvsmyxxqmog@tmmcv.net";
    private String hasloUser = "Test123qwe";

    @Given("uzytkownik wchodzi na strone {string}")
    public void uzytkownikWchodziNaStrone(String websiteUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(websiteUrl);
    }


    @And("uzytkownik loguje sie uzywajac danych do logowania")
    public void uzytkownikLogujeSieUzywajacDanychDoLogowania() {
        WebElement singInElement = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        singInElement.click();
        WebElement emailToLogIn = driver.findElement(By.xpath("//*[@id=\"field-email\"]"));
        emailToLogIn.sendKeys(emailUser);
        WebElement hasloToLogIn = driver.findElement(By.xpath("//*[@id=\"field-password\"]"));
        hasloToLogIn.sendKeys(hasloUser);
        WebElement singInButton = driver.findElement(By.xpath("//*[@id=\"submit-login\"]"));
        singInButton.click();
    }


    @When("uzytkownik klika w kafelek ADDRESSES, a nastepnie CREATE NEW ADDRESS")
    public void uzytkownikKlikaWKafelekADDRESSESANastepnieCREATENEWADDRESS() {
        WebElement informationButton = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        informationButton.click();
        WebElement createNewAddressButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        createNewAddressButton.click();

    }

    @When("uzytkownik uzupełni folmularz NEW ADDRESS danymi {string}, {string}, {string}, {string}, {string}, {string} uzytkownik klika przycisk save")
    public void uzytkownikUzupełniFolmularzNEWADDRESSDanymiUzytkownikKlikaPrzyciskSave(String alias, String address, String city, String postalCode, String country, String phone) {

        WebElement aliasInput = driver.findElement(By.xpath("//*[@id=\"field-alias\"]"));
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"field-address1\"]"));
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.xpath("//*[@id=\"field-city\"]"));
        cityInput.sendKeys(city);

        WebElement postalCodeInput = driver.findElement(By.xpath("//*[@id=\"field-postcode\"]"));
        postalCodeInput.sendKeys(postalCode);

        WebElement countryInput = driver.findElement(By.xpath("//*[@id=\"field-id_country\"]"));
        countryInput.click();
        countryInput.sendKeys(country);
        WebElement countrySelectInput = driver.findElement(By.xpath("//*[@id=\"field-id_country\"]/option[2]"));
        countrySelectInput.click();

        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"field-phone\"]"));
        phoneInput.sendKeys(phone);

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click();


    }

    @Then("sprawdzenie poprawnosci danych {string}, {string}, {string}, {string}, {string}, {string}")
    public void sprawdzeniePoprawnosciDanych(String alias, String address, String city, String postalCode, String country, String phone) {

//        String aliasText = driver.findElement(By.xpath("//*[@id=\"address-30504\"]/div[1]/h4")).getText();
//        aliasText.contains(alias);
//        Assertions.assertEquals(alias, aliasText);
        String CheckAddress = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[1]/address")).getText();
        CheckAddress.contains(alias);
        CheckAddress.contains(address);
        CheckAddress.contains(city);
        CheckAddress.contains(postalCode);
        CheckAddress.contains(country);
        CheckAddress.contains(phone);

    }

    @And("zamykamy przegladarke")
    public void usuwamyAdres() {
//        WebElement deleteAddres =  driver.findElement(By.xpath("//*[@id=\"address-30794\"]/div[2]/a[2]/span"));
//        deleteAddres.click();
        driver.quit();

    }


}
