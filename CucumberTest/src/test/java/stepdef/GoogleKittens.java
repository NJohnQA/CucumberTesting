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

public class GoogleKittens {
	
	private static WebDriver driver;
	private static String URL = "https://www.google.com/";
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://google.com/");
    }
	
	@After
    public void tearDown() {
        driver.close();
    }

	@Given("^I can open Google$")
	public void i_can_open_Google() {
		driver.get(URL);
		assertEquals("Google", driver.getTitle());
		System.out.println("I can open google");
	}

	@When("^I search for kittens$")
	public void i_search_for_kittens() {
		WebElement input = driver.findElement(By.name("q"));
		input.sendKeys("kittens");
		input.submit();
	}

	@Then("^Google will give me Kittens$")
	public void google_will_give_me_Kittens() {
		driver.findElement(By.name("q"));
		driver.getPageSource().contains("kittens");
	}
	
}
