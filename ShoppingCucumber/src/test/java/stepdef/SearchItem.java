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

public class SearchItem {

	private static WebDriver driver;
	private static String URL = "http://automationpractice.com/index.php";
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://automationpractice.com/index.php");
    }
	
	@After
    public void tearDown() {
        driver.close();
    }
	
	@Given("^I can open Shopping site$")
	public void i_can_open_Shopping_site()  {
		driver.get(URL);
		assertEquals("My Store", driver.getTitle());
		System.out.println("Accessed Shopping Site");
	}

	@When("^I search for an item$")
	public void i_search_for_an_item() {
        WebElement search = driver.findElement(By.id("search_query_top"));
        String item = "faded";
    	search.sendKeys(item);
        WebElement submit = driver.findElement(By.name("submit_search"));
        submit.click();
	}

	@Then("^I can find the item$")
	public void i_can_find_the_item() {
        WebElement resultItem = driver.findElement(By.cssSelector(".product_img_link > .replace-2x"));
        resultItem.click();
        WebElement itemName = driver.findElement(By.cssSelector("h1"));
        assertEquals("Faded Short Sleeve T-shirts", itemName.getText());
	}
	
}
