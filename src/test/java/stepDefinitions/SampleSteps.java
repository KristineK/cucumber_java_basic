package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I (?:am on|open) number page$")
    public void iAmOnNumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys((number));
    }

   /* @When("^I enter number: (.*)$")
    public void i_enter_number_dad(String str1) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(str1));
    }*/

    @And("^I click submit number")
    public void iClickSubmitNumber() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void iSeeMessageOfNumber(String errorMessage) throws Throwable {
        assertEquals(errorMessage, driver.findElement(By.className("error")).getText());
    }

    @Then("^I see a new message: \"([^\"]*)\"$")
    public void iSeeMessageOfCorrectNumber(String Message) throws Throwable {
        assertEquals(Message, driver.switchTo().alert().getText());
    }

    @Given("^I (?:am on|open) Employee page$")
    public void iAmOnEmployeePage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @When("^click on Add person$")
    public void iClickonAdd(){
       driver.findElement(By.xpath("/html/body/div[@class='w3-container'][1]/button[@id='addPersonBtn'][1]")).click();
    }

    @And("^fill all fields: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void ifillFields(String name, String surname, String job, String DataEnter, String selectedCheck, String gender, String status){
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("surname")).sendKeys(surname);
        driver.findElement(By.id("job")).sendKeys(job);
        driver.findElement(By.id("dob")).sendKeys(DataEnter);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[@class='w3-container w3-margin']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @id='"+selectedCheck+"']")).click();
        driver.findElement(By.xpath("//input[@class='w3-radio' and @id='"+gender+"']")).click();
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByVisibleText(status);
        }
    @And("^click button add$")
    public void iclickButAdd(){
        driver.findElement(By.xpath("/html/body/div[@class='w3-row']/div[@class='w3-half']/div[@class='w3-container']/div[@id='addEditPerson']/div[@class='w3-btn-group']/button[@id='modal_button'][1]")).click();
    }
    @And("^click on edit button$")
    public void iclickEditBut(){
     driver.findElement(By.xpath("//li[@id='person3']/span[@class='w3-closebtn editbtn w3-padding w3-margin-right w3-medium' and 3]/i[@class='fa fa-pencil' and 1]")).click();
    }
    //div[@class='w3-xlarge xh-highlight']
    @And("^edit something: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void editSomething(String name1, String surname1, String job1, String DataEnter1, String selectedCheck1, String gender1, String status1){
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name1);
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname1);
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job1);
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(DataEnter1);
        driver.findElement(By.xpath("/html/body/div[@class='w3-container w3-margin']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @id='"+selectedCheck1+"']")).click();
        driver.findElement(By.xpath("//input[@class='w3-radio' and @id='"+gender1+"']")).click();
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByVisibleText(status1);
    }

    @And("^click on edit-button$")
    public void iclickEdit(){
        driver.findElement(By.xpath("//button[1]")).click();

    }

    @And("^remove a person$")
    public void deletePerson(){
       driver.findElement(By.xpath("//li[@id='person3']/span[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium' and 1]")).click();
    }

    @Then("^reset list$")
    public void ResetList(){
        driver.findElement(By.xpath("/html/body/div[@class='w3-container'][1]/button[@id='addPersonBtn'][2]")).click();
    }

    @And("^click clear-button$")
    public void clickClearButton(){
        driver.findElement(By.xpath("/html/body/div[@class='w3-container w3-margin']/div[@class='clear-btn']/button[@id='addPersonBtn']")).click();
    }

    @Then("^check empty fields$")
    public void checkfields(){
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("surname")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
        assertEquals("", driver.findElement(By.id("dob")).getText());
        assertTrue(driver.findElement(By.cssSelector(".w3-check[id='english'][type='checkbox']")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@class='w3-radio' and @id='male']")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@class='w3-radio' and @id='female']")).isSelected());
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByVisibleText("Employee");
        assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
    }

}



