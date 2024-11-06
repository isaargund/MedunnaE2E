package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePages;
import pages.LoginPages;
import utilities.ConfigReader;
import utilities.Driver;






public class SignInStepDefs {
    HomePages homePage=new HomePages();
    LoginPages login=new LoginPages();


    @Given("admin goes to {string} homepage")
    public void adminGoesToHomepage(String url) {
        Driver.getDriver().get(url);
    }

    @And("clicks on userIcon")
    public void clicksOnUserIcon() {
        homePage.userIcon.click();
    }

    @And("clicks on signIn option")
    public void clicksOnSignInOption() {
        homePage.signInOption.click();
    }

    @And("enters username in the Username field")
    public void entersUsernameInTheUsernameField() {
        login.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
    }

    @And("enters password in the Password field")
    public void entersPasswordInThePasswordField() {
        login.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
    }

    @And("clicks on signIn button")
    public void clicksOnSignInButton() {
        login.signInSubmitButton.click();
    }

    @And("clicks on Room option")
    public void clicksOnRoomOption() {
        login.roomOption.click();

    }


}
