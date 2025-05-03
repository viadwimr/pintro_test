package pintro.cucumber.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("=== [HOOKS] Inisialisasi WebDriver ===");
        if (driver == null) {
            // Tambahkan baris ini:
            WebDriverManager.chromedriver().clearDriverCache();
            WebDriverManager.chromedriver().browserVersion("135").setup();

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void teardown() {
        System.out.println("=== [HOOKS] Menutup WebDriver ===");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("=== [WARNING] WebDriver null, memulai ulang! ===");

            // Tambahkan baris ini juga:
            WebDriverManager.chromedriver().clearDriverCache();
            WebDriverManager.chromedriver().browserVersion("135").setup();

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
