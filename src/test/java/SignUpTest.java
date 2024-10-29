import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void checkPositiveSignUp() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value = Continue]")).click();

        browser.findElement(By.name("first_name")).sendKeys("Ann");
        browser.findElement(By.name("last_name")).sendKeys("Smith");
        browser.findElement(By.name("email")).sendKeys("smith@gmail.com");
        browser.findElement(By.name("password1")).sendKeys("12345678");
        browser.findElement(By.name("password2")).sendKeys("12345678");
        browser.findElement(By.cssSelector("[value = Register]")).click();
        String signUpMessage = browser.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(signUpMessage,"Account is created!");
        browser.quit();
    }

    @Test
    public void checkFirstNameBlank() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("");
        browser.findElement(By.cssSelector("[value = Continue]")).click();

        browser.findElement(By.name("first_name")).sendKeys("");
        browser.findElement(By.name("last_name")).sendKeys("Smith");
        browser.findElement(By.name("email")).sendKeys("smith@gmail.com");
        browser.findElement(By.name("password1")).sendKeys("12345678");
        browser.findElement(By.name("password2")).sendKeys("12345678");
        browser.findElement(By.cssSelector("[value = Register]")).click();
        String errorMessage = browser.findElement(By.className("error_message")).getText();
        Assert.assertEquals(errorMessage,"Oops, error on page. Some of your fields have invalid data or email was previously used");
        browser.quit();
    }
}
