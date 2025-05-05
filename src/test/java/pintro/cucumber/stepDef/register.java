package pintro.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import pintro.cucumber.utils.Hooks;

public class register {
    WebDriver driver = Hooks.getDriver();
    String baseUrl = "https://pmb-dev-alazharpontianak.pintro.id/enroll-new";

    @Given("user is on products page")
    public void user_is_on_products_page(){
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("button[data-bs-dismiss='modal']")).click();

        // Initialize WebDriverWait with WebDriver and Duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Wait for elements to be clickable and interact with them
        wait.until(ExpectedConditions.elementToBeClickable(By.name("name"))).sendKeys("Test Automation");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("pob"))).sendKeys("Secret");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("dob_day"))).sendKeys("01");

        // Select dropdowns
        Select dobMonth = new Select(driver.findElement(By.name("dob_month")));
        dobMonth.selectByValue("2");

        wait.until(ExpectedConditions.elementToBeClickable(By.name("dob_year"))).sendKeys("2000");

        Select levelDropdown = new Select(driver.findElement(By.name("level")));
        levelDropdown.selectByValue("2494");

        // Tunggu sampai <select> muncul
        WebElement departmentDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ng_department_id")));

        // Tunggu sampai dropdown punya lebih dari satu option (bukan hanya default)
        wait.until(driver1 -> {
            Select s = new Select(departmentDropdownElement);
            return s.getOptions().size() > 1;
        });

        // Tunggu sampai dropdown enabled/clickable
        wait.until(ExpectedConditions.elementToBeClickable(departmentDropdownElement));

        // Baru select by value
        Select departmentDropdown = new Select(departmentDropdownElement);
        departmentDropdown.selectByValue("123470");


        Select applicantTypeDropdown = new Select(driver.findElement(By.name("ng_applicant_type_id")));
        applicantTypeDropdown.selectByValue("1259");

        // Tunggu sampai <select> muncul
        WebElement kelasDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ng_class_level_id")));

        // Tunggu sampai dropdown punya lebih dari satu option (bukan hanya default)
        wait.until(driver1 -> {
            Select s = new Select(kelasDropdownElement);
            return s.getOptions().size() > 1;
        });

        // Tunggu sampai dropdown enabled/clickable
        wait.until(ExpectedConditions.elementToBeClickable(kelasDropdownElement));

        // Baru select by value
        Select kelasDropdown = new Select(kelasDropdownElement);
        kelasDropdown.selectByValue("3980");

        // Tunggu sampai <select> muncul
        WebElement kategoriDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ng_class_type_id")));

        // Tunggu sampai dropdown punya lebih dari satu option (bukan hanya default)
        wait.until(driver1 -> {
            Select s = new Select(kategoriDropdownElement);
            return s.getOptions().size() > 1;
        });

        // Tunggu sampai dropdown enabled/clickable
        wait.until(ExpectedConditions.elementToBeClickable(departmentDropdownElement));

        // Baru select by value
        Select kategoriDropdown = new Select(kategoriDropdownElement);
        kategoriDropdown.selectByValue("30054");

        // Tunggu sampai <select> muncul
        WebElement seleksiDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("test_type")));

        // Tunggu sampai dropdown punya lebih dari satu option (bukan hanya default)
        wait.until(driver1 -> {
            Select s = new Select(seleksiDropdownElement);
            return s.getOptions().size() > 1;
        });

        // Tunggu sampai dropdown enabled/clickable
        wait.until(ExpectedConditions.elementToBeClickable(seleksiDropdownElement));

        // Baru select by value
        Select seleksiDropdown = new Select(seleksiDropdownElement);
        seleksiDropdown.selectByValue("1");

        // Click the dropdown button and wait for options to appear
        WebElement dropdownButton = driver.findElement(By.cssSelector("button[data-id='school_of_origin_type']"));
        dropdownButton.click();

        // Wait for the option to appear
        WebElement opsi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Negeri')]")));
        opsi.click();

        driver.findElement(By.id("next")).click();

        String pageName = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageName, "Products");
    }
}
