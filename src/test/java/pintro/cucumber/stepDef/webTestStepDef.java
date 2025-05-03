package pintro.cucumber.stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pintro.cucumber.utils.Hooks;

import static org.junit.Assert.*;

public class webTestStepDef {
    private WebDriver driver;

    public webTestStepDef() {
        System.out.println("=== [STEPDEF] Instansiasi Step Definition ===");
        this.driver = Hooks.getDriver();  // Ambil WebDriver dari Hooks
    }

    @Given("User membuka halaman login")
    public void user_membuka_halaman_login() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User mengisi {string} dengan {string}")
    public void user_mengisi_dengan(String field, String value) {
        By locator = field.equalsIgnoreCase("username") ? By.id("user-name") : By.id("password");
        driver.findElement(locator).sendKeys(value);
    }

    @When("User klik tombol login")
    public void user_klik_tombol_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User melihat halaman dashboard")
    public void user_melihat_halaman_dashboard() {
        WebElement dashboard = driver.findElement(By.className("title"));
        assertTrue(dashboard.isDisplayed());
    }

    @Then("User melihat pesan error {string}")
    public void user_melihat_pesan_error(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertEquals(expectedMessage, errorMessage.getText());
    }

    @When("User klik tombol logout")
    public void user_klik_tombol_logout() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User kembali ke halaman login")
    public void user_kembali_ke_halaman_login() {
        WebElement loginBox = driver.findElement(By.id("login-button"));
        assertTrue(loginBox.isDisplayed());
    }
}
