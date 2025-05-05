package pintro.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pintro.cucumber.utils.Hooks;


public class login {
    WebDriver driver;
    String baseUrl = "https://dev-alazharpontianak.pintro.id/";

    @Given("User masuk ke halaman login Swaglabs")
    public void halaman_login(){
        driver = Hooks.getDriver(); // ← pindahkan ke sini
        driver.get(baseUrl);
    }

    @And("User memasukkan \"username\"")
    public void username_input(){
        driver.findElement(By.name("username")).sendKeys("2502015");
    }
    @And("User memasukkan \"password\"")
    public void password_input(){
        driver.findElement(By.name("password")).sendKeys("280425");
    }
    @When("User mengklik tombol \"login\"")
    public void login_button(){
        driver.findElement(By.id("login")).click();
    }
    @Then("User berhasil dapat melihat halaman \"products\"")
    public void products_page(){
        String pageName = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageName, "Selamat Datang");
    }
}
