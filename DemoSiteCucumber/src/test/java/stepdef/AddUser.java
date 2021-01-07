package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddUser {

	private static WebDriver driver;
	private static String URL = "http://thedemosite.co.uk/";
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://thedemosite.co.uk/");
    }
	
	@After
    public void tearDown() {
        driver.close();
    }	
	
	@Given("^I can open Demo site$")
	public void i_can_open_Demo_site() {
		driver.get(URL);
		assertEquals("FREE example PHP code and online MySQL database - example username password protected site", driver.getTitle());
		System.out.println("Accessed Demo Site");
	}

	@When("^I create an account$")
	public void i_create_an_account() {
        WebElement addUser = driver.findElement(By.linkText("3. Add a User"));
    	addUser.click();
        WebElement username = driver.findElement(By.name("username"));
        String userGuest = "guest";
    	username.sendKeys(userGuest);
        WebElement password = driver.findElement(By.name("password"));
        String passGuest = "guest";
        password.sendKeys(passGuest);
        WebElement submit = driver.findElement(By.name("FormsButton2"));
        submit.click();
	}

	@Then("^I can log in to demo site$")
	public void i_can_log_in_to_demo_site() {
        String userGuest = "guest";
        String passGuest = "guest";
        WebElement logIn = driver.findElement(By.linkText("4. Login"));
        logIn.click();
        WebElement usernameLog = driver.findElement(By.name("username"));
    	usernameLog.sendKeys(userGuest);
        WebElement passwordLog = driver.findElement(By.name("password"));
        passwordLog.sendKeys(passGuest);
        WebElement submitLog = driver.findElement(By.name("FormsButton2"));
        submitLog.click();
        WebElement cssText = driver.findElement(By.cssSelector("center > b"));
        assertEquals("**Successful Login**", cssText.getText());
	}
}
