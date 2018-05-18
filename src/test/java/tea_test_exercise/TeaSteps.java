package tea_test_exercise;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.Assert.assertEquals;

public class TeaSteps {

    private static WebDriver driver;
    private static String url = "http://www.practiceselenium.com/welcome.html";


    @Given("^the correct web address$")
    public void the_correct_web_address() throws InterruptedException{
        driver = new ChromeDriver();
        driver.manage().window();
        Thread.sleep(500);
        assertEquals("http://www.practiceselenium.com/welcome.html",url);
        driver.get(url);

    }

    @When("^I navigate to the 'Menu' page$")
    public void I_navigate_to_the_Menu_page() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")).click();
        Thread.sleep(500);
    }

    @Then("^I can browse a list of the available products.$")
    public void I_can_browse_a_list_of_the_available_products(){
        assertEquals("Green Tea",driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")).getText());
        assertEquals("Red Tea",driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000453231072 > div > p > span > span > strong")).getText());
        assertEquals("Oolong Tea",driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong")).getText());
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() {
        driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")).click();

    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page(){
        assertEquals("http://www.practiceselenium.com/check-out.html",driver.getCurrentUrl());
    }

}
