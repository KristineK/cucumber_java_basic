package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

//------------------------------------------Sample1.feature------------------------
    @When("^I am on the locators page$")
    public void iAmOnTheLocatorsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void IShouldSeeBothLocatorsPageHeaders() {

//        assertEquals("Heading 1", driver.findElement(By.id("heading_1")).getText());
//        assertEquals("Heading 2 text", driver.findElement(By.id("heading_2")).getText());

        assertTrue(driver.findElement(By.id("heading_1")).isDisplayed());
        assertTrue(driver.findElement(By.id("heading_2")).isDisplayed());

    }
    @And("^Buttons in Locators page are clickable$")
    public void ButtonIsLocatorsPageAreClickable(){
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());
    }

    @Then("^I see error: \"([^\"]*)\"$")
    public void ISeeErrorAgePage(String errorMsg){
        assertTrue(driver.findElement(By.id("error")).isDisplayed());
        assertEquals(errorMsg, driver.findElement(By.id("error")).getText());
    }
    @And("^I am not navigated to age message page$")
    public void IAmNotNavigatedToAgeMessagePage(){
        assertFalse(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age_2.html"));
    }
    //------------------------------------------Sample3 Features
    @Given("^I am on feedback page$")
    public void IAmOnFeedbackPage(){
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }
    @When("^I enter name \"([^\"]*)\" for feedback$")
    public void EnterNameInFeedback(String personName){
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(personName);
    }
    @When("^I enter age (\\d+) for feedback$")
    public void IEnterAgeInFeedback(int personAge){
        driver.findElement(By.id("fb_age")).clear();
        driver.findElement(By.id("fb_age")).sendKeys(String.valueOf(personAge));
    }

    @When("^I click send button for feedback$")
    public void ClickSendFeedback(){
        driver.findElement(By.className("w3-btn-block")).click();
    }

    @Then ("^Check feedback shows name \"([^\"]*)\" and age (\\d+)$")
    public void assertNameAndAgeInFeedbackCheck(String personName, int personAge) {
        assertEquals(personName, driver.findElement(By.id("name")).getText());
        assertEquals(String.valueOf(personAge), driver.findElement(By.id("age")).getText());
    }

    //--------------------------------Task1.feature-----------------------------------------------------
    //-----------------# - Scenario outline for error cases. One example for each case:------------------

    @Given ("^I am on the page$")
    public void iAmOnThePage(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When ("^I enter ([^\"]*)$")
    public void iEnterIn(String in){
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(in);
    }

    @Then("^I click submit button$")
    public void iClickSubmit(){
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I have ([^\"]*)$")
    public void iHaveErrorMsg(String errorMsg) {
        assertEquals(errorMsg, driver.findElement(By.id("ch1_error")).getText());
    }

    //-----------------# - Scenario for correct number----------------------------------------
    @Given("^I am on the Enter a number page$")
    public void IAmOnTheEnterANumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }
    @Given ("^I am on enter a number page correct$")
    public void IAmOnEnterANumberPageCorrect(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }
    @When("^I enter number: \"(\\d+)\"$")
    public void IEnterValidInputNumber(String validNumber) {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(validNumber));
    }
    @And("^I click on Submit button$")
    public void IClickOnSubmitButton() {
        driver.findElement(By.className("w3-btn-block")).click();
    }
    @Then("^I see the result message \"([^\"]*)\"$")
    public void ISeeTheCorrectResult(String finalResult) {
        assertEquals(finalResult, driver.switchTo().alert().getText());
    }

//----------------------------------    Sample4.feature--------------------------------------


    @When ("^I select feedback languages$")
    public void ISelectFeedbackLanguages(List<String> languages) {
        for (String language : languages) {
            driver.findElement(By.xpath("//*[@value='" + language + "']")).click();
        }
    }
    @Then ("^I can see languages \"([^\"]*)\" in feedback check$")
            public void ICanSeeLanguagesInFeedbackCheck(String languages)throws Exception {
        Thread.sleep(2000);
        assertEquals(languages, driver.findElement(By.id("language")).getText());
        }
//----------------------------------    Sample5.feature--------------------------------------

    @When ("^I set feedback values$")
    public void SetFeedbackValues(Map<String, String> inputValues) {
     //   EnterNameInFeedback(inputValues.get("name"));
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(inputValues.get("name"));
        driver.findElement(By.id("fb_age")).clear();
        driver.findElement(By.id("fb_age")).sendKeys(inputValues.get("age"));
        driver.findElement(By.xpath("//*[@value=\"" +inputValues.get("genre").toLowerCase()+"\"]")).click();
    }
    @Then ("^I can see entered values in feedback check$")
    public void ICanSeeEnteredValuesInFeedbackCheck(Map<String, String> inputValues){
        assertEquals(inputValues.get("name"), driver.findElement(By.id("name")).getText());
        assertEquals(inputValues.get("age"), driver.findElement(By.id("age")).getText());
        assertEquals(inputValues.get("genre").toLowerCase(), driver.findElement(By.id("gender")).getText());

    }

    //----------------------------------Task2.feature---------------------------------------------

    @Given ("^I am on people with jobs page$")
    public void IAmOnPeopleWithJobsPage(){
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }
    @Then ("^I click add person button$")
    public void IClickAddPersonButton(){
        driver.findElement(By.id ("addPersonBtn")).click();
    }
    @And ("^I add a Name and Job$")
    public void IAddANameAndJob(Map<String, String> inputNJ) {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(inputNJ.get("name"));
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(inputNJ.get("job"));
    }

    @And("^I click clear button$")
    public void iClickClearButton(){
        driver.findElement(By.xpath("//*[@onclick = 'openModalForAddPersonWithJob()']")).click();
    }

    @And("^I check if fields are clear$")
    public void iCheckIfFieldsAreClear(){
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());

    }

    @Then ("^I click the add button$")
    public void IClickTheAddButton(){
        driver.findElement(By.id("modal_button")).click();
    }
    @Then("^I check entered people$")
    public void iCheckEnteredPeople(Map<String,String> Person) {
        assertEquals(Person.get("name"), driver.findElement(By.xpath("//*[@id='person3']//*[@class='w3-xlarge name']")).getText());
        assertEquals(Person.get("job"), driver.findElement(By.xpath("//*[@id='person3']//*[@class='job']")).getText());

//        assertEquals(Person.get("name"), driver.findElement(By.id("name")).getText());
//        assertEquals(Person.get("job"), driver.findElement(By.id("job")).getText());

    }



    @Then ("^I click edit button$")
    public void iClickOnEditSymbol(){
        driver.findElement(By.xpath("//*[@onclick = 'openModalForEditPersonWithJob(0)']")).click();
    }
//    public void IClickEditButton(){
//        driver.findElement(By.xpath("//li[@id='person3']//span[contains(@class,'editbtn')]"));
//    }

//    @And ("^I edit a persons credentials$")
//    public void IEditAPersonsCredentials(String None){
//        driver.findElement(By.id("name")).clear();
//        driver.findElement(By.id("name")).sendKeys("None");
//
//    }

    @Then("^I edit a job field: \"([^\"]*)\"$")
    public void iEditJobField(String Nope)  throws Throwable{
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(Nope);
    }

    @Then ("^I check changed person credentials \"([^\"]*)\"$")   //quotation marks in scenario
    public void ICheckChangedPersonCredentials(String None){
        assertEquals(None,driver.findElement(By.xpath("//*[@id='person0']//*[@class='job']")).getText());

    }

    @Then ("^I click edit confirm button$")
    public void IClickEditConfirmButton(){
        driver.findElement(By.id("modal_button")).click();
    }

    @And ("^I remove a person$")
    public void IRemoveAPerson(){
        driver.findElement(By.xpath("//li[@id='person2']//span[contains(@class,'closebtn')]")).click();
    }

    @Then ("^I check if i removed the person$")
    public void ICheckIfIRemovedThePerson(){
        List<WebElement> list = driver.findElements(By.className("w3-padding-16"));
        list.forEach(webElement -> {
            if(webElement.getText().contains("Jane")){
                fail();
            }
        });
    }

    @Then ("^I reset the list$")
    public void IResetTheList(){
        driver.findElement(By.xpath("//button[@onclick = 'resetListOfPeople()']")).click();
    }

}