package test;

import config.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FirstSeleniumTest {

    public static String browser;
    static WebDriver driver;

    public static void main(String[] args) {
        //setBrowser();
        PropertiesFile.readPropertiesFile();
        setBrowserConfig();
        runTest();
    }

    public static void setBrowser() {
        browser = "Firefox";
    }

    public static void setBrowserConfig() {
        String projectLocation = System.getProperty("user.dir");

        if (browser.contains("Firefox")) {
            System.setProperty("webdriver.gecko.driver", projectLocation + "\\lib\\geckodriver\\geckodriver.exe");
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver();
        }

        if (browser.contains("Chrome")) {
            System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public static void runTest() {
        //Ga naar Facebook
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        System.out.println("Title is: " + driver.getTitle());

        //Accepteer alle cookies
        driver.findElement(By.xpath("//*[@id=\"u_0_k\"]")).click();

        //Druk op knop 'Nieuw account aanmaken
        driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Wacht op het verschijnen van het Registratiebox
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_box")));

        //Vul voornaam in
        driver.findElement(By.xpath("//*[@id=\"u_3_b\"]")).sendKeys("DitIsMijnVoornaam");
        //Vul achternaam in
        driver.findElement(By.xpath("//*[@id=\"u_3_d\"]")).sendKeys("DitIsMijnAchternaam");
        //Vul Email in
        driver.findElement(By.xpath("//*[@id=\"u_3_g\"]")).sendKeys("DitIsMijnEmail@gmail.com");
        //Vul Email nog een keer in
        driver.findElement(By.xpath("//*[@id=\"u_3_j\"]")).sendKeys("DitIsMijnEmail@gmail.com");
        //Vul wachtwoord in
        driver.findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys("DitIsMijnWachtwoord123#");
        //Vul geboortedatum in
        //Dag
        Select day = new Select(driver.findElement(By.xpath("//*[@id=\"day\"]")));
        day.selectByVisibleText("15");
        //Maand
        Select month = new Select(driver.findElement(By.xpath("//*[@id=\"month\"]")));
        month.selectByValue("10");
        //Jaar
        Select year = new Select(driver.findElement(By.xpath("//*[@id=\"year\"]")));
        year.selectByValue("1990");
        //Kies geslacht
        driver.findElement(By.xpath("//*[@id=\"u_3_o\"]/span[2]")).click();
        //Klik op Registeren-knop
        driver.findElement(By.xpath("//*[@id=\"u_3_s\"]")).click();

        driver.quit();
    }

}


