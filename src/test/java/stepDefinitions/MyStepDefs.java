package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepDefs {

    private WebDriver driver;

    @Given("I fill all the required fields on the registration form")
    public void iFillAllTheRequiredFieldsOnTheRegistrationForm() {

        driver.findElement(By.name("DateOfBirth")).sendKeys("05/02/1998");
        driver.findElement(By.name("Forename")).sendKeys("Kalle");
        driver.findElement(By.name("Surname")).sendKeys("Pettersson");
        driver.findElement(By.name("EmailAddress")).sendKeys("testForSelenium@example.com");
        driver.findElement(By.name("ConfirmEmailAddress")).sendKeys("testForSelenium@example.com");
        driver.findElement(By.name("Password")).sendKeys("password");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("password");

        WebElement acceptTerms = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/label/span[3]"));
        acceptTerms.click();
        WebElement over18 = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[2]/label/span[3]"));
        over18.click();
        WebElement codeOfEthics = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3]"));
        codeOfEthics.click();
    }

    @When("I click the register button")
    public void iClickTheRegisterButton() {
        driver.findElement(By.name("join")).click();
    }

    @Then("I should be redirected to the success page")
    public void iShouldBeRedirectedToTheSuccessPage() {
        String actualUrl = driver.getCurrentUrl();
        boolean isRedirected = actualUrl.contains("SignUpConfirmation");
        assertTrue("The url is not correct!", isRedirected);
    }

    @Given("I fill all the required fields except lastname")
    public void iFillAllTheRequiredFieldsExceptLastname() {

        driver.findElement(By.name("DateOfBirth")).sendKeys("05/02/1998");
        driver.findElement(By.name("Forename")).sendKeys("Kalle");
        driver.findElement(By.name("EmailAddress")).sendKeys("testForSelenium@example.com");
        driver.findElement(By.name("ConfirmEmailAddress")).sendKeys("testForSelenium@example.com");
        driver.findElement(By.name("Password")).sendKeys("password");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("password");

        WebElement acceptTerms = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/label/span[3]"));
        acceptTerms.click();
        WebElement over18 = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[2]/label/span[3]"));
        over18.click();
        WebElement codeOfEthics = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3]"));
        codeOfEthics.click();
    }

    @Then("Error message appears for the missing field lastname")
    public void errorMessageAppearsForTheMissingFieldLastname() {
        WebElement field = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span"));
        String actual = field.getText();
        String expected = "Last Name is required";
        System.out.println("I receive the result " + actual);
        assertEquals(expected, actual);
    }

    @Given("I fill all the required fields with mismatched passwords")
    public void iFillAllTheRequiredFieldsWithMismatchedPasswords() {

        driver.findElement(By.name("DateOfBirth")).sendKeys("05/02/1998");
        driver.findElement(By.name("Forename")).sendKeys("Kalle");
        driver.findElement(By.name("Surname")).sendKeys("Pettersson");
        driver.findElement(By.name("EmailAddress")).sendKeys("testForSelenium@example.com");
        driver.findElement(By.name("ConfirmEmailAddress")).sendKeys("testForSelenium@example.com");

        WebElement acceptTerms = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/label/span[3]"));
        acceptTerms.click();
        WebElement over18 = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[2]/label/span[3]"));
        over18.click();
        WebElement codeOfEthics = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3]"));
        codeOfEthics.click();

        driver.findElement(By.name("Password")).sendKeys("password");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("password1");
    }

    @Then("Error message appears for the password mismatch")
    public void errorMessageAppearsForThePasswordMismatch() {
        WebElement field = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span"));
        String actual = field.getText();
        String expected = "Password did not match";
        System.out.println("I receive the result " + actual);
        assertEquals(expected, actual);
    }

    @Given("I'm on the registration form page {string}")
    public void iMOnTheRegistrationFormPage(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Given("I fill all the required fields except terms and conditions")
    public void iFillAllTheRequiredFieldsExceptTermsAndConditions() {

        driver.findElement(By.name("DateOfBirth")).sendKeys("05/02/1998");
        driver.findElement(By.name("Forename")).sendKeys("Kalle");
        driver.findElement(By.name("Surname")).sendKeys("Pettersson");
        driver.findElement(By.name("EmailAddress")).sendKeys("testForSelenium@example.com");
        driver.findElement(By.name("ConfirmEmailAddress")).sendKeys("testForSelenium@example.com");
        driver.findElement(By.name("Password")).sendKeys("password");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("password");

        WebElement over18 = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[2]/label/span[3]"));
        over18.click();
        WebElement codeOfEthics = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3]"));
        codeOfEthics.click();
    }

    @Then("I get this error message {string}")
    public void iGetThisErrorMessage(String expected) {
        WebElement field = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span"));
        String actual = field.getText();
        System.out.println("I receive the result " + actual);
        assertEquals(expected, actual);
    }
}
