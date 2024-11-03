import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class CheckoutTest {

    @Test
    public void makePaymentByVisaCard() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value= Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Ann");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("smith@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/"
                + "tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.findElement(By.linkText("Shopping Cart")).click();
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[5]/td/form/input[1]")).click();
        String creditCardVisa = "1111111111118431";
        driver.findElement(By.name("card_number")).sendKeys(creditCardVisa);
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[7]/td[2]"
                + "/input")).click();
        boolean successMessageIsDisplayed = driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/"
                + "tbody/tr[2]/td/p/font/b")).isDisplayed();
        Assert.assertTrue(successMessageIsDisplayed);
        driver.quit();
    }

    @Test
    public void makePaymentByMasterCard() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value= Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Ann");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("smith@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table"
                + "/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.findElement(By.linkText("Shopping Cart")).click();
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[5]/td/form/input[1]")).click();
        Select cardNumber = new Select(driver.findElement(By.name("card_type_id")));
        cardNumber.selectByVisibleText("MasterCard");
        String creditCardMastercard = "2222222222224243";
        driver.findElement(By.name("card_number")).sendKeys(creditCardMastercard);
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[7]"
                + "/td[2]/input")).click();
        boolean successMessageIsDisplayed = driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/" +
                "tbody/tr[2]/td/p/font/b")).isDisplayed();
        Assert.assertTrue(successMessageIsDisplayed);
        driver.quit();
    }

    @Test
    public void makePaymentByAmExCard() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value= Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Ann");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("smith@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table"
                + "/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.findElement(By.linkText("Shopping Cart")).click();
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[5]/td/form/input[1]")).click();
        Select cardNumber = new Select(driver.findElement(By.name("card_type_id")));
        cardNumber.selectByVisibleText("AmEx");
        String creditCardAmEx = "3333333333331573";
        driver.findElement(By.name("card_number")).sendKeys(creditCardAmEx);
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[7]/"
                + "td[2]/input")).click();
        boolean successMessageIsDisplayed = driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/"
                + "tbody/tr[2]/td/p/font/b")).isDisplayed();
        Assert.assertTrue(successMessageIsDisplayed);
        driver.quit();
    }

    @Test
    public void makePaymentWithBlankCardNumber() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value= Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Ann");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("smith@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table"
                + "/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.findElement(By.linkText("Shopping Cart")).click();
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[5]/td/form/input[1]")).click();
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[7]/"
                + "td[2]/input")).click();
        String errorMessage = driver.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error. Invalid card number or not enough balance for purchase",
                "The messages are not matched or message is missed.");
        driver.quit();
    }

    @Test
    public void makePaymentWithInvalidCardNumber() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        WebElement signUp = driver.findElement(By.linkText("Sign up"));
        signUp.click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value= Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Ann");
        driver.findElement(By.name("last_name")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("smith@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("123456");
        driver.findElement(By.name("password2")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table"
                + "/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.findElement(By.linkText("Shopping Cart")).click();
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[5]/td/form/input[1]")).click();
        String invalidCardNumber = "4111111111111111";
        driver.findElement(By.name("card_number")).sendKeys(invalidCardNumber);
        driver.findElement(By.xpath("//table/tbody/tr[5]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[7]/"
                + "td[2]/input")).click();
        String errorMessage = driver.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error. Invalid card number or not enough balance for purchase",
                "The messages are not matched or message is missed.");
        driver.quit();
    }
}