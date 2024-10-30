import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartTest {

    @Test
    public void checkDiscount0() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name=" +
                "test&email=user%40pflb.ru&password1=12345678&password2=12345678");

        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value = Update]")).click();


        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "0", "Discount percent is not equal to 0");
        softAssert.assertEquals(discount$, "0.0", "Discount sum isn't equal to  0");
        softAssert.assertEquals(total, "190.0", "Total isn't equal to 190.0");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountTwoPercent20Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "2", "Discount percent is not equal to 2");
        softAssert.assertEquals(discount$, "4.0", "Discount sum isn't equal to 4.0");
        softAssert.assertEquals(total, "196.0", "Total isn't equal to 196.0");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountTwoPercent49Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("49");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "2", "Discount percentage is not equal to 2");
        softAssert.assertEquals(discount$, "9.8", "Discount amount isn't equal to 9.8");
        softAssert.assertEquals(total, "408.20", "Total amount isn't equal to 408.20");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountThreePercent50Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "3", "Discount percentage is not equal to 3");
        softAssert.assertEquals(discount$, "15.0", "Discount amount isn't equal to 15.0");
        softAssert.assertEquals(total, "485.00", "Total amount isn't equal to 485.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountThreePercent99Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("99");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "3", "Discount percentage is not equal to 3");
        softAssert.assertEquals(discount$, "29.70", "Discount amount isn't equal to 29.70");
        softAssert.assertEquals(total, "960.30", "Total amount isn't equal to 960.30");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountFourPercent100Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "4", "Discount percentage is not equal to 4");
        softAssert.assertEquals(discount$, "40.00", "Discount amount isn't equal to 40.0");
        softAssert.assertEquals(total, "960.00", "Total amount isn't equal to 960.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountFourPercent499Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("499");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "4", "Discount percentage is not equal to 4");
        softAssert.assertEquals(discount$, "199.60", "Discount amount isn't equal to 199.60");
        softAssert.assertEquals(total, "4790.40", "Total amount isn't equal to 4790.40");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountFivePercent500Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("500");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "5", "Discount percentage is not equal to 5");
        softAssert.assertEquals(discount$, "250.00", "Discount amount isn't equal to 250.00");
        softAssert.assertEquals(total, "4750.00", "Total amount isn't equal to 4750.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountFivePercent999Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=4");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("999");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "5", "Discount percentage is not equal to 5");
        softAssert.assertEquals(discount$, "499.50", "Discount amount isn't equal to 499.50");
        softAssert.assertEquals(total, "9490.50", "Total amount isn't equal to 9490.50");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountSixPercent1000Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("1000");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "6", "Discount percentage is not equal to 6");
        softAssert.assertEquals(discount$, "600.00", "Discount amount isn't equal to 600.00");
        softAssert.assertEquals(total, "9400.00", "Total amount isn't equal to 9400.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountSixPercent4999Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("4999");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "6", "Discount percentage is not equal to 6");
        softAssert.assertEquals(discount$, "2999.40", "Discount amount isn't equal to 2999.40");
        softAssert.assertEquals(total, "469990.60", "Total amount isn't equal to 469990.60");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountSevenPercent5000Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("5000");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "7", "Discount percentage is not equal to 7");
        softAssert.assertEquals(discount$, "3500.00", "Discount amount isn't equal to 3500.00");
        softAssert.assertEquals(total, "46500.00", "Total amount isn't equal to 46500.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountSevenPercent9999Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("9999");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "7", "Discount percentage is not equal to 7");
        softAssert.assertEquals(discount$, "6999.30", "Discount amount isn't equal to 6999.30");
        softAssert.assertEquals(total, "92990.70", "Total amount isn't equal to 92990.70");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountEightPercent10000Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("10000");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "8", "Discount percentage is not equal to 8");
        softAssert.assertEquals(discount$, "8000.00", "Discount amount isn't equal to 8000.00");
        softAssert.assertEquals(total, "92000.00", "Total amount isn't equal to 92000.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscountEightPercent10001Books() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=" +
                "Ann&last_name=Smith&email=smith%40gmail.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=3");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("10001");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountPercent = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(discountPercent, "8", "Discount percentage is not equal to 8");
        softAssert.assertEquals(discount$, "8000.80", "Discount amount isn't equal to 8000.80");
        softAssert.assertEquals(total, "92009.20", "Total amount isn't equal to 92009.20");
        driver.quit();
        softAssert.assertAll();
    }
}
